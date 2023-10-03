package com.example.Clase25_LiveCoding.controller;

import com.example.Clase25_LiveCoding.dao.ConfiguracionJDBC;
import com.example.Clase25_LiveCoding.dao.MedicamentoDAO_h2;
import com.example.Clase25_LiveCoding.model.Medicamento;
import com.example.Clase25_LiveCoding.service.MedicamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicamentoController {
    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDAO_h2(new ConfiguracionJDBC()));

    @PostMapping("/registrar")
    public Medicamento guardar(Medicamento medicamento){
        return medicamentoService.guardarMedicamento(medicamento);
    }
    @GetMapping("/{id}")
    public Medicamento buscar(@PathVariable("id") Integer identificador){
        return medicamentoService.buscarMedicamento(Long.valueOf(identificador));
    }
}
