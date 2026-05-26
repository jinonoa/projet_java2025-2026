package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

public class FraudeIAConnectee extends FraudeIA {

    private String adresseIP;

    public FraudeIAConnectee(LocalDate dateReleve, String description, String contenu,
                             String nomServiceIA, String adresseIP) {
        super(dateReleve, description, contenu, nomServiceIA);
        this.adresseIP = adresseIP;
    }

    public String getAdresseIP() { return adresseIP; }

    @Override
    public String afficherDetails() {
        return "FraudeIAConnectee [Service IA : " + getNomServiceIA()
                + ", IP : " + adresseIP + "] - " + getDescription()
                + " (relevée le " + getDateReleve() + ")";
    }
}