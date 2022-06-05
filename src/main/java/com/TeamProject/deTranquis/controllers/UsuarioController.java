package com.TeamProject.deTranquis.controllers;


import com.TeamProject.deTranquis.model.Usuario;

import java.util.List;
import java.util.Optional;


public interface UsuarioController {

    public List<Usuario> getUsuario();

    public Optional<Usuario> getUsuarioById(Long id);

    public Usuario addUsuario(Usuario usuario);

    public String deleteUsuario(Long id);

    public String updateUsuario(Usuario usuarioNew);

    public String test();

}
