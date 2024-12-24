package com.residence.gestion.service;

import com.residence.gestion.model.Chambre;
import com.residence.gestion.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    // Create or Update a Chambre
    public Chambre createOrUpdateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    // Retrieve all Chambres
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    // Retrieve a specific Chambre by ID
    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    // Delete a Chambre by ID
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }
}

