package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nom", nullable = false)
    private String nom;
	
	@Column(name="prenom")
    private String prenom;
	
	@Column(name="email")
    private String email;
	
	@Column(name="dateNaiss")
    private LocalDate dateNaiss;
	
	@Column(name="adresse")
    private String adresse;
	
	@Column(name="numTel")
    private String numTel;
	
	@Column(name="profession")
    private String profession;
	
	@Column(name="password")
    private String password;




	public Admin() {
		super();
	}

	public Admin(Long id, String nom, String prenom, String email, LocalDate dateNaiss, String adresse, String numTel,
			String profession, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaiss = dateNaiss;
		this.adresse = adresse;
		this.numTel = numTel;
		this.profession = profession;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", dateNaiss="
				+ dateNaiss + ", adresse=" + adresse + ", numTel=" + numTel + ", profession=" + profession
				+ ", password=" + password + "]";
	}
	
	
}

