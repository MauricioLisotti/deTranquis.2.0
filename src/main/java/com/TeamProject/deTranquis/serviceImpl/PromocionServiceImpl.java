package com.TeamProject.deTranquis.serviceImpl;


import com.TeamProject.deTranquis.model.Promocion;
import com.TeamProject.deTranquis.repository.PromocionRepository;
import com.TeamProject.deTranquis.service.PromocionService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PromocionServiceImpl implements PromocionService {

    @Autowired
    PromocionRepository promocionRepository;

    @Override
    public List<Promocion> findAllPromocion() {
        return promocionRepository.findAll();
    }

    @Override
    public Optional<Promocion> findPromocionById(Long id) {
        Optional<Promocion> promocion = promocionRepository.findById(id);
        return promocion;
    }

    @Override
    public Promocion savePromocion(Promocion promocionNew) {
        if (promocionNew != null) {
            return promocionRepository.save(promocionNew);
        }
        return new Promocion();
    }

    @Override
    public String deletePromocion(Long id) {
        if (promocionRepository.findById(id).isPresent()) {
            promocionRepository.deleteById(id);
            return "promocion eliminado correctamente.";
        }
        return "Error! La promocion no existe";
    }

    @Override
    public String updatePromocion(Promocion promocionUpdated) {
        Long num = promocionUpdated.getIdPromocion();
        if (promocionRepository.findById(num).isPresent()) {
            Promocion promocionToUpdate = new Promocion();
            promocionToUpdate.setIdPromocion(promocionUpdated.getIdPromocion());
            promocionToUpdate.setTitulo(promocionUpdated.getTitulo());
            promocionToUpdate.setDescripcion(promocionUpdated.getDescripcion());
            promocionToUpdate.setUrlImagen(promocionUpdated.getUrlImagen());
            promocionToUpdate.setIdBar(promocionUpdated.getIdBar());

            promocionRepository.save(promocionToUpdate);
            return "Promocion modificada";
        }
        return "Error al modificar la promocion";
    }





}
