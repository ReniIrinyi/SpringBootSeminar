package com.CRUDwithThymeleaf.CRUD.API.with.Thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RestController {
    @GetMapping("/")
    public String showHome(){
        return "home";

    }

}
