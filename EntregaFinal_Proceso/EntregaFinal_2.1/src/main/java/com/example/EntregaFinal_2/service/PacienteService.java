package com.example.EntregaFinal_2.service;

import com.example.EntregaFinal_2.dao.DomicilioDAOH2;
import com.example.EntregaFinal_2.dao.IDao;
import com.example.EntregaFinal_2.dao.PacienteDAOH2;
import com.example.EntregaFinal_2.domain.Domicilio;
import com.example.EntregaFinal_2.domain.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Service
public class PacienteService {
    private PacienteDAOH2 pacienteDAOH2;
    @Autowired
    public PacienteService(PacienteDAOH2 pacienteDAOH2) {
        this.pacienteDAOH2 = pacienteDAOH2;
    }

    IDao<Domicilio> domicilioDAOH2 = new DomicilioDAOH2();

    public List<Paciente> buscarTodosPacientes() {
        return pacienteDAOH2.buscarTodos();
    }

    public Paciente buscarXEmail(String email) {
        return pacienteDAOH2.buscarXCriterioString(email);
    }

    public Paciente guardar(Paciente paciente) {
        domicilioDAOH2.guardar(paciente.getDomicilio());
        return pacienteDAOH2.guardar(paciente);
    }

    public Paciente actualizar(Paciente paciente) {
        return pacienteDAOH2.actualizar(paciente);
    }

    public void eliminarPaciente(Integer id) {
        pacienteDAOH2.eliminar(id);
    }

    public Paciente buscar(Integer id){
        return pacienteDAOH2.buscar(id);
    }
}

