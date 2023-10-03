package com.example.ProyectoFinal_ClinicaOdontologica.service;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Domicilio;
import com.example.ProyectoFinal_ClinicaOdontologica.domain.Odontologo;
import com.example.ProyectoFinal_ClinicaOdontologica.domain.Paciente;
import com.example.ProyectoFinal_ClinicaOdontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest

class ServOdontologoTest {
    @Autowired
    private ServOdontologo servOdontologo;

    @Test
    @Order(1)
    public void registrarOdontologoTest(){
        Odontologo odontologoARegistrar1 = new Odontologo("OdontologoNombre1","OdontologoApellido1","MN111");
        Odontologo odontologoARegistrar2 = new Odontologo("OdontologoNombre2","OdontologoApellido2","MN222");
        Odontologo odontologoARegistrar3 = new Odontologo("OdontologoNombre3","OdontologoApellido3","MN333");

        Odontologo odontologoGuardado1 = servOdontologo.registrarOdontologo(odontologoARegistrar1);
        Odontologo odontologoGuardado2 = servOdontologo.registrarOdontologo(odontologoARegistrar2);
        Odontologo odontologoGuardado3 = servOdontologo.registrarOdontologo(odontologoARegistrar3);
        assertEquals(1L,odontologoGuardado1.getId());
        assertEquals(2L,odontologoGuardado2.getId());
        assertEquals(3L,odontologoGuardado3.getId());
    }

    @Test
    @Order(2)
    public void buscarOdontolotoTest(){
        Long idBuscado = 1L;
        Optional<Odontologo> odontologoBuscado = servOdontologo.buscarOdontologo(idBuscado);
        assertTrue(odontologoBuscado.isPresent());
    }

    @Test
    @Order(3)
    public void actualizarOdontologoTest(){
        Long idOdontologo = 1L;
        Optional<Odontologo> odontologoBuscado = servOdontologo.buscarOdontologo(idOdontologo);
        if(odontologoBuscado.isPresent()){
            Odontologo odontologoAActualizar = odontologoBuscado.get();
            odontologoAActualizar.setApellido("OdontologoConApellidoActualizado");
            Odontologo odontolgoActualizado = servOdontologo.actualizarOdontologo(odontologoAActualizar);
            assertEquals(odontologoAActualizar.getApellido(), odontolgoActualizado.getApellido());
        }else {
            fail("El odontologo con id: "+ idOdontologo + ", no se encontró");
        }
    }
    @Test
    @Order(4)
    public void listarOdontologosTest(){
        List<Odontologo> odontologos = servOdontologo.buscarTodosOdontologos();
        assertNotNull(odontologos);
        assertTrue(odontologos.size() > 0);
    }
    @Test
    @Order(5)
    public void eliminarOdontologoTest() throws ResourceNotFoundException {
        Long idOdontologo = 2L;
        servOdontologo.eliminarOdontologo(idOdontologo);
        Optional<Odontologo> odontologoBuscado = servOdontologo.buscarOdontologo(idOdontologo);
        assertFalse(odontologoBuscado.isPresent());
    }
}