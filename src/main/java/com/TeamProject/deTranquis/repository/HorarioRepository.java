package com.TeamProject.deTranquis.repository;

import java.util.Optional;

import com.TeamProject.deTranquis.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Long>{
    Void save(Optional<Horario> horarioToUpdate);
}
