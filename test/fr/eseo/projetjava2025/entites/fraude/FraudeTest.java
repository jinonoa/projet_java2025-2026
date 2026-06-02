package fr.eseo.projetjava2025.entites.fraude;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

/**
 * @file FraudeTest.java
 * @brief Classe de tests unitaires automatiques pour la classe abstraite Fraude.
 * @details Utilise une implémentation concrète locale (Stub) pour tester le constructeur,
 * les accesseurs ainsi que les méthodes d'affichage et obtenir 100% de couverture sur la classe de base.
 */
public class FraudeTest {

    /**
     * @class FraudeConcreteStub
     * @brief Classe concrète interne permettant d'instancier et de tester la classe abstraite Fraude.
     */
    private static class FraudeConcreteStub extends Fraude {
        public FraudeConcreteStub(LocalDate dateReleve, String description, String contenu) {
            super(dateReleve, description, contenu);
        }
    }

    /**
     * @brief Test unitaire du constructeur et des méthodes d'accès (Getters).
     * @details Vérifie que les données de base de la fraude encapsulée sont correctement assignées et restituées.
     */
    @Test
    public void testConstructeurEtGetters() {
        LocalDate dateAttendue = LocalDate.of(2026, 6, 2);
        String descAttendue = "Suspicion de triche générale";
        String contenuAttendu = "Notes retrouvées sous le bureau";

        Fraude fraude = new FraudeConcreteStub(dateAttendue, descAttendue, contenuAttendu);

        assertNotNull(fraude, "L'instance de fraude ne doit pas être nulle.");
        assertEquals(dateAttendue, fraude.getDateReleve(), "La date de relevé doit correspondre.");
        assertEquals(descAttendue, fraude.getDescription(), "La description doit correspondre.");
        assertEquals(contenuAttendu, fraude.getContenu(), "Le contenu de preuve doit correspondre.");
    }

    /**
     * @brief Test unitaire de la méthode de sérialisation textuelle toString().
     * @details S'assure que le formatage concatène correctement les variables membres de la classe de base.
     */
    @Test
    public void testToString() {
        LocalDate date = LocalDate.of(2026, 6, 2);
        Fraude fraude = new FraudeConcreteStub(date, "Fraude Test", "Copie conforme");

        String renduStr = fraude.toString();

        assertNotNull(renduStr, "La méthode toString() ne doit pas renvoyer null.");
        assertTrue(renduStr.contains("2026-06-02"), "La chaîne textuelle doit inclure la date.");
        assertTrue(renduStr.contains("Fraude Test"), "La chaîne textuelle doit inclure la description.");
        assertTrue(renduStr.contains("Copie conforme"), "La chaîne textuelle doit inclure le contenu.");
    }

    /**
     * @brief Test unitaire de la méthode afficherDetails().
     * @details Intercepte le flux de sortie standard (System.out) pour valider que la méthode
     * écrit correctement les informations sur la console.
     */
    @Test
    public void testAfficherDetails() {
        LocalDate date = LocalDate.of(2026, 6, 2);
        Fraude fraude = new FraudeConcreteStub(date, "Saisie Ecran", "Logs Proxy");

        // Sauvegarde du flux de sortie standard original
        PrintStream originalOut = System.out;

        // Création d'un flux alternatif pour capturer le texte envoyé dans System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            // Exécution de la méthode qui écrit dans la console
            fraude.afficherDetails();

            // Récupération de la chaîne de caractères imprimée
            String chaineConsole = outContent.toString();

            assertNotNull(chaineConsole, "La sortie console capturée ne doit pas être nulle.");
            assertTrue(chaineConsole.contains("Saisie Ecran"), "La console doit afficher les détails de la fraude.");
        } finally {
            // Restauration impérative du flux standard pour ne pas perturber les autres tests JUnit
            System.setOut(originalOut);
        }
    }
}