package com.example.EntregaFinal_2.service;

import com.example.EntregaFinal_2.dao.TurnoDAOLista;
import com.example.EntregaFinal_2.domain.Turno;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TurnoService {
    private TurnoDAOLista turnoIDao =new TurnoDAOLista();
    public Turno guardarTurno(Turno turno){
        return turnoIDao.guardar(turno);
    }

    public Turno buscarTurno(int id) {
        return turnoIDao.buscar(id);
    }
    public Optional<Turno> buscarTurnoOptional(int id){
        return turnoIDao.buscarOptional(id);
    }


}
