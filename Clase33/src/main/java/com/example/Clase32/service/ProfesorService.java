package com.example.Clase32.service;

import com.example.Clase32.entity.Profesor;
import com.example.Clase32.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {
    private ProfesorRepository profesorRepository;
    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }
    public Profesor guardarProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }

    public List<Profesor> listarProfesores(){
        return profesorRepository.findAll();
    }

}
