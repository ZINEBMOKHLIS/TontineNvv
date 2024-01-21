package com.example.demo.dao;


import com.example.demo.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {



    // Ajoutez des méthodes personnalisées si nécessaire
}
