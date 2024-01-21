package com.example.demo.metier;

import java.util.List;

import com.example.demo.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;

@Service
public class UserService {

	private final UserRepository userRepository;
    private boolean requestingUserRole;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    //pour admin
    public void deleteUserById(Long id) {
        if (!requestingUserRole) {
            throw new UnauthorizedAccessException("Only admins can delete users.");
        } else {
            userRepository.deleteById(id);
        }
//    }
//    public void deleteUserById(Long id) {
//        if (requestingUserRole.equals(Role.ADMIN)) {
//            userRepository.deleteById(id);
//        } else {
//            throw new UnauthorizedAccessException("Only admins can delete users.");
//        }
         }



    // Nouvelle méthode pour vérifier si un utilisateur avec l'e-mail fourni existe déjà

    public boolean isUserExists(String email, Role role)
    {
        return userRepository.existsByEmail(email,role);
    }


    // Nouvelle méthode pour vérifier l'authentification de l'utilisateur en fonction du rôle
    public boolean authenticateUser(String email, String password, Role role) {
        List<User> users = userRepository.findByEmail(email);

        if (users.isEmpty()) {
            return false;  // Aucun utilisateur trouvé avec cet email
        }

        // Si vous vous attendez à un seul utilisateur, vous pouvez prendre le premier de la liste
        User user = users.get(0);

        return user.getPassword().equals(password) && user.getRole() == role;
    }

//    public void deleteUserById(Long id) {
//        userRepository.deleteById(id);
//    }
//
//
//
//    // Nouvelle méthode pour vérifier l'authentification de l'utilisateur
//    public boolean authenticateUser(String email, String password) {
//        User user = userRepository.findByEmail(email);
//        return user != null && user.getPassword().equals(password);
//    }
//
//    // Nouvelle méthode pour vérifier si un utilisateur avec l'e-mail fourni existe déjà
//    public boolean isUserExists(String email) {
//        return userRepository.existsByEmail(email);
//    }

}