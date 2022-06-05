package com.TeamProject.deTranquis.controllers;

import java.util.List;
import java.util.Optional;
import com.TeamProject.deTranquis.model.Bar;

public interface BarController {

    public List<Bar> getBar();

    public Optional<Bar> getBarById(Long id);

    public Bar addBar(Bar bar);

    public String deleteBar(Long id);

    public String updateBar(Bar barNew);

    public String test();

}
