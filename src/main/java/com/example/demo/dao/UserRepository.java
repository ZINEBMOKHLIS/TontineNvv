package com.example.demo.dao;

import com.example.demo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find a user by their role
    User findByRole(Role role);

    // Ajouter la méthode pour trouver un utilisateur par e-mail

    List<User> findByEmail(String email);


    //User findByEmail(String email);

    // Ajouter la méthode pour vérifier si un utilisateur avec l'e-mail existe déjà


    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email AND u.role = :role")
    boolean existsByEmail(@Param("email") String email, @Param("role") Role role);
    boolean existsByEmailAndRole(String email, Role role);


//    // Ajouter la méthode pour trouver un utilisateur par e-mail
//    User findByEmail(String email);
//
//    // Ajouter la méthode pour vérifier si un utilisateur avec l'e-mail existe déjà
//    boolean existsByEmail(String email, Role role);
}

