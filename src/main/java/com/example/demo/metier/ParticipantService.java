package com.example.demo.metier;

import com.example.demo.dao.ParticipantRepository;
import com.example.demo.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import Entity.Participant;
//import repository.ParticipantRepository;
//
//import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Participant addParticipant(Participant participant) {
        return (Participant) participantRepository.save(participant);
    }
}

