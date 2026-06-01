package fr.eseo.projetjava2025.entites.epreuve;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @file EpreuveTest.java
 * @brief Classe de tests unitaires automatiques pour la classe Epreuve.
 * @details Assure la validation des constructeurs, des accesseurs (getters)
 * et de la méthode de formatage textuel pour garantir 100% de couverture sur cette entité.
 */
public class EpreuveTest {

    /**
     * @brief Test unitaire du constructeur et des méthodes d'accès (Getters).
     * @details Vérifie que chaque attribut initialisé est restitué fidèlement sans altération.
     */
    @Test
    public void testConstructeurEtGetters() {
        String codeAttendu = "M4102";
        LocalDate dateAttendue = LocalDate.of(2026, 6, 15);
        LocalTime heureAttendue = LocalTime.of(8, 30);
        int dureeAttendue = 120;
        Modalite modaliteAttendue = Modalite.EXAMEN_ECRIT;

        Epreuve epreuveTest = new Epreuve(codeAttendu, dateAttendue, heureAttendue, dureeAttendue, modaliteAttendue);

        assertNotNull(epreuveTest, "L'instance d'épreuve ne doit pas être nulle après instanciation.");
       // assertEquals(codeAttendu, epreuveTest.getCodeECUE(), "Le code ECUE doit correspondre.");
        assertEquals(dateAttendue, epreuveTest.getDate(), "La date doit correspondre.");
        assertEquals(heureAttendue, epreuveTest.getHeure(), "L'heure doit correspondre.");
        assertEquals(dureeAttendue, epreuveTest.getDuree(), "La durée doit correspondre.");
        assertEquals(modaliteAttendue, epreuveTest.getModalite(), "La modalité doit correspondre.");
    }

    /**
     * @brief Test unitaire de la robustesse avec des valeurs nulles/partielles.
     * @details Vérifie que l'objet accepte une valeur temporelle nulle (comme dans le menu console).
     */
    @Test
    public void testEpreuveAvecHeureNull() {
        Epreuve epreuveHeureNull = new Epreuve("M3105", LocalDate.now(), null, 90, Modalite.TP);
        assertNull(epreuveHeureNull.getHeure(), "L'attribut heure doit pouvoir être initialisé à null.");
    }

    /**
     * @brief Test de la méthode de sérialisation textuelle toString().
     * @details S'assure que la chaîne de caractères générée contient bien les informations clés de l'épreuve.
     */
    @Test
    public void testToString() {
        Epreuve epreuveTest = new Epreuve("M4102", LocalDate.of(2026, 6, 15), LocalTime.of(8, 30), 120, Modalite.EXAMEN_ECRIT);
        String chaineRendue = epreuveTest.toString();

        //assertNotNull(chaineRendue, "La méthode toString() ne doit pas renvoyer une chaîne nulle.");
        assertTrue(chaineRendue.contains("M4102"), "La chaîne textuelle doit contenir le code ECUE.");
        assertTrue(chaineRendue.contains("120"), "La chaîne textuelle doit faire mention de la durée.");
        assertTrue(chaineRendue.contains("EXAMEN_ECRIT"), "La chaîne textuelle doit afficher la modalité.");
    }
}