package com.example.EntregaFinal_2.service;

import com.example.EntregaFinal_2.dao.DomicilioDAOH2;
import com.example.EntregaFinal_2.dao.IDao;
import com.example.EntregaFinal_2.dao.OdontologoDAOH2;
import com.example.EntregaFinal_2.dao.PacienteDAOH2;
import com.example.EntregaFinal_2.domain.Domicilio;
import com.example.EntregaFinal_2.domain.Odontologo;
import com.example.EntregaFinal_2.domain.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoDAOH2 odontologoDAOH2;

    public List<Odontologo> buscarTodosOdontologos() {
        return odontologoDAOH2.buscarTodos();
    }

    public Odontologo buscarOdontologo(int id) {
        return odontologoDAOH2.buscar(id);
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoDAOH2.guardar(odontologo);
    }

    public Odontologo actualizar(Odontologo odontologo) {
        return odontologoDAOH2.actualizar(odontologo);
    }

    public void eliminarOdontologo(Integer id) {
        odontologoDAOH2.eliminar(id);
    }

}
