package com.TeamProject.deTranquis.serviceImpl;


import java.util.List;
import java.util.Optional;

import com.TeamProject.deTranquis.model.Propietario;
import com.TeamProject.deTranquis.repository.PropietarioRepository;
import com.TeamProject.deTranquis.service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropietarioServiceImpl implements PropietarioService {

    @Autowired
    PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> findAllPropietarios() {
        return propietarioRepository.findAll();
    }

    @Override
    public Optional<Propietario> findPropietarioById(Long id) {
        Optional<Propietario> propietario = propietarioRepository.findById(id);
        return propietario;
    }

    @Override
    public Propietario savePropietario(Propietario propietarioNew) {
        if (propietarioNew != null) {
            return propietarioRepository.save(propietarioNew);
        }
        return new Propietario();
    }

    @Override
    public String deletePropietario(Long id) {
        if (propietarioRepository.findById(id).isPresent()) {
            propietarioRepository.deleteById(id);
            return "Propietario eliminado correctamente.";
        }
        return "Error! El propietario no existe";
    }

    @Override
    public String updatePropietario(Propietario propietarioUpdated) {
        Long num = propietarioUpdated.getIdProp();
        if (propietarioRepository.findById(num).isPresent()) {
            Propietario propietarioToUpdate = new Propietario();
            propietarioToUpdate.setIdProp(propietarioUpdated.getIdProp());
            propietarioToUpdate.setNombreUsuario(propietarioUpdated.getNombreUsuario());
            propietarioToUpdate.setClave(propietarioUpdated.getClave());
            propietarioToUpdate.setNombreProp(propietarioUpdated.getNombreProp());
            propietarioToUpdate.setApellidoProp(propietarioUpdated.getApellidoProp());
            propietarioToUpdate.setTelefonoProp(propietarioUpdated.getTelefonoProp());


            propietarioRepository.save(propietarioToUpdate);
            return "Propietario modificado";
        }
        return "Error al modificar el propietario";
    }

}
