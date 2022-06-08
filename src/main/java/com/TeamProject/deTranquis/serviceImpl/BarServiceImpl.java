package com.TeamProject.deTranquis.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.TeamProject.deTranquis.model.Bar;
import com.TeamProject.deTranquis.repository.BarRepository;
import com.TeamProject.deTranquis.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BarServiceImpl implements BarService {

    @Autowired
    BarRepository barRepository;

    @Override
    public List<Bar> findAllBars() {
        return barRepository.findAll();
    }


    @Override
    public Optional<Bar> findBarById(Long id) {
        Optional<Bar> bar = barRepository.findById(id);
        return bar;
    }

    @Override
    public Bar saveBar(Bar barNew) {
        if (barNew != null) {
            return barRepository.save(barNew);
        }
        return new Bar();
    }

    @Override
    public String deleteBar(Long id) {
        if (barRepository.findById(id).isPresent()) {
            barRepository.deleteById(id);
            return "Bar eliminado correctamente.";
        }
        return "Error! El bar no existe";
    }


    @Override
    public String updateBar(Bar barUpdated) {
        Long num = barUpdated.getIdBar();
        if (barRepository.findById(num).isPresent()) {
            Bar barToUpdate = new Bar();
            barToUpdate.setIdBar(barUpdated.getIdBar());
            barToUpdate.setNombre(barUpdated.getNombre());
            barToUpdate.setTelefono(barUpdated.getTelefono());
            barToUpdate.setImagenbar(barUpdated.getImagenbar());
            barToUpdate.setDireccion(barUpdated.getDireccion());
            barToUpdate.setCatprecio(barUpdated.getCatprecio());
            barToUpdate.setArea(barUpdated.getArea());
            barToUpdate.setCategoria(barUpdated.getCategoria());
            barToUpdate.setDescripcion(barUpdated.getDescripcion());
            barToUpdate.setEspecialidades(barUpdated.getEspecialidades());
            barToUpdate.setRedessociales(barUpdated.getRedessociales());
            barToUpdate.setIduserprop(barUpdated.getIduserprop());



            barRepository.save(barToUpdate);
            return "Bar modificado";
        }
        return "Error al modificar el bar";
    }
}
