package com.TeamProject.deTranquis.service;

import com.TeamProject.deTranquis.model.Horario;

import java.util.List;
import java.util.Optional;

public interface HorarioService {

    public List<Horario> findAllHorario();

    public Optional<Horario> findHorarioById(Long id);

    public Horario saveHorario(Horario horarioNew);

    public String deleteHorario(Long id);

    public String updateHorario(Horario horarioNew);

}

