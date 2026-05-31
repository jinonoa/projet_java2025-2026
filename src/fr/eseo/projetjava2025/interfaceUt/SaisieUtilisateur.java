package fr.eseo.projetjava2025.interfaceUt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @file SaisieUtilisateur.java
 * @brief Fichier contenant la classe SaisieUtilisateur.
 */

/**
 * @class SaisieUtilisateur
 * @brief Classe gérant la saisie des données utilisateur depuis le terminal.
 *
 * Cette classe fournit des méthodes pour lire différents types de données
 * saisies par l'utilisateur via le clavier, avec gestion des erreurs de saisie.
 */
public class SaisieUtilisateur {

    /** @brief Scanner utilisé pour lire les entrées clavier. */
    private Scanner scanner;

    /**
     * @brief Constructeur par défaut.
     * Initialise le scanner sur l'entrée standard.
     */
    public SaisieUtilisateur() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * @brief Lit un entier saisi par l'utilisateur.
     * Redemande tant que la saisie n'est pas un entier valide.
     * @return int La valeur entière saisie.
     */
    public int lireInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un entier valide.");
            scanner.next();
        }
        int valeur = scanner.nextInt();
        scanner.nextLine();
        return valeur;
    }

    /**
     * @brief Lit une chaîne de caractères saisie par l'utilisateur.
     * @return String La chaîne saisie sans espaces superflus.
     */
    public String lireString() {
        return scanner.nextLine().trim();
    }

    /**
     * @brief Lit une date saisie par l'utilisateur au format dd/MM/yyyy.
     * Redemande tant que le format n'est pas valide.
     * @return LocalDate La date saisie.
     */
    public LocalDate lireDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("Format invalide. Entrez une date au format dd/MM/yyyy :");
            }
        }
    }
}