package com.TeamProject.deTranquis.controllersImpl;

import java.util.List;
import java.util.Optional;
import com.TeamProject.deTranquis.controllers.UsuarioController;
import com.TeamProject.deTranquis.model.Usuario;
import com.TeamProject.deTranquis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    // http://localhost:8888/usuario (GET)
    @Override
    @RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = "application/json")
    public List<Usuario> getUsuario() {
        return usuarioService.findAllUsuarios();
    }

    // http://localhost:8888/usuario/id/1 (GET)
    @Override
    @RequestMapping(value = "/usuario/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findUsuarioById(id);
    }

    // http://localhost:8888/usuario/id/1 (GET)
    @Override
    @RequestMapping(value = "/usuario/username/{username}", method = RequestMethod.GET, produces = "application/json")
    public Usuario findByUsername(@PathVariable String username) {
        return usuarioService.getUsuario(username);
    }


    // http://localhost:8888/usuario/add (ADD)
    @Override
    @RequestMapping(value = "/usuario/add", method = RequestMethod.POST, produces = "application/json")
    public Usuario addUsuario(Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    // http://localhost:8888/usuario/delete/1 (GET)
    @Override
    @RequestMapping(value = "/usuario/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String deleteUsuario(@PathVariable Long id) {
        return usuarioService.deleteUsuario(id);

    }


    // http://localhost:8888/usuario/update (PATCH)
    @Override
    @RequestMapping(value = "/usuario/update", method = RequestMethod.PATCH, produces = "application/json")
    public String updateUsuario(Usuario usuarioNew) {
        return usuarioService.updateUsuario(usuarioNew);
    }


    // http://localhost:8888/usuario/test (GET)
    @RequestMapping(value = "/usuario/test", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String test() {
        return "Test done";
    }

}
