package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

/**
 * @file Fraude.java
 * @brief Fichier contenant la classe abstraite Fraude.
 */

/**
 * @class Fraude
 * @brief Classe abstraite servant de base pour représenter les différents types de fraudes détectées.
 */
public abstract class Fraude {

    private LocalDate dateReleve;
    private String description;
    private String contenu;

    /**
     * @brief Constructeur de la classe Fraude.
     * @param dateReleve La date à laquelle la fraude a été constatée
     * @param description Une description textuelle générale de l'incident
     * @param contenu Le contenu ou la preuve associée à la fraude
     */
    public Fraude(LocalDate dateReleve, String description, String contenu) {
        this.dateReleve = dateReleve;
        this.description = description;
        this.contenu = contenu;
    }

    /**
     * @brief Obtient la date du relevé de la fraude.
     * @return La date locale du constat.
     */
    public LocalDate getDateReleve() { return dateReleve; }

    /**
     * @brief Obtient la description de la fraude.
     * @return La description de l'incident.
     */
    public String getDescription() { return description; }

    /**
     * @brief Obtient le contenu ou les éléments de preuve textuels.
     * @return Le contenu lié à la fraude.
     */
    public String getContenu() { return contenu; }

    /**
     * @brief Méthode abstraite devant retourner les détails spécifiques de la fraude.
     * Chaque classe fille doit implémenter cette méthode pour afficher ses propres attributs.
     * @return Une chaîne de caractères contenant le détail complet de la fraude.
     */
    public abstract String afficherDetails();
}