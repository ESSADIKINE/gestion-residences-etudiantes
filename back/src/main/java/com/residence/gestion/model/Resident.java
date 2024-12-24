package com.residence.gestion.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom ne peut pas être vide.")
    @Size(max = 50, message = "Le nom ne peut pas dépasser 50 caractères.")
    private String nom;

    @NotBlank(message = "L'email ne peut pas être vide.")
    @Email(message = "Veuillez fournir un email valide.")
    private String email;

    @Pattern(regexp = "\\+?\\d{10,15}", message = "Le numéro de téléphone doit être valide (10-15 chiffres).")
    private String telephone;

    @Size(max = 255, message = "L'adresse ne peut pas dépasser 255 caractères.")
    private String adresse;

    @NotBlank(message = "Le genre ne peut pas être vide.")
    @Pattern(regexp = "Homme|Femme|Autre", message = "Le genre doit être 'Homme', 'Femme', ou 'Autre'.")
    private String gender;

    @OneToOne
    private Chambre chambre;

    @OneToMany(mappedBy = "resident")
    private List<Paiement> paiements;

    @OneToMany(mappedBy = "resident")
    private List<RequeteMaintenance> requetes;

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
