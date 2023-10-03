package com.example.ProyectoFinal_ClinicaOdontologica.service;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Odontologo;
import com.example.ProyectoFinal_ClinicaOdontologica.domain.Paciente;
import com.example.ProyectoFinal_ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal_ClinicaOdontologica.repository.RepOdontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServOdontologo {

    private RepOdontologo repOdontologo;

    @Autowired
    public ServOdontologo(RepOdontologo repOdontologo) {
        this.repOdontologo = repOdontologo;
    }
    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return repOdontologo.save(odontologo);
    }
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return repOdontologo.save(odontologo);
    }
    public Optional <Odontologo> buscarOdontologo(Long id){
        return repOdontologo.findById(id);
    }
    public List<Odontologo> buscarTodosOdontologos() {
        return repOdontologo.findAll();
    }
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado = repOdontologo.findById(id);
        if(odontologoBuscado.isPresent()){
            repOdontologo.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe el odontologo con id = " + id);
        }
    }

}
