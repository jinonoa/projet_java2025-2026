package fr.eseo.projetjava2025.interfaceUt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @file AffichageConsoleTest.java
 * @brief Tests pour la classe AffichageConsole.
 */
public class AffichageConsoleTest {

    /**
     * @brief Teste l'affichage d'une erreur.
     */
    @Test
    public void testErreur() {
        AffichageConsole affichage = new AffichageConsole();
        // On appelle la méthode pour vérifier qu'elle fonctionne sans bug
        affichage.afficherErreur(" : Bug !");
        assertNotNull(affichage);
    }

    /**
     * @brief Teste l'affichage d'un succès.
     */
    @Test
    public void testSucces() {
        AffichageConsole affichage = new AffichageConsole();
        affichage.afficherSucces(" : Gagné !");
        assertNotNull(affichage);
    }

    /**
     * @brief Teste l'affichage d'un message.
     */
    @Test
    public void testMessage() {
        AffichageConsole affichage = new AffichageConsole();
        affichage.afficherMessage("Bonjour");
        assertNotNull(affichage);
    }
}