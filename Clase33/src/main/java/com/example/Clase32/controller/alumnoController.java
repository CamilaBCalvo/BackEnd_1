package com.example.Clase32.controller;

import com.example.Clase32.entity.Alumno;
import com.example.Clase32.entity.Profesor;
import com.example.Clase32.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class alumnoController {
    private AlumnoService alumnoService;
    @Autowired
    public alumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }
    @PostMapping
    public ResponseEntity<Alumno> guardarAlumno (@RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnoService.guardarAlumno(alumno));
    }
    @GetMapping
    public ResponseEntity<List<Alumno>> buscarAlumno(){
        return ResponseEntity.ok(alumnoService.listarAlumnos());
    }
}
