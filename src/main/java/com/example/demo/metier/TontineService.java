package com.example.demo.metier;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Admin;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TontineRepository;
import com.example.demo.entities.Tontine;

@Service
public class TontineService {

	 private final TontineRepository tontineRepository;
    private Tontine tontine;

    @Autowired
	    public TontineService(TontineRepository tontineRepository) {
	        this.tontineRepository = tontineRepository;
	    }

	    public List<Tontine> getAllTontines() {
	        List<Tontine> tontines = tontineRepository.findAll();
	        System.out.println("Nombre de tontines récupérées : " + tontines.size());
	        return tontines;
	    }


	    public Tontine getTontineById(Long tontineId) {
	        return tontineRepository.findById(tontineId).orElse(null);
	    }

	    public void createTontine(Tontine tontine, String username) {
	        // Vérifiez que l'utilisateur est un administrateur avant de créer une tontine
	            tontineRepository.save(tontine);
	    }

//
//      public Admin createTontine(Tontine tontine) {
//          this.tontine = tontine;
//          return tontineRepository.save(tontine).getAdminProprietaire();
//        }


//	public Optional<Admin> updateTontine(Long id, Tontine updatedTontine) {
//		Optional<Tontine> existingTontine = tontineRepository.findById(id);
//
//		if (existingTontine.isPresent()) {
//			// Mettez à jour les champs nécessaires
//			Tontine tontineToUpdate = existingTontine.get();
//			tontineToUpdate.setNom(updatedTontine.getNom());
//			// ... continuez avec d'autres champs
//
//			return Optional.of(tontineRepository.save(tontineToUpdate).getAdminProprietaire());
//		}
//		return Optional.empty(); // ou lancez une exception
//	}
	    
	    public Tontine saveTontine(Tontine tontine) {
	        // Logique pour sauvegarder une tontine
	        // Vous pouvez ajouter des vérifications ou des traitements supplémentaires si nécessaire
	        return tontineRepository.save(tontine);
	    }

	    public void deleteTontineById(Long id) {
	        tontineRepository.deleteById(id);
	    }
}
