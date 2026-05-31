package fr.eseo.projetjava2025.main;

import fr.eseo.projetjava2025.interfaceUt.MenuPrincipal;

/**
 * @file Application.java
 * @brief Fichier contenant le point d'entrée de l'application.
 */

/**
 * @class Application
 * @brief Classe principale servant de point d'entrée au programme.
 *
 * Cette classe contient la méthode main qui initialise et lance
 * l'interface utilisateur de l'application de gestion des fraudes.
 */
public class Application {

    /**
     * @brief Point d'entrée principal de l'application.
     * Instancie le menu principal et lance l'application.
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.lancerApplication();
    }
}