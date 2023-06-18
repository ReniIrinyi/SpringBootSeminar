package com.CRUDwithThymeleaf.CRUD.API.with.Thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    @GetMapping("/managers")
    public String showManagers(){
        return "managers";
    }

    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
    @GetMapping("/access-denied")
    public String showErrorPage(){
        return "access-denied";
    }
}
