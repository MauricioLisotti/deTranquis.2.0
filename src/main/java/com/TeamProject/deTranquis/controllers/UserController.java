package com.TeamProject.deTranquis.controllers;

import com.TeamProject.deTranquis.model.User;
import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.net.URI;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@RestController
@RequestMapping("/user")
public interface UserController {

    public ResponseEntity<List<User>> getUsers();

    public ResponseEntity<User> saveUser();

    public void refreshToken();

    public Optional<User> getUserById(Long id);

    public User addUser(User user);

    public String deleteUser(Long id);

    public String updateUser(User userNew);

    public String test();

}
