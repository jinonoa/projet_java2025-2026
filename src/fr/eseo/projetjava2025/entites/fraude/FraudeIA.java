package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

/**
 * @file FraudeIA.java
 * @brief Fichier contenant la classe FraudeIA.
 */

/**
 * @class FraudeIA
 * @brief Représente une fraude spécifique commise à l'aide d'une Intelligence Artificielle.
 * Spécialise la classe abstraite Fraude en y ajoutant le nom du service utilisé (ex: ChatGPT, Claude, etc.).
 */
public class FraudeIA extends Fraude {

    private String nomServiceIA;

    /**
     * @brief Constructeur complet de la classe FraudeIA.
     * @param dateReleve La date à laquelle la fraude a été détectée
     * @param description Une description textuelle du constat de fraude
     * @param contenu Le contenu ou la preuve récoltée (ex: texte généré)
     * @param nomServiceIA Le nom du service d'intelligence artificielle utilisé
     */
    public FraudeIA(LocalDate dateReleve, String description, String contenu, String nomServiceIA) {
        super(dateReleve, description, contenu);
        this.nomServiceIA = nomServiceIA;
    }

    /**
     * @brief Obtient le nom du service d'intelligence artificielle utilisé pour la fraude.
     * @return Le nom du service d'IA sous forme de chaîne de caractères.
     */
    public String getNomServiceIA() { return nomServiceIA; }

    /**
     * @brief Implémentation de la méthode permettant d'afficher les détails spécifiques de la fraude IA.
     * @return Une chaîne de caractères formatée contenant le nom de l'IA, la description et la date du relevé.
     */

    @Override
    public String toString() {
        return "[Fraude IA] " + super.toString() + " | Service utilisé: " + nomServiceIA;
    }
}