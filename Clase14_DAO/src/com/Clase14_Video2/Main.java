package com.Clase14_Video2;

import com.Clase14_Video2.daos.EstudianteDAO_h2;
import com.Clase14_Video2.entidades.Estudiante;
import com.Clase14_Video2.servicios.EstudianteService;

public class Main {
    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante();

        estudiante.setId(1L);
        estudiante.setNombre("Javier");
        estudiante.setApellido("Rabuch");

        EstudianteService estudianteService = new EstudianteService();
        // Seteamos una estrategia de persistencia, es decir un DAO
        estudianteService.setEstudianteIDao(new EstudianteDAO_h2());

        estudianteService.guardarEstudiante(estudiante);



    }
}
