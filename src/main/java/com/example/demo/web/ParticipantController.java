package com.example.demo.web;
//
//import java.util.List;

import com.example.demo.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.metier.ParticipantService;

import java.util.List;
//
//import Entity.Participant;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/participants")
    public String listParticipants(Model model) {
        List<Participant> participants = participantService.getAllParticipants();
        model.addAttribute("participants", participants);
        return "participant/list";
    }

    @GetMapping("/participants/add")
    public String showAddParticipantForm(Participant participant) {
        return "participant/add";
    }

    @PostMapping("/participants/add")
    public <Participant> String addParticipant(Participant participant) {
        participantService.addParticipant((com.example.demo.entities.Participant) participant);
        return "redirect:/participants";
    }
}