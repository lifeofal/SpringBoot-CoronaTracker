package com.lifeofal.coronaactivetracker.controllers;

import com.lifeofal.coronaactivetracker.models.LocationStats;
import com.lifeofal.coronaactivetracker.services.CoronaActiveTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller // not using Rest Controller so we can call html formats
public class HomeController {

    @Autowired
    CoronaActiveTrackerService coronaActiveTrackerService;

    @GetMapping("/")
    public String home(Model model){ //create a model to then construct it into the HTML
        model.addAttribute("locationStats", coronaActiveTrackerService.getAllStats());
        model.addAttribute("states", coronaActiveTrackerService.getUsaStates());
        return "home";

    }

//    @ModelAttribute("states")

}
