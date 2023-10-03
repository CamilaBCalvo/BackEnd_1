package com.example.Clase.service;

import com.example.Clase.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service //Avisa que esta clase es un servicio

public class EntrenadorServiceImpl implements EntrenadorService{
    @Override
    public List<Entrenador> listaEntrenadores() {
        //ir a trabajar con el DAo para comunicarse con la BD y traer la informacion
        return Arrays.asList(new Entrenador("Rodolfo"), new Entrenador("Ezequiel"));
    }
}
