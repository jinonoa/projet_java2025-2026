package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

/**
 * @file FraudeCalculatrice.java
 * @brief Fichier contenant la classe FraudeCalculatrice.
 */

/**
 * @class FraudeCalculatrice
 * @brief Représente une fraude commise à l'aide d'une calculatrice.
 * Spécialise la classe abstraite Fraude en y ajoutant la marque de l'appareil et le programme illicite utilisé.
 */
public class FraudeCalculatrice extends Fraude {

    private String marque;
    private String programmeStocke;

    /**
     * @brief Constructeur complet de la classe FraudeCalculatrice.
     * @param dateReleve La date à laquelle la fraude a été constatée
     * @param description Une description textuelle de l'incident
     * @param contenu Le contenu ou texte suspect trouvé dans l'appareil
     * @param marque La marque de la calculatrice (ex: "TI", "Casio")
     * @param programmeStocke Le nom ou le descriptif du programme ou script stocké
     */
    public FraudeCalculatrice(LocalDate dateReleve, String description, String contenu,
                              String marque, String programmeStocke) {
        super(dateReleve, description, contenu);
        this.marque = marque;
        this.programmeStocke = programmeStocke;
    }

    /**
     * @brief Obtient la marque de la calculatrice.
     * @return La marque sous forme de chaîne de caractères.
     */
    public String getMarque() { return marque; }

    /**
     * @brief Obtient le nom ou le descriptif du programme stocké.
     * @return Le programme ou script concerné.
     */
    public String getProgrammeStocke() { return programmeStocke; }

    /**
     * @brief Implémentation de la méthode permettant d'afficher les détails spécifiques de la fraude sur calculatrice.
     * @return Une chaîne de caractères formatée contenant la marque, le programme, la description et la date du relevé.
     */
    @Override
    public String afficherDetails() {
        return "FraudeCalculatrice [Marque : " + marque
                + ", Programme : " + programmeStocke + "] - " + getDescription()
                + " (relevée le " + getDateReleve() + ")";
    }
}