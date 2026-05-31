package fr.eseo.projetjava2025.interfaceUt;

/**
 * @file AffichageConsole.java
 * @brief Classe centralisant l'envoi de messages d'information, de succès ou d'erreur sur la console.
 */
public class AffichageConsole { // [cite: 145]

    /**
     * @brief Affiche un message d'erreur sur le canal d'erreur standard.
     * @param message Contenu textuel de l'erreur.
     */
    public void afficherErreur(String message) { // [cite: 150]
        System.err.println("[ERREUR] " + message);
    }

    /**
     * @brief Affiche une notification de confirmation d'opération réussie.
     * @param message Message de succès.
     */
    public void afficherSucces(String message) { // [cite: 150]
        System.out.println("[SUCCÈS] " + message);
    }

    /**
     * @brief Affiche un message standard ou informatif brut.
     * @param message Message informatif.
     */
    public void afficherMessage(String message) { // [cite: 150]
        System.out.println(message);
    }
}