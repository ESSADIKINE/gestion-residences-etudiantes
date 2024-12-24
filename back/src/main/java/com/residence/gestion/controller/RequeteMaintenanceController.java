package com.residence.gestion.controller;

import com.residence.gestion.model.RequeteMaintenance;
import com.residence.gestion.service.RequeteMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requetes")
public class RequeteMaintenanceController {

    @Autowired
    private RequeteMaintenanceService requeteMaintenanceService;

    // Create or Update a RequeteMaintenance
    @PostMapping
    public ResponseEntity<RequeteMaintenance> createOrUpdateRequete(@RequestBody RequeteMaintenance requeteMaintenance) {
        RequeteMaintenance savedRequete = requeteMaintenanceService.createOrUpdateRequeteMaintenance(requeteMaintenance);
        return ResponseEntity.ok(savedRequete);
    }

    // Retrieve all Requetes
    @GetMapping
    public ResponseEntity<List<RequeteMaintenance>> getAllRequetes() {
        List<RequeteMaintenance> requetes = requeteMaintenanceService.getAllRequetes();
        return ResponseEntity.ok(requetes);
    }

    // Retrieve a specific Requete by ID
    @GetMapping("/{id}")
    public ResponseEntity<RequeteMaintenance> getRequeteById(@PathVariable Long id) {
        return requeteMaintenanceService.getRequeteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a Requete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequete(@PathVariable Long id) {
        requeteMaintenanceService.deleteRequete(id);
        return ResponseEntity.noContent().build();
    }

    // Retrieve Requetes by Resident ID
    @GetMapping("/resident/{residentId}")
    public ResponseEntity<List<RequeteMaintenance>> getRequetesByResidentId(@PathVariable Long residentId) {
        List<RequeteMaintenance> requetes = requeteMaintenanceService.getRequetesByResidentId(residentId);
        return ResponseEntity.ok(requetes);
    }

    // Retrieve Requetes by Chambre ID
    @GetMapping("/chambre/{chambreId}")
    public ResponseEntity<List<RequeteMaintenance>> getRequetesByChambreId(@PathVariable Long chambreId) {
        List<RequeteMaintenance> requetes = requeteMaintenanceService.getRequetesByChambreId(chambreId);
        return ResponseEntity.ok(requetes);
    }
}
