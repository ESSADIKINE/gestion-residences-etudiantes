package com.residence.gestion.controller;

import com.residence.gestion.model.Resident;
import com.residence.gestion.service.ResidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    // Create or Update a Resident
    @PostMapping
    public ResponseEntity<Resident> createOrUpdateResident(@Validated @RequestBody Resident resident) {
        Resident savedResident = residentService.saveOrUpdateResident(resident);
        return ResponseEntity.ok(savedResident);
    }

    // Get all Residents
    @GetMapping
    public ResponseEntity<List<Resident>> getAllResidents() {
        List<Resident> residents = residentService.getAllResidents();
        return ResponseEntity.ok(residents);
    }

    // Get a Resident by ID
    @GetMapping("/{id}")
    public ResponseEntity<Resident> getResidentById(@PathVariable Long id) {
        Optional<Resident> resident = residentService.getResidentById(id);
        return resident.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    // Delete a Resident by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResidentById(@PathVariable Long id) {
        residentService.deleteResidentById(id);
        return ResponseEntity.noContent().build();
    }
}
