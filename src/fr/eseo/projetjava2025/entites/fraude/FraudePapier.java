package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

/**
 * @file FraudePapier.java
 * @brief Fichier contenant la classe FraudePapier.
 */

/**
 * @class FraudePapier
 * @brief Représente une fraude matérielle commise à l'aide d'un support papier (ex: antisèche).
 * Spécialise la classe abstraite Fraude en y ajoutant les caractéristiques physiques du papier.
 */
public class FraudePapier extends Fraude {

    private String dimensions;
    private boolean plie;

    /**
     * @brief Constructeur complet de la classe FraudePapier.
     * @param dateReleve La date à laquelle la fraude a été constatée
     * @param description Une description textuelle de l'incident
     * @param contenu Le contenu textuel retrouvé sur le support papier
     * @param dimensions Les dimensions physiques du papier (ex: "A4", "7x10 cm")
     * @param plie Indique si le papier était plié lors de sa découverte (true) ou non (false)
     */
    public FraudePapier(LocalDate dateReleve, String description, String contenu,
                        String dimensions, boolean plie) {
        super(dateReleve, description, contenu);
        this.dimensions = dimensions;
        this.plie = plie;
    }

    /**
     * @brief Obtient les dimensions du support papier.
     * @return Les dimensions sous forme de chaîne de caractères.
     */
    public String getDimensions() { return dimensions; }

    /**
     * @brief Indique si le papier était plié ou non.
     * @return true si le papier était plié, false sinon.
     */
    public boolean isPlie() { return plie; }

    /**
     * @brief Implémentation de la méthode permettant d'afficher les détails spécifiques de la fraude papier.
     * @return Une chaîne de caractères formatée contenant les dimensions, l'état de pliage, la description et la date.
     */
    @Override
    public String afficherDetails() {
        return "FraudePapier [Dimensions : " + dimensions
                + ", Plié : " + (plie ? "oui" : "non") + "] - " + getDescription()
                + " (relevée le " + getDateReleve() + ")";
    }
}