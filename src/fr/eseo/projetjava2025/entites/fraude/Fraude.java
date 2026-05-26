package fr.eseo.projetjava2025.entites.fraude;

import java.time.LocalDate;

public abstract class Fraude {

    private LocalDate dateReleve;
    private String description;
    private String contenu;

    public Fraude(LocalDate dateReleve, String description, String contenu) {
        this.dateReleve = dateReleve;
        this.description = description;
        this.contenu = contenu;
    }

    public LocalDate getDateReleve() { return dateReleve; }
    public String getDescription() { return description; }
    public String getContenu() { return contenu; }

    public abstract String afficherDetails();
}