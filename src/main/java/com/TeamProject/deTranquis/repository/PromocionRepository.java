package com.TeamProject.deTranquis.repository;


import java.util.Optional;

import com.TeamProject.deTranquis.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocionRepository extends JpaRepository<Promocion, Long>{

    Void save(Optional<Promocion> promocionToUpdate);

}
