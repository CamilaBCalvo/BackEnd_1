package com.example.ejercicioPG.service;

import com.example.ejercicioPG.dominio.Odontologo;

import java.util.Arrays;
import java.util.List;

public class OdontologoServiceImpl implements OdontologoService{
    @Override
    public List<Odontologo> listaOdontologos() {
        return Arrays.asList(new Odontologo("Javier"), new Odontologo("Ramon"));
    }
}
