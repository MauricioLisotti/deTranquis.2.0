package com.TeamProject.deTranquis.repository;

import java.util.List;
import java.util.Optional;

import com.TeamProject.deTranquis.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BarRepository extends JpaRepository<Bar, Long>{

    Void save(Optional<Bar> barToUpdate);

}
