package com.residence.gestion.controller;

import com.residence.gestion.model.Paiement;
import com.residence.gestion.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    // Create or Update a Paiement
    @PostMapping
    public ResponseEntity<Paiement> createOrUpdatePaiement(@RequestBody Paiement paiement) {
        Paiement savedPaiement = paiementService.createOrUpdatePaiement(paiement);
        return ResponseEntity.ok(savedPaiement);
    }

    // Retrieve all Paiements
    @GetMapping
    public ResponseEntity<List<Paiement>> getAllPaiements() {
        List<Paiement> paiements = paiementService.getAllPaiements();
        return ResponseEntity.ok(paiements);
    }

    // Retrieve a specific Paiement by ID
    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a Paiement by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }

    // Retrieve Paiements by Resident ID
    @GetMapping("/resident/{residentId}")
    public ResponseEntity<List<Paiement>> getPaiementsByResidentId(@PathVariable Long residentId) {
        List<Paiement> paiements = paiementService.getPaiementsByResidentId(residentId);
        return ResponseEntity.ok(paiements);
    }
}
