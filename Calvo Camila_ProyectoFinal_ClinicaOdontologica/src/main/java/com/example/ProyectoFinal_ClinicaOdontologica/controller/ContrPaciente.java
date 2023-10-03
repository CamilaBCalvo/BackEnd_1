package com.example.ProyectoFinal_ClinicaOdontologica.controller;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Paciente;
import com.example.ProyectoFinal_ClinicaOdontologica.exceptions.BadRequestException;
import com.example.ProyectoFinal_ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal_ClinicaOdontologica.service.ServPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class ContrPaciente {

    private ServPaciente servPaciente;

    @Autowired
    public ContrPaciente(ServPaciente pacienteService){
        this.servPaciente = pacienteService;
    }

    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return servPaciente.registrarPaciente(paciente);
    }

    @PutMapping
    public ResponseEntity<String> actualizarPaciente(@RequestBody Paciente paciente) throws BadRequestException{
        ResponseEntity<String> respuesta;
        if(paciente.getId() != null ){
            respuesta = ResponseEntity.ok(String.valueOf(servPaciente.actualizarPaciente(paciente)));
        } else {
            throw new BadRequestException("Id del paciente o del domicilio faltantes");
        }
        return respuesta;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id) {
        Optional<Paciente> pacienteBuscado = servPaciente.buscarPaciente(id);
        if (pacienteBuscado.isPresent()) {
            return ResponseEntity.ok(pacienteBuscado.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodosPacientes(){
        return ResponseEntity.ok(servPaciente.buscarTodosPacientes());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        servPaciente.eliminarPaciente(id);
        return ResponseEntity.ok("Eliminación del paciente con id: " + id + " con éxito");
    }
}
