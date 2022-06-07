package com.TeamProject.deTranquis.repository;

import com.TeamProject.deTranquis.model.Propietario;
import com.TeamProject.deTranquis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {

    User findByUsername(String username);

    void save(Optional<User> userToUpdate);

}