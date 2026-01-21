package com.project.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import com.project.model.usersModel;
import com.project.repository.usersRepository;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class usersController {
    
    private final usersRepository userRepository;
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Retourne la page login.jsp
    }
    
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, 
                             @RequestParam String password) {
        
        // Logique d'authentification (simplifiée)
        usersModel user = userRepository.findByEmail(email);
        
        if (user != null && validatePassword(password, user.getPassword())) {
            // Login réussi - redirection vers index.jsp
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("user", user);
            modelAndView.addObject("message", "Connexion réussie !");
            return modelAndView;
        } else {
            // Login échoué - retour à la page de login avec erreur
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Email ou mot de passe incorrect");
            return modelAndView;
        }
    }
    
    @GetMapping("/logout")
    public String logout() {
        // Redirection vers login après déconnexion
        return "redirect:/users/login";
    }
    
    private boolean validatePassword(String rawPassword, String hashedPassword) {
        // Logique de validation du mot de passe
        // Ici vous devriez utiliser BCrypt ou un autre algorithme de hachage
        return rawPassword.equals(hashedPassword); // Simplifiée pour l'exemple
    }
}
