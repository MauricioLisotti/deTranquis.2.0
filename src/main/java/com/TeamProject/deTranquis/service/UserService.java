package com.TeamProject.deTranquis.service;


import com.TeamProject.deTranquis.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    User getUser(String username);

    User saveUser(User user);

    String deleteUser(Long id);

    String updateUsuario(User userNew);


}



