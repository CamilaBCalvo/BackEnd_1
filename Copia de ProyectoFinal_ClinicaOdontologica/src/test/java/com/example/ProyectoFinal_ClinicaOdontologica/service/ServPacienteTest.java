package com.example.ProyectoFinal_ClinicaOdontologica.service;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Domicilio;
import com.example.ProyectoFinal_ClinicaOdontologica.domain.Paciente;
import com.example.ProyectoFinal_ClinicaOdontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ServPacienteTest {

    @Autowired
    private ServPaciente servPaciente;
    @Test
    @Order(1)
    public void registrarPacienteTest(){
        Domicilio domicilioARegistrar1 = new Domicilio("Calle 1","123","Localidad1","Provincia1");
        Paciente pacienteARegistrar1 = new Paciente ("Apellido2","Nombre2","22222",
                LocalDate.of(2023,4,8),domicilioARegistrar1,"email2@gmail.com");

        Domicilio domicilioARegistrar2 = new Domicilio("Calle 12","122","Localidad2","Provincia2");
        Paciente pacienteARegistrar2 = new Paciente ("Apellido1","Nombre1","11111",
                LocalDate.of(2023,4,8),domicilioARegistrar2,"email1@gmail.com");

        Paciente pacienteGuardado1= servPaciente.registrarPaciente(pacienteARegistrar1);
        Paciente pacienteGuardado2= servPaciente.registrarPaciente(pacienteARegistrar2);
        assertEquals(1L,pacienteGuardado1.getId());
        assertEquals(2L,pacienteGuardado2.getId());
    }

    @Test
    @Order(2)
    public void buscarPacienteTest() {
        Long idBuscado = 1L;
        Optional<Paciente> pacienteBuscado = servPaciente.buscarPaciente(idBuscado);
        assertTrue(pacienteBuscado.isPresent());
    }

    @Test
    @Order(3)
    public void actualizarPacienteTest() {
        Long idPaciente = 1L;
        Optional<Paciente> pacienteBuscado = servPaciente.buscarPaciente(idPaciente);
        if (pacienteBuscado.isPresent()) {
            Paciente pacienteAActualizar = pacienteBuscado.get();
            pacienteAActualizar.setApellido("PacienteConApellidoActualizado");
            Paciente pacienteActualizado = servPaciente.actualizarPaciente(pacienteAActualizar);
            assertEquals(pacienteAActualizar.getApellido(), pacienteActualizado.getApellido());
        } else {
            fail("El paciente con id: " + idPaciente + ", no se encontró.");
        }
    }

    @Test
    @Order(4)
    public void listarPacientesTest() {
        List<Paciente> pacientes = servPaciente.buscarTodosPacientes();
        assertNotNull(pacientes);
        assertTrue(pacientes.size() > 0);
    }

    @Test
    @Order(5)
    public void eliminarPacienteTest() throws ResourceNotFoundException {
        Long idPaciente = 2L;
        servPaciente.eliminarPaciente(idPaciente);
        Optional<Paciente> pacienteBuscado = servPaciente.buscarPaciente(idPaciente);
        assertFalse(pacienteBuscado.isPresent());
    }
}