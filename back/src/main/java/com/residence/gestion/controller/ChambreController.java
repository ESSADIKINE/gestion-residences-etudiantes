package com.residence.gestion.controller;

import com.residence.gestion.model.Chambre;
import com.residence.gestion.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    // Create or Update a Chambre
    @PostMapping
    public ResponseEntity<Chambre> createOrUpdateChambre(@RequestBody Chambre chambre) {
        Chambre savedChambre = chambreService.createOrUpdateChambre(chambre);
        return ResponseEntity.ok(savedChambre);
    }

    // Retrieve all Chambres
    @GetMapping
    public ResponseEntity<List<Chambre>> getAllChambres() {
        List<Chambre> chambres = chambreService.getAllChambres();
        return ResponseEntity.ok(chambres);
    }

    // Retrieve a specific Chambre by ID
    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        return chambreService.getChambreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a Chambre by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
        return ResponseEntity.noContent().build();
    }
}
