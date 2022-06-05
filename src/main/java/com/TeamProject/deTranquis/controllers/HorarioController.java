package com.TeamProject.deTranquis.controllers;

import com.TeamProject.deTranquis.model.Horario;

import java.util.List;
import java.util.Optional;


public interface HorarioController {

    public List<Horario> getHorario();

    public Optional<Horario> getHorarioById(Long id);

    public Horario addHorario(Horario horario);

    public String deleteHorario(Long id);

    public String updateHorario(Horario horarioNew);

    public String testHorario();


}
