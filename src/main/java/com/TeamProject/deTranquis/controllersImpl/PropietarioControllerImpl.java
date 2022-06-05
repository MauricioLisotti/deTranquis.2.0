package com.TeamProject.deTranquis.controllersImpl;


import java.util.List;
import java.util.Optional;

import com.TeamProject.deTranquis.controllers.PropietarioController;
import com.TeamProject.deTranquis.model.Propietario;
import com.TeamProject.deTranquis.service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PropietarioControllerImpl implements PropietarioController {

    @Autowired
    PropietarioService propietarioService;

    // http://localhost:8888/propietario (GET)
    @RequestMapping(value = "/propietario", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Propietario> getPropietario() {
        return propietarioService.findAllPropietarios();
    }

    // http://localhost:8888/propietario/1 (GET)
    @Override
    @RequestMapping(value = "/propietario/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<Propietario> getPropietarioById(@PathVariable Long id) {
        return propietarioService.findPropietarioById(id);
    }

    // http://localhost:8888/propietario/add (ADD)
    @Override
    @RequestMapping(value = "/propietario/add", method = RequestMethod.POST, produces = "application/json")
    public Propietario addPropietario(Propietario propietario) {
        return propietarioService.savePropietario(propietario);
    }

    // http://localhost:8888/propietario/delete/1 (GET)
    @Override
    @RequestMapping(value = "/propietario/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String deletePropietario(@PathVariable Long id) {
        return propietarioService.deletePropietario(id);

    }

    // http://localhost:8888/propietario/update (PATCH)
    @Override
    @RequestMapping(value = "/propietario/update", method = RequestMethod.PATCH, produces = "application/json")
    public String updatePropietario(Propietario propietarioNew) {
        return propietarioService.updatePropietario(propietarioNew);
    }

    // http://localhost:8888/test (GET)
    @RequestMapping(value = "/propietario/test", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String test() {
        return "Test done";
    }

}