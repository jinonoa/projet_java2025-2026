package fr.eseo.projetjava2025.entites.epreuve;

import java.time.LocalDate;
import java.time.LocalTime;

public class Epreuve {

    private String codeECUE;
    private LocalDate date;
    private LocalTime heure;
    private int duree;
    private Modalite modalite;

    public Epreuve(String codeECUE, LocalDate date, LocalTime heure, int duree, Modalite modalite) {
        this.codeECUE = codeECUE;
        this.date = date;
        this.heure = heure;
        this.duree = duree;
        this.modalite = modalite;
    }

    public String getCodeECUE() { return codeECUE; }
    public LocalDate getDate() { return date; }
    public LocalTime getHeure() { return heure; }
    public int getDuree() { return duree; }
    public Modalite getModalite() { return modalite; }

    @Override
    public String toString() {
        return "Epreuve{" +
                "codeECUE='" + codeECUE + '\'' +
                ", date=" + date +
                ", heure=" + heure +
                ", duree=" + duree + " min" +
                ", modalite=" + modalite +
                '}';
    }
}