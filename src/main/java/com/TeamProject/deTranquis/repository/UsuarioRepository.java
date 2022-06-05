package com.TeamProject.deTranquis.repository;

import java.util.Optional;

import com.TeamProject.deTranquis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Void save(Optional<Usuario> usuarioToUpdate);
}
