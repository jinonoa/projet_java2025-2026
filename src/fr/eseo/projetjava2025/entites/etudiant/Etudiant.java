package fr.eseo.projetjava2025.entites.etudiant;

import java.util.Objects;

public class Etudiant {

    private String prenom;
    private String nom;
    private int numeroApprenant;
    private Cursus cursus;

    public Etudiant(String prenom, String nom, int numeroApprenant, Cursus cursus) {
        this.prenom = prenom;
        this.nom = nom;
        this.numeroApprenant = numeroApprenant;
        this.cursus = cursus;
    }

    public int getNumeroApprenant() { return numeroApprenant; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public Cursus getCursus() { return cursus; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etudiant)) return false;
        Etudiant etudiant = (Etudiant) o;
        return numeroApprenant == etudiant.numeroApprenant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroApprenant);
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + cursus + " - n°" + numeroApprenant + ")";
    }
}