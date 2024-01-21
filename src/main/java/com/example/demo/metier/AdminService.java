package com.example.demo.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminRepository;
import com.example.demo.entities.Admin;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final HttpSession httpSession;

    @Autowired
    public AdminService(AdminRepository adminRepository, HttpSession httpSession) {
        this.adminRepository = adminRepository;
        this.httpSession = httpSession;
    }

    public Admin getCurrentAdmin() {
        // Récupérer l'ID de l'administrateur depuis la session
        Long adminId = (Long) httpSession.getAttribute("currentAdminId");

        // Si l'ID est présent, recherchez et renvoyez l'administrateur correspondant
        if (adminId != null) {
            return adminRepository.findById(adminId).orElse(null);
        } else {
            return null;
        }
    }

    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    public boolean authenticateAdmin(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        return admin != null && admin.getPassword().equals(password);
    }

 // Correction de la méthode isAdminExists pour renvoyer un type boolean
    public boolean isAdminExists(String email) {
        return adminRepository.existsByEmail(email);
    }


}
