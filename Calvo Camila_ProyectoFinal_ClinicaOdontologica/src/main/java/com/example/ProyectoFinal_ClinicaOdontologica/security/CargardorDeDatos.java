package com.example.ProyectoFinal_ClinicaOdontologica.security;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Usuario;
import com.example.ProyectoFinal_ClinicaOdontologica.domain.UsuarioRol;
import com.example.ProyectoFinal_ClinicaOdontologica.repository.RepUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import static com.example.ProyectoFinal_ClinicaOdontologica.domain.UsuarioRol.ROLE_USER;

@Component
public class CargardorDeDatos implements ApplicationRunner {
    private RepUsuario repUsuario;
    @Autowired
    public CargardorDeDatos(RepUsuario repUsuario) {
        this.repUsuario = repUsuario;
    }
    @Override
    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();
        String passACifrar = "1234";
        String passCifrada = cifrador.encode(passACifrar);
        Usuario usuarioAInsertar = new Usuario(
                "Camila","Calvo","cc@gmail.com",passCifrada, UsuarioRol.ROLE_USER);
        repUsuario.save(usuarioAInsertar);
        String passACifrar2 = "5678";
        String passCifrada2 = cifrador.encode(passACifrar2);
        Usuario usuarioAdmin = new Usuario(
                "Florencia", "Calvo", "fc@gmail.com", passCifrada2,UsuarioRol.ROLE_ADMIN);
        repUsuario.save(usuarioAdmin);
    }
}
