package com.residence.gestion.service;

import com.residence.gestion.model.Resident;
import com.residence.gestion.repository.ResidentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    // Create or Update a Resident
    public Resident saveOrUpdateResident(Resident resident) {
        return residentRepository.save(resident);
    }

    // Get all Residents
    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    // Get a Resident by ID
    public Optional<Resident> getResidentById(Long id) {
        return residentRepository.findById(id);
    }

    // Delete a Resident by ID
    public void deleteResidentById(Long id) {
        residentRepository.deleteById(id);
    }
}
