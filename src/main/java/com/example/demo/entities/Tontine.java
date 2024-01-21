package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "Tontines")
public class Tontine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

	private String nom;
	private int nombrePart;
	private Long montant;

	@Column(name = "date_debut")
	private LocalDate dateDebut;

	@Column(name = "date_fin")
	private LocalDate dateFin;

	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "proprietaire_id")
	private User proprietaire;



	public Tontine() {
		super();
	}

	public Tontine(Long id, String nom, int nombrePart, Long montant, LocalDate dateDebut, LocalDate dateFin,
				   String description, User proprietaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.nombrePart = nombrePart;
		this.montant = montant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.proprietaire = proprietaire;
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

	public int getNombrePart() {
		return nombrePart;
	}

	public void setNombrePart(int nombrePart) {
		this.nombrePart = nombrePart;
	}

	public Long getMontant() {
		return montant;
	}

	public void setMontant(Long montant) {
		this.montant = montant;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(User proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "Tontine [id=" + id + ", nom=" + nom + ", nombrePart=" + nombrePart + ", montant=" + montant
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", description=" + description
				+ ", proprietaire=" + proprietaire + "]";
	}
}

	//public Admin getAdminProprietaire() {

	//	return proprietaire;
	//}
//}