package com.TeamProject.deTranquis.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.TeamProject.deTranquis.model.Bar;

public interface BarService {

    public List<Bar> findAllBars();

    public Optional<Bar> findBarById(Long id);

    public Bar saveBar(Bar barNew);

    public String deleteBar(Long id);

    public String updateBar(Bar barNew);
}