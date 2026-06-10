package fr.eseo.projetjava2025.interfaceUt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * @file SaisieUtilisateur.java
 * @brief Classe responsable de la capture sécurisée des données saisies par l'utilisateur.
 */
public class SaisieUtilisateur {

    /** @brief Scanner lié au flux d'entrée standard (clavier). */
    private Scanner scanner = new Scanner(System.in);

    /**
     * @brief Lit un entier valide depuis le terminal.
     * @return int L'entier saisi.
     */
    public int lireInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Saisie incorrecte. Veuillez entrer un entier : ");
            }
        }
    }

    /**
     * @brief Lit une chaîne de caractères depuis le terminal.
     * @return String Le texte saisi sans espaces inutiles aux extrémités.
     */
    public String lireString() { // [cite: 149]
        return scanner.nextLine().trim();
    }

    /**
     * @brief Lit une date au format textuel français et la convertit en objet temporel Java.
     * @return LocalDate La date correspondante.
     */
    public LocalDate lireDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            String saisie = scanner.nextLine().trim();
            try {
                return LocalDate.parse(saisie, formatter);
            } catch (DateTimeParseException e) {
                System.out.print("Format invalide (Saisissez sous la forme JJ/MM/AAAA) : ");
            }
        }
    }
}