package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        // Rediriger vers la page de login
        return "redirect:/users/login";
    }
    
    @GetMapping("/home")
    public String homeAlias() {
        return "redirect:/users/login";
    }
}