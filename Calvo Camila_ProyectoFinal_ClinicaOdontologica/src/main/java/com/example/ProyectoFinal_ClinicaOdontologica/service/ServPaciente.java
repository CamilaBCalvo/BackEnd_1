package com.example.ProyectoFinal_ClinicaOdontologica.service;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Paciente;
import com.example.ProyectoFinal_ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ProyectoFinal_ClinicaOdontologica.repository.RepPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServPaciente {
    private RepPaciente repPaciente;
    @Autowired
    public ServPaciente(RepPaciente repPaciente) {
        this.repPaciente = repPaciente;
    }
    public Paciente registrarPaciente(Paciente paciente){
        return repPaciente.save(paciente);
    }
    public Paciente actualizarPaciente(Paciente paciente){
        return repPaciente.save(paciente);
    }
    public Optional<Paciente> buscarPaciente(Long id){
        return repPaciente.findById(id);
    }
    public List<Paciente> buscarTodosPacientes() {
        return repPaciente.findAll();
    }
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado = repPaciente.findById(id);
        if(pacienteBuscado.isPresent()){
            repPaciente.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe el paciente con id = " + id);
        }
    }
}

