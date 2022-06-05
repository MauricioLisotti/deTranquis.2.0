package com.TeamProject.deTranquis.controllers;

import java.util.List;
import java.util.Optional;
import com.TeamProject.deTranquis.model.Promocion;

public interface PromocionController {

    public List<Promocion> getPromocion();

    public Optional<Promocion> getPromocionById(Long id);

    public Promocion addPromocion(Promocion promocion);

    public String deletePromocion(Long id);

    public String updatePromocion(Promocion promocionNew);

    public String testPromocion();

}