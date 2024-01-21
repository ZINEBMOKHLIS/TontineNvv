package com.example.demo.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Tontine;
import com.example.demo.metier.TontineService;
import com.example.demo.metier.UserService;

@Controller
@RequestMapping("/tontines")
public class TontineController {
    private final TontineService tontineService;
    private final UserService userService;

    @Autowired
    public TontineController(TontineService tontineService, UserService userService) {
        this.tontineService = tontineService;
        this.userService = userService;
    }

    @GetMapping("/admin-dashboar")
    public String tontineDashboard(Model model) {
        List<Tontine> tontines = tontineService.getAllTontines();
        model.addAttribute("tontines", tontines);
        return "tontineDashboard";
    }
    
    @GetMapping("/participants")
    public String listParticipantsByTontine(Model model) {
        List<Tontine> tontines = tontineService.getAllTontines();  // Obtenez la liste des tontines
        model.addAttribute("tontines", tontines);
        return "participants";
    }
    

    @GetMapping("/details")
    public String tontineDetails(@RequestParam("id") Long tontineId, Model model) {
        Tontine tontine = tontineService.getTontineById(tontineId);
        model.addAttribute("tontine", tontine);
        return "tontineDetails";
    }

    @PostMapping("/create")
    public String createTontine(Tontine tontine, Principal principal) {
        // Récupérer l'utilisateur actuel
        String username = principal.getName();
        
        // Créer la tontine en utilisant le service TontineService
        tontineService.createTontine(tontine, username);

        // Rediriger vers la page de tableau de bord ou une autre page appropriée
        return "redirect:/tontines/admin-dashboard";
    }



}