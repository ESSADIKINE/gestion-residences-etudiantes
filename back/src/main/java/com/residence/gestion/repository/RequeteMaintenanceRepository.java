package com.residence.gestion.repository;

import com.residence.gestion.model.RequeteMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequeteMaintenanceRepository extends JpaRepository<RequeteMaintenance, Long> {
    List<RequeteMaintenance> findByResidentId(Long residentId);
    List<RequeteMaintenance> findByChambreId(Long chambreId);
}
