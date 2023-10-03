package com.example.ProyectoFinal_ClinicaOdontologica.repository;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepUsuario extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);
}
