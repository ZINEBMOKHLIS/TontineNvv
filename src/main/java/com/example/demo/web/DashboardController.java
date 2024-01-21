package com.example.demo.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Tontine;
import com.example.demo.metier.TontineService;

@Controller
public class DashboardController {
	
    @Autowired
    private TontineService tontineService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        // Ajoutez la liste des tontines au modèle
        List<Tontine> tontines = tontineService.getAllTontines();
        model.addAttribute("tontines", tontines);

        // Ajoutez d'autres données au modèle si nécessaire
        model.addAttribute("welcomeMessage", "Welcome to the Tontine Dashboard!");

        // Récupérer le nom d'utilisateur à partir de l'objet Principal
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }

        return "dashboard";
    }

    @PostMapping("/dashboard")
    public String handleDashboardPost(Model model, Principal principal) {
        // Ajouter le traitement POST ici si nécessaire

        return "redirect:/dashboard";  // Redirige vers la page du tableau de bord après le traitement POST
    }
}
