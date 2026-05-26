package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

public class FraudePapier extends Fraude {

    private String dimensions;
    private boolean plie;

    public FraudePapier(LocalDate dateReleve, String description, String contenu,
                        String dimensions, boolean plie) {
        super(dateReleve, description, contenu);
        this.dimensions = dimensions;
        this.plie = plie;
    }

    public String getDimensions() { return dimensions; }
    public boolean isPlie() { return plie; }

    @Override
    public String afficherDetails() {
        return "FraudePapier [Dimensions : " + dimensions
                + ", Plié : " + (plie ? "oui" : "non") + "] - " + getDescription()
                + " (relevée le " + getDateReleve() + ")";
    }
}