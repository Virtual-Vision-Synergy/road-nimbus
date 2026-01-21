package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Application fonctionne ! Test OK";
    }
    
    @GetMapping("/test-jsp")
    public String testJsp() {
        return "login"; // Test de résolution JSP
    }
}