package com.example.Clase32.service;

import com.example.Clase32.entity.Alumno;
import com.example.Clase32.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {
    private AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }
    public Alumno guardarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }
    public List<Alumno> listarAlumnos(){
        return alumnoRepository.findAll();
    }

}
