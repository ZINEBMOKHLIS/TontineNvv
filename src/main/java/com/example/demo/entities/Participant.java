package com.example.demo.entities;

import java.lang.invoke.MethodHandles.Lookup;
import java.util.Optional;

import jakarta.persistence.*;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
    private Long id;

    private String nom;
    private String prenom;
    private int montant;



    // Ajoutez d'autres attributs nécessaires
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
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public byte byteValue() {
		return id.byteValue();
	}
	public short shortValue() {
		return id.shortValue();
	}
	public int intValue() {
		return id.intValue();
	}
	public long longValue() {
		return id.longValue();
	}
	public float floatValue() {
		return id.floatValue();
	}
	public double doubleValue() {
		return id.doubleValue();
	}

	public int hashCode() {
		return id.hashCode();
	}
	public boolean equals(Object obj) {
		return id.equals(obj);
	}
	public int compareTo(Long anotherLong) {
		return id.compareTo(anotherLong);
	}
	public Optional<Long> describeConstable() {
		return id.describeConstable();
	}
	public Long resolveConstantDesc(Lookup lookup) {
		return id.resolveConstantDesc(lookup);}

	// ... (previous code)

	// You can customize this toString() method based on your requirements
	@Override
	public String toString() {
		return "Participant{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", montant=" + montant +
				// Add other attributes as needed
				'}';
	}
}



