package com.example.ejercicioPG.controller;
import com.example.ejercicioPG.dominio.Odontologo;
import com.example.ejercicioPG.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@Controller
@RequestMapping("odontologos")
public class OdontologoController {
    private final OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @GetMapping("/")
    public List<Odontologo> getOdontologos() {
        return odontologoService.listaOdontologos();
    }
}

