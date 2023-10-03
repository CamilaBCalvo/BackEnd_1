package com.example.Clase22_PlayGround.service;

import com.example.Clase22_PlayGround.dominio.Usuario;

public class UsuarioService {
    public Usuario crearUsuario(){
        Usuario usuario = new Usuario("Diego", 25);
        return usuario;
    };
}
