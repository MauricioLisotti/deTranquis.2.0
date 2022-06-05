package com.TeamProject.deTranquis.controllersImpl;

import java.util.List;
import java.util.Optional;
import com.TeamProject.deTranquis.controllers.PromocionController;
import com.TeamProject.deTranquis.model.Promocion;
import com.TeamProject.deTranquis.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PromocionControllerImpl implements PromocionController {

    @Autowired
    PromocionService promocionService;

    // http://localhost:8888/promocion (GET)
    @RequestMapping(value = "/promocion", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Promocion> getPromocion() {
        return promocionService.findAllPromocion();
    }

    // http://localhost:8888/promocion/1 (GET)
    @Override
    @RequestMapping(value = "/promocion/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<Promocion> getPromocionById(@PathVariable Long id) {
        return promocionService.findPromocionById(id);
    }

    // http://localhost:8888/promocion/add (ADD)
    @Override
    @RequestMapping(value = "/promocion/add", method = RequestMethod.POST, produces = "application/json")
    public Promocion addPromocion(Promocion promocion) {
        return promocionService.savePromocion(promocion);
    }

    // http://localhost:8888/promocion/delete/1 (GET)
    @Override
    @RequestMapping(value = "/promocion/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String deletePromocion(@PathVariable Long id) {
        return promocionService.deletePromocion(id);

    }

    // http://localhost:8888/promocion/update (PATCH)
    @Override
    @RequestMapping(value = "/promocion/update", method = RequestMethod.PATCH, produces = "application/json")
    public String updatePromocion(Promocion promocionNew) {
        return promocionService.updatePromocion(promocionNew);
    }

    // http://localhost:8888/test (GET)
    @RequestMapping(value = "/promocion/test", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String testPromocion() {
        return "Test done";
    }

}
