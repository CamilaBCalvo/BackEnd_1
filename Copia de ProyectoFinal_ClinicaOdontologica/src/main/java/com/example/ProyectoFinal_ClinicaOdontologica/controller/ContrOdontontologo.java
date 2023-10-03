package com.example.ProyectoFinal_ClinicaOdontologica.controller;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Odontologo;
import com.example.ProyectoFinal_ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal_ClinicaOdontologica.service.ServOdontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class ContrOdontontologo {
    private ServOdontologo servOdontologo;

    @Autowired
    public ContrOdontontologo(ServOdontologo servOdontologo) {
        this.servOdontologo = servOdontologo;
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(servOdontologo.registrarOdontologo(odontologo));
    }
    @PutMapping
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo){
        return servOdontologo.actualizarOdontologo(odontologo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id){
        Optional<Odontologo> odontologoBuscado = servOdontologo.buscarOdontologo(id);
        if (odontologoBuscado.isPresent()) {
            return ResponseEntity.ok(odontologoBuscado.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodosOdontolodos(){
        return ResponseEntity.ok(servOdontologo.buscarTodosOdontologos());
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        servOdontologo.eliminarOdontologo(id);
        return ResponseEntity.ok("Eliminación del odontologo con id: " + id + " con éxito");
    }
}
