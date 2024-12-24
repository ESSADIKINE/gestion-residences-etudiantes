package com.residence.gestion.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class RequeteMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La description ne peut pas être vide.")
    @Size(max = 255, message = "La description ne peut pas dépasser 255 caractères.")
    private String description;

    @NotNull(message = "La date de création est obligatoire.")
    @FutureOrPresent(message = "La date de création doit être aujourd'hui ou dans le futur.")
    private LocalDate dateCreation;

    @NotBlank(message = "Le statut est obligatoire.")
    @Size(max = 50, message = "Le statut ne peut pas dépasser 50 caractères.")
    private String statut; // En cours, Clôturée

    @ManyToOne
    @NotNull(message = "La chambre associée est obligatoire.")
    private Chambre chambre;

    @ManyToOne
    @NotNull(message = "Le résident associé est obligatoire.")
    private Resident resident;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }
}
