package fr.eseo.projetjava2025.entites.etudiant;

import java.util.Objects;

/**
 * @file Etudiant.java
 * @brief Fichier contenant la classe Etudiant.
 */

/**
 * @class Etudiant
 * @brief Représente un étudiant défini par son identité, son numéro d'apprenant et son cursus.
 */
public class Etudiant {

    private String prenom;
    private String nom;
    private int numeroApprenant;
    private Cursus cursus;

    /**
     * @brief Constructeur complet initialisant tous les attributs de l'étudiant.
     * @param prenom Le prénom de l'étudiant
     * @param nom Le nom de l'étudiant
     * @param numeroApprenant L'identifiant unique de l'étudiant (numéro d'apprenant)
     * @param cursus Le cursus d'études suivi par l'étudiant
     */
    public Etudiant(String prenom, String nom, int numeroApprenant, Cursus cursus) {
        this.prenom = prenom;
        this.nom = nom;
        this.numeroApprenant = numeroApprenant;
        this.cursus = cursus;
    }

    /**
     * @brief Obtient le numéro d'apprenant de l'étudiant.
     * @return Le numéro d'apprenant unique.
     */
    public int getNumeroApprenant() { return numeroApprenant; }

    /**
     * @brief Obtient le nom de l'étudiant.
     * @return Le nom de famille.
     */
    public String getNom() { return nom; }

    /**
     * @brief Obtient le prénom de l'étudiant.
     * @return Le prénom.
     */
    public String getPrenom() { return prenom; }

    /**
     * @brief Obtient le cursus de l'étudiant.
     * @return Le cursus actuel.
     */
    public Cursus getCursus() { return cursus; }

    /**
     * @brief Compare l'étudiant courant avec un autre objet.
     * Deux étudiants sont considérés comme égaux si et seulement si ils ont le même numéro d'apprenant.
     * @param o L'objet à comparer avec l'étudiant courant
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etudiant)) return false;
        Etudiant etudiant = (Etudiant) o;
        return numeroApprenant == etudiant.numeroApprenant;
    }

    /**
     * @brief Génère le code de hachage de l'étudiant basé sur son numéro d'apprenant.
     * @return Le code de hachage calculé.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numeroApprenant);
    }

    /**
     * @brief Retourne une chaîne de caractères représentant l'étudiant.
     * @return Le prénom, le nom, le cursus et le numéro d'apprenant formatés.
     */
    @Override
    public String toString() {
        return prenom + " " + nom + " (" + cursus + " - n°" + numeroApprenant + ")";
    }
}