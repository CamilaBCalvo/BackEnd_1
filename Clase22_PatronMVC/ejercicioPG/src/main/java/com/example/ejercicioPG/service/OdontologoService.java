package com.example.ejercicioPG.service;

import com.example.ejercicioPG.dominio.Odontologo;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
@Service
public interface OdontologoService {
    List<Odontologo> listaOdontologos();
}

