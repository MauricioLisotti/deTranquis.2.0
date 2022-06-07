package com.TeamProject.deTranquis.serviceImpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.TeamProject.deTranquis.model.User;
import com.TeamProject.deTranquis.repository.UserRepository;
import com.TeamProject.deTranquis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;



@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User no found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        String plainPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userRepository.save(user);
        newUser.setPassword(plainPassword);
        return newUser;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        Optional<User> usuario = userRepository.findById(id);
        return usuario;
    }


    @Override
    public String deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "Usuario eliminado correctamente.";
        }
        return "Error! El usuario no existe";
    }

    @Override
    public String updateUsuario(User userUpdated) {
        Long num = userUpdated.getId();
        if (userRepository.findById(num).isPresent()) {
            User userToUpdate = new User();

           /* userToUpdate.setId(userUpdated.getId());
            userToUpdate.setNickname(userUpdated.getNickname());
            userToUpdate.setNombre(userUpdated.getNombre());
            userToUpdate.setApellido(userUpdated.getApellido());
            userToUpdate.setCorreo(userUpdated.getCorreo());
*/
            userRepository.save(userToUpdate);
            return "Usuario modificado";
        }
        return "Error al modificar el usuario.";
    }


}
