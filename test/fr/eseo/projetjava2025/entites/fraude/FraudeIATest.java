package fr.eseo.projetjava2025.entites.fraude;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @file FraudeIATest.java
 * @brief Classe de tests unitaires automatiques pour la classe FraudeIA.
 * @details Valide le constructeur, l'accès aux attributs spécifiques (getters)
 * et la méthode de formatage textuel pour obtenir 100% de couverture sur cette entité fille.
 */
public class FraudeIATest {

    /**
     * @brief Test unitaire du constructeur et des méthodes d'accès (Getters).
     * @details Vérifie que les attributs hérités de la classe Fraude ainsi que l'attribut spécifique
     * à l'intelligence artificielle (nom du service) sont correctement assignés et restitués.
     */
    @Test
    public void testConstructeurEtGetters() {
        LocalDate dateAttendue = LocalDate.of(2026, 6, 2);
        String descAttendue = "Génération d'un algorithme de tri non autorisé";
        String contenuAttendu = "Code source contenant des commentaires caractéristiques d'une IA.";
        String serviceAttendu = "ChatGPT";

        FraudeIA fraude = new FraudeIA(dateAttendue, descAttendue, contenuAttendu, serviceAttendu);

        assertNotNull(fraude, "L'instance de FraudeIA ne doit pas être nulle.");
        assertEquals(dateAttendue, fraude.getDateReleve(), "La date de relevé doit correspondre.");
        assertEquals(descAttendue, fraude.getDescription(), "La description doit correspondre.");
        assertEquals(contenuAttendu, fraude.getContenu(), "Le contenu de preuve doit correspondre.");
        assertEquals(serviceAttendu, fraude.getNomServiceIA(), "Le nom du service d'IA doit correspondre.");
    }

    /**
     * @brief Test de la méthode de sérialisation textuelle toString().
     * @details S'assure que la chaîne de caractères renvoyée intègre de manière transparente le tag
     * spécifique ainsi que le libellé du service d'intelligence artificielle employé.
     */
    @Test
    public void testToString() {
        LocalDate date = LocalDate.of(2026, 6, 2);
        FraudeIA fraude = new FraudeIA(date, "Rédaction de rapport", "Texte fourni", "Claude");

        String renduStr = fraude.toString();

        assertNotNull(renduStr, "La méthode toString() ne doit pas renvoyer une chaîne nulle.");
        assertTrue(renduStr.contains("[Fraude IA]"), "La chaîne doit contenir le tag explicite du type de fraude.");
        assertTrue(renduStr.contains("Service utilisé: Claude"), "La chaîne doit mentionner de manière claire le service d'IA.");
    }
}