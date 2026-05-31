package fr.eseo.projetjava2025.entites.formulaire;

import fr.eseo.projetjava2025.entites.epreuve.Epreuve;
import fr.eseo.projetjava2025.entites.etudiant.Etudiant;
import fr.eseo.projetjava2025.entites.fraude.Fraude;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @file Formulaire.java
 * @brief Fichier contenant la classe Formulaire.
 */

/**
 * @class Formulaire
 * @brief Représente un formulaire de suivi des épreuves, des étudiants et des fraudes associées.
 */
public class Formulaire {

    private int identifiant;
    private LocalDateTime dateDeCreation;
    private LocalDateTime dateDeModification;
    private Epreuve epreuve;
    private List<Etudiant> etudiants;
    private List<Fraude> fraudes;

    /**
     * @brief Constructeur par défaut.
     * Initialise les dates à la date actuelle et crée des listes vides.
     */
    public Formulaire() {
        this.dateDeCreation = LocalDateTime.now();
        this.dateDeModification = LocalDateTime.now();
        this.etudiants = new ArrayList<>();
        this.fraudes = new ArrayList<>();
    }

    /**
     * @brief Constructeur initialisant l'ensemble des attributs.
     * @param identifiant Identifiant unique du formulaire
     * @param dateDeCreation Date de création du document
     * @param dateDeModification Date de la dernière modification
     * @param epreuve Épreuve associée au formulaire
     * @param etudiants Liste des étudiants inscrits/impliqués
     * @param fraudes Liste des fraudes recensées
     */
    public Formulaire(int identifiant, LocalDateTime dateDeCreation, LocalDateTime dateDeModification,
                      Epreuve epreuve, List<Etudiant> etudiants, List<Fraude> fraudes) {
        this.identifiant = identifiant;
        this.dateDeCreation = dateDeCreation;
        this.dateDeModification = dateDeModification;
        this.epreuve = epreuve;
        this.etudiants = etudiants != null ? etudiants : new ArrayList<>();
        this.fraudes = fraudes != null ? fraudes : new ArrayList<>();
    }

    /**
     * @brief PREMIER CONSTRUCTEUR (À 4 paramètres)
     * Appelé dans MenuPrincipal au tout début de la saisie,
     * quand les listes d'étudiants et de fraudes sont encore vides.
     */
    public Formulaire(int identifiant, LocalDateTime dateDeCreation, LocalDateTime dateDeModification, Epreuve epreuve) {
        this.identifiant = identifiant;
        this.dateDeCreation = dateDeCreation;
        this.dateDeModification = dateDeModification;
        this.epreuve = epreuve;
        this.etudiants = new ArrayList<>(); // Initialisation automatique à vide
        this.fraudes = new ArrayList<>();   // Initialisation automatique à vide
    }

    /**
     * @brief Ajoute un étudiant à la liste du formulaire si celui-ci n'y est pas déjà.
     * @param e L'étudiant à ajouter.
     */
    public void ajouteEtudiant(Etudiant e) {
        if (e != null && !this.etudiants.contains(e)) {
            this.etudiants.add(e);
            mettreAJourDateModification();
        }
    }

    /**
     * @brief Ajoute une fraude au formulaire et met à jour la date de modification.
     * @param f La fraude à enregistrer.
     */
    public void ajouteFraude(Fraude f) {
        if (f != null && !this.fraudes.contains(f)) {
            this.fraudes.add(f);
            mettreAJourDateModification();
        }
    }

    /**
     * @brief Supprime un étudiant de la liste du formulaire.
     * @param e L'étudiant à retirer.
     */
    public void supprimeEtudiant(Etudiant e) {
        if (this.etudiants.remove(e)) {
            mettreAJourDateModification();
        }
    }

    /**
     * @brief Supprime une fraude de la liste du formulaire.
     * @param f La fraude à retirer.
     */
    public void supprimeFraude(Fraude f) {
        if (this.fraudes.remove(f)) {
            mettreAJourDateModification();
        }
    }

    /**
     * @brief Retourne la liste des étudiants associés.
     * @return List<Etudiant>
     */
    public List<Etudiant> getEtudiants() {
        return this.etudiants;
    }

    /**
     * @brief Retourne l'épreuve concernée.
     * @return Epreuve
     */
    public Epreuve getEpreuve() {
        return this.epreuve;
    }

    /**
     * @brief Retourne la liste des fraudes enregistrées.
     * @return List<Fraude>
     */
    public List<Fraude> getFraudes() {
        return this.fraudes;
    }

    /**
     * @brief Actualise la date de modification avec l'horodatage système actuel.
     */
    public void mettreAJourDateModification() {
        this.dateDeModification = LocalDateTime.now();
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
        mettreAJourDateModification();
    }

    public LocalDateTime getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDateTime dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public LocalDateTime getDateDeModification() {
        return dateDeModification;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
        mettreAJourDateModification();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=======================================================\n");
        sb.append(" DOSSIER DE FRAUDE N° ").append(identifiant).append("\n");
        sb.append("=======================================================\n");
        sb.append("• Créé le         : ").append(dateDeCreation).append("\n");
        sb.append("• Modifié le      : ").append(dateDeModification).append("\n");
        sb.append("• Épreuve         : ").append(epreuve != null ? epreuve.toString() : "Aucune").append("\n");

        // 1. Boucle d'affichage pour les étudiants impliqués
        sb.append("• Étudiant(s) impliqué(s) :\n");
        if (etudiants == null || etudiants.isEmpty()) {
            sb.append("  - Aucun étudiant enregistré\n");
        } else {
            for (Etudiant e : etudiants) {
                sb.append("  - ").append(e.getPrenom()).append(" ").append(e.getNom())
                        .append(" (N°").append(e.getNumeroApprenant()).append(" - Cursus: ").append(e.getCursus()).append(")\n");
            }
        }

        // 2. Boucle d'affichage pour les types de fraudes (Polymorphisme en action)
        sb.append("• Détail des fraudes constatées :\n");
        if (fraudes == null || fraudes.isEmpty()) {
            sb.append("  - Aucune fraude enregistrée\n");
        } else {
            for (Fraude f : fraudes) {
                // Ici, f.toString() va appeler de manière transparente le toString()
                // de FraudeIA, FraudePapier, etc., selon l'objet réel.
                sb.append("  -> ").append(f.toString()).append("\n");
            }
        }
        sb.append("=======================================================");
        return sb.toString();
    }
}