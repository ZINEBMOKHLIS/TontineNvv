package com.example.demo.web;

import com.example.demo.entities.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.User;
import com.example.demo.metier.UserService;

@Controller
public class UserController{
	private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("error", ""); // Assurez-vous que l'attribut "error" est toujours défini
        return "login";

    }
    @PostMapping("/login")

    public String login(@ModelAttribute("user")
                        User user, Model model) {
        // Validate user credentials
        if (userService.authenticateUser(user.getEmail(), user.getPassword(), Role.ADMIN)) {
            // User authenticated as ADMIN
            return "redirect:/admin-dashboard";
        } else if (userService.authenticateUser(user.getEmail(), user.getPassword(), Role.USER)) {
            // User authenticated as USER
            return "redirect:/user-dashboard";
        } else {
            // Invalid credentials
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute("user") User user, Model model) {
//        // Vérifiez si l'utilisateur est authentifié
//        if (userService.authenticateUser(user.getEmail(), user.getPassword())) {
//            // Utilisateur authentifié avec succès
//            return "redirect:/dashboard";
//        } else {
//            model.addAttribute("error", "Invalid email or password");
//            return "login";
//        }
//    }

    
//    @PostMapping("/login")
//    public String login(@ModelAttribute("user") User user, Model model, Principal principal) {
//        // Vérifiez si principal est null avant de l'utiliser
//        if (principal != null) {
//            // Utilisez Principal pour obtenir l'utilisateur actuellement connecté
//            String email = principal.getName();
//
//            // Vérifiez si l'utilisateur est authentifié
//            if (userService.authenticateUser(user.getEmail(), user.getPassword())) {
//                // Utilisateur authentifié avec succès
//                return "redirect:/dashboard";
//            } else {
//                model.addAttribute("error", "Invalid email or password");
//                return "login";
//            }
//        } else {
//            // Principal est null, redirigez vers la page de login avec un message d'erreur
//            model.addAttribute("error", "User not authenticated");
//            return "login";
//        }
//    }
    
    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        // Vérifiez si l'utilisateur existe déjà
        if (userService.isUserExists(user.getEmail(), user.getRole())) {
            model.addAttribute("error", "User with this email and role already exists");
            return "register";
        }
        // Assign a default role if none is specified
        if (user.getRole() == null) {
            user.setRole(String.valueOf(Role.USER));
        }



        // Enregistrez le nouvel utilisateur
        userService.saveUser(user);
        return "redirect:/dashboard";
    }}
    
//    @PostMapping("/register")
//    public String register(@ModelAttribute("user") User user, Model model) {
//        // Vérifiez si l'utilisateur existe déjà
//        if (userService.isUserExists(user.getEmail())) {
//            model.addAttribute("error", "User with this email already exists");
//            return "register";
//        }
//
//        // Enregistrez le nouvel utilisateur
//        userService.saveUser(user);
//        return "redirect:/dashboard";
//    }


