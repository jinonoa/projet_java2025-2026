package fr.eseo.projetjava2025.interfaceUt;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @file SaisieUtilisateurTest.java
 * @brief Tests pour la classe SaisieUtilisateur.
 */

public class SaisieUtilisateurTest {

    /**
     * @brief Teste la lecture d'un texte.
     */

    @Test
    public void testLireTexte() {
        // On simule une saisie au clavier
        String simulationClavier = "Mon texte\n";
        System.setIn(new ByteArrayInputStream(simulationClavier.getBytes()));

        SaisieUtilisateur saisie = new SaisieUtilisateur();
        String resultat = saisie.lireString();

        assertEquals("Mon texte", resultat);
        System.setIn(System.in); // Remet le clavier normal
    }

    /**
     * @brief Teste la lecture d'un nombre entier.
     */
    @Test
    public void testLireNombre() {
        // On simule d'abord une mauvaise saisie "abc", puis un bon nombre "42"
        String simulationClavier = "abc\n42\n";
        System.setIn(new ByteArrayInputStream(simulationClavier.getBytes()));

        SaisieUtilisateur saisie = new SaisieUtilisateur();
        int resultat = saisie.lireInt();

        assertEquals(42, resultat);
        System.setIn(System.in); // Remet le clavier normal
    }

    /**
     * @brief Teste la lecture d'une date.
     */

    @Test
    public void testLireDate() {
        // On simule d'abord une mauvaise date, puis une bonne date valide
        String simulationClavier = "date-fausse\n15/05/2026\n";
        System.setIn(new ByteArrayInputStream(simulationClavier.getBytes()));

        SaisieUtilisateur saisie = new SaisieUtilisateur();
        LocalDate resultat = saisie.lireDate();

        assertNotNull(resultat);
        assertEquals(2026, resultat.getYear());
        assertEquals(5, resultat.getMonthValue());
        assertEquals(15, resultat.getDayOfMonth());
        System.setIn(System.in); // ça permet de remettre le clavier  normal
    }
}
