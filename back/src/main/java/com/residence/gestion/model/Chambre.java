package com.residence.gestion.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Le numéro de chambre doit être un nombre positif.")
    private int numero;

    @NotBlank(message = "La taille ne peut pas être vide.")
    @Size(max = 50, message = "La taille ne peut pas dépasser 50 caractères.")
    private String taille;

    @NotBlank(message = "Les équipements ne peuvent pas être vides.")
    @Size(max = 255, message = "Les équipements ne peuvent pas dépasser 255 caractères.")
    private String equipements;

    @NotBlank(message = "Le statut est obligatoire.")
    @Size(max = 50, message = "Le statut ne peut pas dépasser 50 caractères.")
    private String statut; // Disponible, Occupée, Maintenance

    @OneToOne(mappedBy = "chambre")
    private Resident resident;

    @OneToMany(mappedBy = "chambre")
    private List<RequeteMaintenance> requetes;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEquipements() {
        return equipements;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
    }
}
