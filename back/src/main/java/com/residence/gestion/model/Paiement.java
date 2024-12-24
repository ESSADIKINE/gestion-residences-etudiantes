package com.residence.gestion.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le montant ne peut pas être nul.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le montant doit être supérieur à 0.")
    private Double montant;

    @NotNull(message = "La date de paiement ne peut pas être nulle.")
    @FutureOrPresent(message = "La date de paiement ne peut pas être dans le passé.")
    private LocalDate datePaiement;

    @NotBlank(message = "Le statut ne peut pas être vide.")
    private String statut; // Payé, En attente, En retard

    @ManyToOne
    @NotNull(message = "Le résident associé ne peut pas être nul.")
    private Resident resident;

    // Getters and Setters
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }
}
