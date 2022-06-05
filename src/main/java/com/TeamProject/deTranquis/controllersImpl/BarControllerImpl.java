package com.TeamProject.deTranquis.controllersImpl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import com.TeamProject.deTranquis.controllers.BarController;
import com.TeamProject.deTranquis.model.Bar;
import com.TeamProject.deTranquis.service.BarService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Log
@CrossOrigin
@RestController
public class BarControllerImpl implements BarController {

    @Autowired
    BarService barService;

    // http://localhost:8888/bar (GET)
    @Override
    @RequestMapping(value = "/bar", method = RequestMethod.GET, produces = "application/json")
    public List<Bar> getBar() {
        return barService.findAllBars();
    }

    // http://localhost:8888/bar/1 (GET)
    @Override
    @RequestMapping(value = "/bar/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<Bar> getBarById(@PathVariable Long id) {
        return barService.findBarById(id);
    }


    // http://localhost:8888/bar/add (ADD)
    @Override
    @RequestMapping(value = "/bar/add", method = RequestMethod.POST, produces = "application/json")
    public Bar addBar(Bar bar) {
        return barService.saveBar(bar);
    }

    // http://localhost:8888/bar/delete/1 (GET)
    @Override
    @RequestMapping(value = "/bar/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String deleteBar(@PathVariable Long id) {
        return barService.deleteBar(id);
    }

    // http://localhost:8888/bar/update (PATCH)
    @Override
    @RequestMapping(value = "/bar/update", method = RequestMethod.PATCH, produces = "application/json")
    public String updateBar(Bar barNew) {
        return barService.updateBar(barNew);
    }

    // http://localhost:8888/bar/test (GET)
    @RequestMapping(value = "/bar/test", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String test() {
        return "Test done";
    }
}
