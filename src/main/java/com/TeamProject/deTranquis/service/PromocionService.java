package com.TeamProject.deTranquis.service;

import com.TeamProject.deTranquis.model.Promocion;

import java.util.List;
import java.util.Optional;


public interface PromocionService {


    public List<Promocion> findAllPromocion();

    public Optional<Promocion> findPromocionById(Long id);

    public Promocion savePromocion(Promocion promocionNew);

    public String deletePromocion(Long id);

    public String updatePromocion(Promocion promocionNew);



}

