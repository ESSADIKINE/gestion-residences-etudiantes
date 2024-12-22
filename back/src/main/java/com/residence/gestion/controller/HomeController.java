package com.residence.gestion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Bienvenue dans l'application de gestion des résidences !";
    }

    @GetMapping("/test-home")
    public String test() {
        return "Test depuis HomeController";
    }
}
