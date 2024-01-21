package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Tontine;
import com.example.demo.entities.User;

@Repository
public interface TontineRepository extends JpaRepository<Tontine, Long> {


}

