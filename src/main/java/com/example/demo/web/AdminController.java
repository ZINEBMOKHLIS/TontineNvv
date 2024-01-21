package com.example.demo.web;

import com.example.demo.entities.Participant;
import com.example.demo.entities.User;
import com.example.demo.metier.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Tontine;
import com.example.demo.metier.AdminService;
import com.example.demo.metier.TontineService;
import com.example.demo.metier.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private TontineService tontineService;

    @Autowired
    private ParticipantService participantService;




    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        List<Tontine> tontines = tontineService.getAllTontines();
        List<User> users = userService.getAllUsers();
        List<Participant> participants = participantService.getAllParticipants();

        model.addAttribute("tontines", tontines);
        model.addAttribute("users", users);
        model.addAttribute("participants", participants);

        return "admin/admin-dashboard";
    }

    @GetMapping("/user/{id}")
    public String viewUserDetails(@PathVariable Long id, Model model) {
        com.example.demo.entities.User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user_details";
    }

    @GetMapping("/tontine/{id}")
    public String viewTontineDetails(@PathVariable Long id, Model model) {
        Tontine tontine = tontineService.getTontineById(id);
        model.addAttribute("tontine", tontine);
        return "admin/tontine_details";
    }

    @GetMapping("/user/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new com.example.demo.entities.User()); // Correction du modèle
        return "admin/create_user";
    }

    @PostMapping("/user/create")
    public String createUser(@ModelAttribute com.example.demo.entities.User user) {
        userService.saveUser(user);
        return "redirect:/admin/admin-dashboard";
    }

    @GetMapping("/tontine/create")
    public String showCreateTontineForm(Model model) {
        model.addAttribute("tontine", new Tontine());
        return "admin/create_tontine";
    }

    @PostMapping("/tontine/create")
    public String createTontine(@ModelAttribute Tontine tontine) {
        tontineService.createTontine(tontine, null);
        return "redirect:/admin/admin-dashboard";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        java.util.List<com.example.demo.entities.User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user_list";
    }

    @GetMapping("/user/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        com.example.demo.entities.User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/edit_user";
    }

    @PostMapping("/user/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute com.example.demo.entities.User user) {
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/tontines")
    public String listTontines(Model model) {
        java.util.List<Tontine> tontines = tontineService.getAllTontines(); // Correction du type
        model.addAttribute("tontines", tontines);
        return "admin/tontine_list";
    }

    @GetMapping("/tontine/edit/{id}")
    public String showEditTontineForm(@PathVariable Long id, Model model) {
        Tontine tontine = tontineService.getTontineById(id);
        model.addAttribute("tontine", tontine);
        return "admin/edit_tontine";
    }

    @PostMapping("/tontine/edit/{id}")
    public String editTontine(@PathVariable Long id, @ModelAttribute Tontine tontine) {
        tontine.setId(id);
        tontineService.saveTontine(tontine);
        return "redirect:/admin/tontines";
    }

    @GetMapping("/tontine/delete/{id}")
    public String deleteTontine(@PathVariable Long id) {
        tontineService.deleteTontineById(id);
        return "redirect:/admin/tontines";
    }
}
