package com.lifeofal.coronaactivetracker.controllers;

import com.lifeofal.coronaactivetracker.models.LocationStats;
import com.lifeofal.coronaactivetracker.services.CoronaActiveTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller // not using Rest Controller so we can call html formats
public class HomeController {

    @Autowired
    CoronaActiveTrackerService coronaActiveTrackerService;

    @GetMapping("/")
    public String home(Model model, String stateSelected){ //create a model to then construct it into the HTML
        model.addAttribute("states", coronaActiveTrackerService.getUsaStates());
        if(stateSelected != null && !stateSelected.equals("USA")) {
            model.addAttribute("locationStats", coronaActiveTrackerService.getStateSelected(stateSelected));
        }
        else {
            model.addAttribute("locationStats", coronaActiveTrackerService.getAllStats());
        }

        return "home";

    }

//    @GetMapping("/state={stateSelected}")
//    public String stateSelect(Model model, @PathVariable("stateSelected") String stateSelected){
//        if(!stateSelected.equals("USA")) {
//            model.addAttribute("selectedState", coronaActiveTrackerService.getStateSelected(stateSelected));
//        }
//        else {
//
//        }
//
//        return "stateSelect";
//    }

//    @ModelAttribute("states")

}
