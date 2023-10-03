package com.example.ProyectoFinal_ClinicaOdontologica.repository;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepOdontologo extends JpaRepository<Odontologo,Long> {
}
