package fr.eseo.projetjava2025.entites.epreuve;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @file Epreuve.java
 * @brief Fichier contenant la classe Epreuve.
 */

/**
 * @class Epreuve
 * @brief Représente une épreuve d'évaluation caractérisée par son code, sa date, son horaire et sa modalité.
 */
public class Epreuve {

    private String codeECUE;
    private LocalDate date;
    private LocalTime heure;
    private int duree;
    private Modalite modalite;

    /**
     * @brief Constructeur complet initialisant tous les attributs de l'épreuve.
     * @param codeECUE Le code unique de l'élément constitutif d'unité d'enseignement (ECUE)
     * @param date La date de tenue de l'épreuve
     * @param heure L'heure de début de l'épreuve
     * @param duree La durée de l'épreuve en minutes
     * @param modalite La modalité pédagogique de l'épreuve (ex: Écrit, Oral, Machine)
     */
    public Epreuve(String codeECUE, LocalDate date, LocalTime heure, int duree, Modalite modalite) {
        this.codeECUE = codeECUE;
        this.date = date;
        this.heure = heure;
        this.duree = duree;
        this.modalite = modalite;
    }

    /**
     * @brief Obtient le code ECUE associé à l'épreuve.
     * @return Le code ECUE sous forme de chaîne de caractères.
     */
    public String getCodeECUE() { return codeECUE; }

    /**
     * @brief Obtient la date de l'épreuve.
     * @return La date locale de l'épreuve.
     */
    public LocalDate getDate() { return date; }

    /**
     * @brief Obtient l'heure de début de l'épreuve.
     * @return L'heure locale de l'épreuve.
     */
    public LocalTime getHeure() { return heure; }

    /**
     * @brief Obtient la durée totale de l'épreuve.
     * @return La durée de l'épreuve en minutes.
     */
    public int getDuree() { return duree; }

    /**
     * @brief Obtient la modalité de l'épreuve.
     * @return La modalité définie pour cette épreuve.
     */
    public Modalite getModalite() { return modalite; }

    /**
     * @brief Retourne une représentation textuelle de l'épreuve.
     * @return Une chaîne de caractères contenant les informations de l'épreuve.
     */
    @Override
    public String toString() {
        return "Epreuve{" +
                "codeECUE='" + codeECUE + '\'' +
                ", date=" + date +
                ", heure=" + heure +
                ", duree=" + duree + " min" +
                ", modalite=" + modalite +
                '}';
    }
}