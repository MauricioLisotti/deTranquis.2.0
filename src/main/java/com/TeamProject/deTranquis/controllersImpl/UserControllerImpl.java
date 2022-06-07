package com.TeamProject.deTranquis.controllersImpl;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.*;

import java.util.Optional;
import com.TeamProject.deTranquis.controllers.UserController;
import com.TeamProject.deTranquis.model.User;
import com.TeamProject.deTranquis.service.UserService;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;

@CrossOrigin
@RestController
public class UserControllerImpl  {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 10000))
                        .withIssuer(request.getRequestURL().toString())
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }


    // http://localhost:8888/usuario (GET)
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public List<User> getUser() {
        return userService.findAllUsers();
    }

    // http://localhost:8888/usuario/1 (GET)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    // http://localhost:8888/user/add (ADD)
    @RequestMapping(value = "/user/add", method = RequestMethod.POST, produces = "application/json")
    public User save(User user) {
        return userService.saveUser(user);
    }

    // http://localhost:8888/usuario/delete/1 (GET)
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    // http://localhost:8888/usuario/update (PATCH)
    @RequestMapping(value = "/user/update", method = RequestMethod.PATCH, produces = "application/json")
    public String updateUser(User userNew) {
        return userService.updateUsuario(userNew);
    }

    // http://localhost:8888/usuario/test (GET)
    @RequestMapping(value = "/usuario/test", method = RequestMethod.GET, produces = "application/json")
    public String test() {
        return "Test done";
    }

}
