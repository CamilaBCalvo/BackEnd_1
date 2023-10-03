package com.example.ProyectoFinal_ClinicaOdontologica.repository;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepPaciente extends JpaRepository <Paciente,Long> {
    Optional<Paciente> findByEmail(String email);
}
