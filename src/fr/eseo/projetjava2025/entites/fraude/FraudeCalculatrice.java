package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

public class FraudeCalculatrice extends Fraude {

    private String marque;
    private String programmeStocke;

    public FraudeCalculatrice(LocalDate dateReleve, String description, String contenu,
                              String marque, String programmeStocke) {
        super(dateReleve, description, contenu);
        this.marque = marque;
        this.programmeStocke = programmeStocke;
    }

    public String getMarque() { return marque; }
    public String getProgrammeStocke() { return programmeStocke; }

    @Override
    public String afficherDetails() {
        return "FraudeCalculatrice [Marque : " + marque
                + ", Programme : " + programmeStocke + "] - " + getDescription()
                + " (relevée le " + getDateReleve() + ")";
    }
}