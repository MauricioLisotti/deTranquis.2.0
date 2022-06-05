package com.TeamProject.deTranquis.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.TeamProject.deTranquis.model.Horario;
import com.TeamProject.deTranquis.repository.HorarioRepository;
import com.TeamProject.deTranquis.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    HorarioRepository horarioRepository;

    @Override
    public List<Horario> findAllHorario() {
        return horarioRepository.findAll();
    }

    @Override
    public Optional<Horario> findHorarioById(Long id) {
        Optional<Horario> horario = horarioRepository.findById(id);
        return horario;
    }

    @Override
    public Horario saveHorario(Horario horarioNew) {
        if (horarioNew != null) {
            return horarioRepository.save(horarioNew);
        }
        return new Horario();
    }

    @Override
    public String deleteHorario(Long id) {
        if (horarioRepository.findById(id).isPresent()) {
            horarioRepository.deleteById(id);
            return "Horario eliminado correctamente.";
        }
        return "Error! El horario no existe";
    }

    @Override
    public String updateHorario(Horario horarioUpdated) {
        Long num = horarioUpdated.getIdHorario();
        if (horarioRepository.findById(num).isPresent()) {
            Horario horarioToUpdate = new Horario();
            horarioToUpdate.setIdHorario(horarioUpdated.getIdHorario());
            horarioToUpdate.setDia(horarioUpdated.getDia());
            horarioToUpdate.setHorarioApertura(horarioUpdated.getHorarioApertura());
            horarioToUpdate.setHorarioCierre(horarioUpdated.getHorarioCierre());

            horarioRepository.save(horarioToUpdate);
            return "Horario modificado";
        }
        return "Error al modificar el horario";
    }


}
