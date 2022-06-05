package com.TeamProject.deTranquis.serviceImpl;


import java.util.List;
import java.util.Optional;

import com.TeamProject.deTranquis.model.Usuario;
import com.TeamProject.deTranquis.repository.UsuarioRepository;
import com.TeamProject.deTranquis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;

    }

    @Override
    public Usuario saveUsuario(Usuario usuarioNew) {
        if (usuarioNew != null) {
            return usuarioRepository.save(usuarioNew);
        }
        return new Usuario();
    }

    @Override
    public String deleteUsuario(Long id) {
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRepository.deleteById(id);
            return "Usuario eliminado correctamente.";
        }
        return "Error! El usuario no existe";
    }

    @Override
    public String updateUsuario(Usuario usuarioUpdated) {
        Long num = usuarioUpdated.getId();
        if (usuarioRepository.findById(num).isPresent()) {
            Usuario usuarioToUpdate = new Usuario();
            usuarioToUpdate.setId(usuarioUpdated.getId());
            usuarioToUpdate.setNickname(usuarioUpdated.getNickname());
            usuarioToUpdate.setNombre(usuarioUpdated.getNombre());
            usuarioToUpdate.setApellido(usuarioUpdated.getApellido());
            usuarioToUpdate.setCorreo(usuarioUpdated.getCorreo());

            usuarioRepository.save(usuarioToUpdate);
            return "Usuario modificado";
        }
        return "Error al modificar el usuario.";
    }
}
