package com.example.EntregaFinal_2.service;

import com.example.EntregaFinal_2.dao.PacienteDAOH2;
import com.example.EntregaFinal_2.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
    public List<Paciente> buscarTodosPacientes(){

        return pacienteDAOH2.buscarTodos();
    }
    public Paciente buscarXEmail(String email){
        return pacienteDAOH2.buscarXCriterioString(email);
    }
}
