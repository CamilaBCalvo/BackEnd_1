package com.example.EntregaFinal_2.controller;

import com.example.EntregaFinal_2.domain.Paciente;
import com.example.EntregaFinal_2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PacienteController {

    // Tenes que tener un servicio como primer paràmetro
    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @GetMapping("/index")
    public String encontrarPacienteXEmail(Model model, @RequestParam("email") String email){
        //buscar al paciente con el email y devolver la rta
        Paciente paciente =pacienteService.buscarXEmail(email);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "index"; //retornas el nombre de la vista
    }
}
