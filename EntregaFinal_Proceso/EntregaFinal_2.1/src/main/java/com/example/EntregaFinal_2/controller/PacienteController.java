package com.example.EntregaFinal_2.controller;

import com.example.EntregaFinal_2.domain.Paciente;
import com.example.EntregaFinal_2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    // Tenes que tener un servicio como primer paràmetro
    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }

    @PutMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizar(paciente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPaciente(@PathVariable Integer id){
        pacienteService.eliminarPaciente(id);
    }

    @GetMapping("/{email}")
    public Paciente buscarXEmail(@PathVariable String email){
        return pacienteService.buscarXEmail(email);
    }

    @GetMapping("/todos")
    public List<Paciente> buscarTodosPacientes(){
        return pacienteService.buscarTodosPacientes();
    }
}
