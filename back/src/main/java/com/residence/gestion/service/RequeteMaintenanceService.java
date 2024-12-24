package com.residence.gestion.service;

import com.residence.gestion.model.RequeteMaintenance;
import com.residence.gestion.repository.RequeteMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequeteMaintenanceService {

    @Autowired
    private RequeteMaintenanceRepository requeteMaintenanceRepository;

    // Create or Update a RequeteMaintenance
    public RequeteMaintenance createOrUpdateRequeteMaintenance(RequeteMaintenance requeteMaintenance) {
        return requeteMaintenanceRepository.save(requeteMaintenance);
    }

    // Retrieve all RequeteMaintenances
    public List<RequeteMaintenance> getAllRequetes() {
        return requeteMaintenanceRepository.findAll();
    }

    // Retrieve a specific RequeteMaintenance by ID
    public Optional<RequeteMaintenance> getRequeteById(Long id) {
        return requeteMaintenanceRepository.findById(id);
    }

    // Delete a RequeteMaintenance by ID
    public void deleteRequete(Long id) {
        requeteMaintenanceRepository.deleteById(id);
    }

    // Retrieve Requetes by Resident ID
    public List<RequeteMaintenance> getRequetesByResidentId(Long residentId) {
        return requeteMaintenanceRepository.findByResidentId(residentId);
    }

    // Retrieve Requetes by Chambre ID
    public List<RequeteMaintenance> getRequetesByChambreId(Long chambreId) {
        return requeteMaintenanceRepository.findByChambreId(chambreId);
    }
}
