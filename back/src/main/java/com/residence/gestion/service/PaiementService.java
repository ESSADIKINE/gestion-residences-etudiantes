package com.residence.gestion.service;

import com.residence.gestion.model.Paiement;
import com.residence.gestion.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    // Create or Update a Paiement
    public Paiement createOrUpdatePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    // Retrieve all Paiements
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    // Retrieve a specific Paiement by ID
    public Optional<Paiement> getPaiementById(Long id) {
        return paiementRepository.findById(id);
    }

    // Delete a Paiement by ID
    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }

    // Retrieve Paiements by Resident ID
    public List<Paiement> getPaiementsByResidentId(Long residentId) {
        return paiementRepository.findByResidentId(residentId);
    }
}
