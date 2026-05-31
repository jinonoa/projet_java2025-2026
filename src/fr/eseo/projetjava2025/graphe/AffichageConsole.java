package fr.eseo.projetjava2025.interfaceUt;

/**
 * @file AffichageConsole.java
 * @brief Fichier contenant la classe AffichageConsole.
 */

/**
 * @class AffichageConsole
 * @brief Classe gérant l'affichage des messages dans le terminal.
 *
 * Cette classe fournit des méthodes pour afficher différents types
 * de messages à l'utilisateur : erreurs, succès et messages simples.
 */
public class AffichageConsole {

    /**
     * @brief Affiche un message d'erreur formaté.
     * @param message Le message d'erreur à afficher.
     */
    public void afficherErreur(String message) {
        System.out.println("[ERREUR] " + message);
    }

    /**
     * @brief Affiche un message de succès formaté.
     * @param message Le message de succès à afficher.
     */
    public void afficherSucces(String message) {
        System.out.println("[SUCCÈS] " + message);
    }

    /**
     * @brief Affiche un message simple.
     * @param message Le message à afficher.
     */
    public void afficherMessage(String message) {
        System.out.println(message);
    }
}