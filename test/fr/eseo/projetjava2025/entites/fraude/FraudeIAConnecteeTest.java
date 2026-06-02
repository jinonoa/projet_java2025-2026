package fr.eseo.projetjava2025.entites.fraude;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @file FraudeIAConnecteeTest.java
 * @brief Classe de tests unitaires automatiques pour la classe FraudeIAConnectee.
 * @details Valide le constructeur, l'accès aux attributs spécifiques et hérités (getters)
 * ainsi que la méthode de formatage textuel pour obtenir 100% de couverture sur cette entité.
 */
public class FraudeIAConnecteeTest {

    /**
     * @brief Test unitaire du constructeur et des méthodes d'accès (Getters).
     * @details Vérifie que les attributs de la classe de base (Fraude), de la classe parente intermédiaire (FraudeIA)
     * ainsi que l'attribut spécifique de traçabilité réseau (adresse IP) sont correctement assignés et restitués.
     */
    @Test
    public void testConstructeurEtGetters() {
        LocalDate dateAttendue = LocalDate.of(2026, 6, 2);
        String descAttendue = "Tentative d'accès à une API cloud de génération";
        String contenuAttendu = "Logs d'appels réseau sortants interceptés par le proxy.";
        String serviceAttendu = "DeepSeek";
        String ipAttendue = "192.168.1.45";

        FraudeIAConnectee fraude = new FraudeIAConnectee(dateAttendue, descAttendue, contenuAttendu, serviceAttendu, ipAttendue);

        assertNotNull(fraude, "L'instance de FraudeIAConnectee ne doit pas être nulle.");
        assertEquals(dateAttendue, fraude.getDateReleve(), "La date de relevé doit correspondre.");
        assertEquals(descAttendue, fraude.getDescription(), "La description doit correspondre.");
        assertEquals(contenuAttendu, fraude.getContenu(), "Le contenu de preuve doit correspondre.");
        assertEquals(serviceAttendu, fraude.getNomServiceIA(), "Le nom du service d'IA doit correspondre.");
        assertEquals(ipAttendue, fraude.getAdresseIP(), "L'adresse IP réseau doit correspondre.");
    }

    /**
     * @brief Test de la méthode de sérialisation textuelle toString().
     * @details S'assure que la chaîne de caractères renvoyée combine correctement le tag de la sous-classe,
     * la chaîne renvoyée par le super.toString() (comportement polymorphique) ainsi que l'adresse IP.
     */
    @Test
    public void testToString() {
        LocalDate date = LocalDate.of(2026, 6, 2);
        FraudeIAConnectee fraude = new FraudeIAConnectee(date, "Appels API", "Données brutes", "OpenAI", "10.0.0.12");

        String renduStr = fraude.toString();

        assertNotNull(renduStr, "La méthode toString() ne doit pas renvoyer une chaîne nulle.");
        assertTrue(renduStr.contains("[Fraude IA Connectée]"), "La chaîne doit contenir le tag de la fraude connectée.");
        assertTrue(renduStr.contains("Service utilisé: OpenAI"), "La chaîne doit inclure les informations héritées de FraudeIA.");
        assertTrue(renduStr.contains("Adresse IP: 10.0.0.12"), "La chaîne doit inclure l'attribut spécifique de l'adresse IP.");
    }
}