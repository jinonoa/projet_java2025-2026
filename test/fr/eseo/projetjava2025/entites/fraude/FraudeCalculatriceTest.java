package fr.eseo.projetjava2025.entites.fraude;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @file FraudeCalculatriceTest.java
 * @brief Classe de tests unitaires automatiques pour la classe FraudeCalculatrice.
 * @details Valide le constructeur, les accesseurs spécifiques (getters)
 * et la méthode de formatage textuel pour obtenir 100% de couverture sur cette entité fille.
 */
public class FraudeCalculatriceTest {

    /**
     * @brief Test unitaire du constructeur et des méthodes d'accès (Getters).
     * @details Vérifie que les attributs hérités de Fraude ainsi que les attributs spécifiques
     * à la calculatrice (marque et programme) sont correctement assignés et restitués.
     */
    @Test
    public void testConstructeurEtGetters() {
        LocalDate dateAttendue = LocalDate.of(2026, 6, 2);
        String descAttendue = "Formules de physique trouvées en mémoire";
        String contenuAttendu = "E=mc^2 ; P=UI";
        String marqueAttendue = "Casio";
        String progAttendu = "MathsSup2026";

        FraudeCalculatrice fraude = new FraudeCalculatrice(dateAttendue, descAttendue, contenuAttendu, marqueAttendue, progAttendu);

        assertNotNull(fraude, "L'instance de FraudeCalculatrice ne doit pas être nulle.");
        assertEquals(dateAttendue, fraude.getDateReleve(), "La date de relevé doit correspondre.");
        assertEquals(descAttendue, fraude.getDescription(), "La description doit correspondre.");
        assertEquals(contenuAttendu, fraude.getContenu(), "Le contenu de preuve doit correspondre.");
        assertEquals(marqueAttendue, fraude.getMarque(), "La marque de l'appareil doit correspondre.");
        assertEquals(progAttendu, fraude.getProgrammeStocke(), "Le nom du programme stocké doit correspondre.");
    }

    /**
     * @brief Test de la méthode de sérialisation textuelle toString().
     * @details S'assure que la chaîne de caractères renvoyée contient le tag spécifique de l'entité
     * ainsi que la marque et le nom du programme frauduleux.
     */
    @Test
    public void testToString() {
        LocalDate date = LocalDate.of(2026, 6, 2);
        FraudeCalculatrice fraude = new FraudeCalculatrice(date, "Aide-mémoire", "Texte", "TI", "Annales");

        String renduStr = fraude.toString();

        assertNotNull(renduStr, "La méthode toString() ne doit pas renvoyer une chaîne nulle.");
        assertTrue(renduStr.contains("[Fraude Calculatrice]"), "La chaîne doit contenir le tag explicite du type de fraude.");
        assertTrue(renduStr.contains("Marque: TI"), "La chaîne doit contenir la marque de l'appareil.");
        assertTrue(renduStr.contains("Programme: Annales"), "La chaîne doit contenir les informations du programme stocké.");
    }
}