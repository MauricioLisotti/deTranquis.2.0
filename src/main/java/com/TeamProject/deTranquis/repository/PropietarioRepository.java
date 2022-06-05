package com.TeamProject.deTranquis.repository;

import java.util.Optional;
import com.TeamProject.deTranquis.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long>{
    Void save(Optional<Propietario> propietarioToUpdate);
}

