package com.TeamProject.deTranquis.service;


import com.TeamProject.deTranquis.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> findAllUsuarios();

    public Optional<Usuario> findUsuarioById(Long id);

    public Usuario saveUsuario(Usuario usuarioNew);

    public String deleteUsuario(Long id);

    public String updateUsuario(Usuario usuarioNew);
}