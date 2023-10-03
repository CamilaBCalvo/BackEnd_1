package com.example.EntregaFinal_2.controller;

import com.example.EntregaFinal_2.domain.Odontologo;
import com.example.EntregaFinal_2.domain.Paciente;
import com.example.EntregaFinal_2.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontontologoController {
    private OdontologoService odontologoService;

    @Autowired
    public OdontontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable int id){
        return odontologoService.buscarOdontologo(id);
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }

    @PutMapping
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.actualizar(odontologo);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarOdontologo(@PathVariable Integer id){
        odontologoService.eliminarOdontologo(id);
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodosOdontolodos(){
        return ResponseEntity.ok(odontologoService.buscarTodosOdontologos()); //tiene que tener el response entity
    };
}
