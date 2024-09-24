package com.example.courseprojectvm.controllers;

import com.example.courseprojectvm.entities.CatCitizen;
import com.example.courseprojectvm.services.CatCitizenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MvcController {

    private final CatCitizenService catCitizenService;

    public MvcController(CatCitizenService catCitizenService) {
        this.catCitizenService = catCitizenService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        long startTime = System.currentTimeMillis();
        List<CatCitizen> catCitizens = catCitizenService.findAll();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        model.addAttribute("backendExecutionTime", executionTime);
        model.addAttribute("catCitizensList", catCitizens);
        return "index";
    }
    @GetMapping("/albums")
    public String albums(Model model) {
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        model.addAttribute("backendExecutionTime", executionTime);
        return "albums";
    }
    @GetMapping("/citizenship")
    public String citizenship(Model model) {
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        model.addAttribute("backendExecutionTime", executionTime);
        return "citizenship";
    }
    @GetMapping("/history")
    public String history(Model model) {
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        model.addAttribute("backendExecutionTime", executionTime);
        return "history";
    }
    @GetMapping("/message")
    public String message(Model model) {
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        model.addAttribute("backendExecutionTime", executionTime);
        return "message";
    }

    @GetMapping("/register")
    public String register(Model model) {
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        model.addAttribute("backendExecutionTime", executionTime);
        return "register";
    }

    @GetMapping("/panel")
    public String panel(Model model) {
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        model.addAttribute("backendExecutionTime", executionTime);
        return "panel";
    }
}
