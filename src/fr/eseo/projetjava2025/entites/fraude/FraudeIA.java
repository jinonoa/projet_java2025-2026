package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

public class FraudeIA extends Fraude {

    private String nomServiceIA;

    public FraudeIA(LocalDate dateReleve, String description, String contenu, String nomServiceIA) {
        super(dateReleve, description, contenu);
        this.nomServiceIA = nomServiceIA;
    }

    public String getNomServiceIA() { return nomServiceIA; }

    @Override
    public String afficherDetails() {
        return "FraudeIA [Service IA : " + nomServiceIA + "] - " + getDescription()
                + " (relevée le " + getDateReleve() + ")";
    }
}