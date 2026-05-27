package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

/**
 * @file FraudeIAConnectee.java
 * @brief Fichier contenant la classe FraudeIAConnectee.
 */

/**
 * @class FraudeIAConnectee
 * @brief Représente une fraude par IA caractérisée en plus par une connexion réseau (adresse IP).
 * Hérite de FraudeIA pour ajouter la traçabilité réseau de l'appareil utilisé.
 */
public class FraudeIAConnectee extends FraudeIA {

    private String adresseIP;

    /**
     * @brief Constructeur complet de la classe FraudeIAConnectee.
     * @param dateReleve La date à laquelle la fraude a été constatée
     * @param description Une description textuelle de l'incident
     * @param contenu Le contenu ou la preuve récoltée
     * @param nomServiceIA Le nom de l'intelligence artificielle exploitée
     * @param adresseIP L'adresse IP de la machine à l'origine de la requête
     */
    public FraudeIAConnectee(LocalDate dateReleve, String description, String contenu,
                             String nomServiceIA, String adresseIP) {
        super(dateReleve, description, contenu, nomServiceIA);
        this.adresseIP = adresseIP;
    }

    /**
     * @brief Obtient l'adresse IP associée à l'infraction.
     * @return L'adresse IP sous forme de chaîne de caractères.
     */
    public String getAdresseIP() { return adresseIP; }

    /**
     * @brief Implémentation de la méthode permettant d'afficher les détails de la fraude IA connectée.
     * Spécifie l'adresse IP en plus du nom du service, de la description et de la date du relevé.
     * @return Une chaîne de caractères formatée contenant l'ensemble des détails.
     */
    @Override
    public String afficherDetails() {
        return "FraudeIAConnectee [Service IA : " + getNomServiceIA()
                + ", IP : " + adresseIP + "] - " + getDescription()
                + " (relevée le " + getDateReleve() + ")";
    }
}