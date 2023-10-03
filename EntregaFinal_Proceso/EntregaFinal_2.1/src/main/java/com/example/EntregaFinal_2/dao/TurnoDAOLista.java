package com.example.EntregaFinal_2.dao;

import com.example.EntregaFinal_2.domain.Turno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class TurnoDAOLista implements IDao<Turno> {

    private List<Turno> turnos = new ArrayList<>();
    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(int id) {
        for (Turno turnoEnRevision:turnos) {
            if (turnoEnRevision.getId() == id){
                return turnoEnRevision;
            }
        }
        return null;
    } public Optional<Turno> buscarOptional(int id) {
        for (Turno turnoEnRevision:turnos) {
            if (turnoEnRevision.getId() == id){
                return Optional.of(turnoEnRevision);
            }
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(int id) {
        Turno buscado = buscar(id);
        if(buscado!=null){
            turnos.remove(buscado);
        }else {
            System.out.println("AGREGAR LOG");
        }
    }

    @Override
    public Turno actualizar(Turno turno) {
        int indice=turnos.indexOf(turno);
        turnos.set(indice,turno);
        return buscar(turno.getId());
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public Turno buscarXCriterioString(String criterio) {
        return null;
    }
}
