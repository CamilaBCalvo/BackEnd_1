package com.example.Clase32.controller;

import com.example.Clase32.entity.Profesor;
import com.example.Clase32.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class profesorController {
    private ProfesorService profesorService;
    @Autowired
    public profesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }
    @PostMapping
    public ResponseEntity<Profesor> guardarProfesor (@RequestBody Profesor profesor){
        return ResponseEntity.ok(profesorService.guardarProfesor(profesor));
    }
    @GetMapping
    public ResponseEntity<List<Profesor>> buscarProfesor(){
        return ResponseEntity.ok(profesorService.listarProfesores());
    }
}
