package com.example.ProyectoFinal_ClinicaOdontologica.service;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Usuario;
import com.example.ProyectoFinal_ClinicaOdontologica.repository.RepUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServUsuario implements UserDetailsService {
    private RepUsuario repUsuario;
    @Autowired
    public ServUsuario(RepUsuario repUsuario) {
        this.repUsuario = repUsuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado = repUsuario.findByEmail(username);
        if (usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }else{
            throw new UsernameNotFoundException("Error. Usuario con el email: " + username + "no encontrado en la BD");
        }
    }
}
