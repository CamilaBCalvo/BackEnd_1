package com.example.ProyectoFinal_ClinicaOdontologica.repository;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepTurno extends JpaRepository<Turno,Long> {
}
