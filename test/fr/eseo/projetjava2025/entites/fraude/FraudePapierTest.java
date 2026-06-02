package fr.eseo.projetjava2025.entites.fraude;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * @file FraudePapierTest.java
 * @brief Classe de tests unitaires automatiques pour la classe FraudePapier.
 * @details Valide le constructeur, les accesseurs spécifiques (getters)
 * et la méthode de formatage textuel pour obtenir 100% de couverture sur cette entité.
 */
public class FraudePapierTest {

    /**
     * @brief Test unitaire du constructeur et des méthodes d'accès (Getters).
     * @details Vérifie que les attributs hérités de la classe Fraude ainsi que les attributs
     * physiques spécifiques (dimensions et état de pliage) sont correctement assignés et restitués.
     */
    @Test
    public void testConstructeurEtGetters() {
        LocalDate dateAttendue = LocalDate.of(2026, 6, 2);
        String descAttendue = "Antisèche dissimulée dans la trousse";
        String contenuAttendu = "Théorèmes de géométrie et définitions";
        String dimAttendues = "A6";
        boolean plieAttendu = true;

        FraudePapier fraude = new FraudePapier(dateAttendue, descAttendue, contenuAttendu, dimAttendues, plieAttendu);

        assertNotNull(fraude, "L'instance de FraudePapier ne doit pas être nulle.");
        assertEquals(dateAttendue, fraude.getDateReleve(), "La date de relevé doit correspondre.");
        assertEquals(descAttendue, fraude.getDescription(), "La description doit correspondre.");
        assertEquals(contenuAttendu, fraude.getContenu(), "Le contenu de preuve doit correspondre.");
        assertEquals(dimAttendues, fraude.getDimensions(), "Les dimensions du papier doivent correspondre.");
        assertTrue(fraude.isPlie(), "L'état de pliage du papier doit être à true.");
    }

    /**
     * @brief Test de la méthode de sérialisation textuelle toString() avec état plié à true.
     * @details S'assure que la chaîne de caractères renvoyée contient le tag spécifique de l'entité
     * ainsi que la mention explicite "Plié: Oui".
     */
    @Test
    public void testToStringPapierPlie() {
        LocalDate date = LocalDate.of(2026, 6, 2);
        FraudePapier fraude = new FraudePapier(date, "Notes de cours", "Lignes de code", "A5", true);

        String renduStr = fraude.toString();

        assertNotNull(renduStr, "La méthode toString() ne doit pas renvoyer une chaîne nulle.");
        assertTrue(renduStr.contains("[Fraude Papier]"), "La chaîne doit contenir le tag explicite de la fraude papier.");
        assertTrue(renduStr.contains("Dimensions: A5"), "La chaîne doit mentionner les dimensions.");
        assertTrue(renduStr.contains("Plié: Oui"), "La chaîne doit afficher 'Plié: Oui' lorsque le booléen est vrai.");
    }

    /**
     * @brief Test de la méthode de sérialisation textuelle toString() avec état plié à false.
     * @details S'assure que la condition ternaire gère correctement l'affichage de l'état non plié en retournant "Plié: Non".
     */
    @Test
    public void testToStringPapierNonPlie() {
        LocalDate date = LocalDate.of(2026, 6, 2);
        FraudePapier fraude = new FraudePapier(date, "Feuille libre", "Graphique", "A4", false);

        String renduStr = fraude.toString();

        assertNotNull(renduStr, "La méthode toString() ne doit pas renvoyer une chaîne nulle.");
        assertTrue(renduStr.contains("Plié: Non"), "La chaîne doit afficher 'Plié: Non' lorsque le booléen est faux.");
    }
}