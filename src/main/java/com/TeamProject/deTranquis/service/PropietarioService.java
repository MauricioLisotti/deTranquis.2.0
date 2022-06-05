package com.TeamProject.deTranquis.service;
import com.TeamProject.deTranquis.model.Propietario;

import java.util.List;
import java.util.Optional;


public interface PropietarioService{

    public List<Propietario> findAllPropietarios();

    public Optional<Propietario> findPropietarioById(Long id);

    public Propietario savePropietario(Propietario propietarioNew);

    public String deletePropietario(Long id);

    public String updatePropietario(Propietario propietarioNew);

}

