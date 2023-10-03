package com.example.Clase.controller;

import com.example.Clase.model.Entrenador;
import com.example.Clase.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Como lo vas a ver a traves de una API, tenes que agregar el RestController
@RequestMapping("/entrenadores")

public class EntrenadorController {
    private EntrenadorService entrenadorService;

    @Autowired //No es necesario, pero esta bien ponerlo. Pero esta bueno poder instanciarlo
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public List<Entrenador> obtenerListaEntrenadores(){
        return entrenadorService.listaEntrenadores();
    }
}
