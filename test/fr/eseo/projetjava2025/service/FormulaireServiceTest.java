package fr.eseo.projetjava2025.service;
import fr.eseo.projetjava2025.entites.formulaire.Formulaire;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @file FormulaireServiceTest.java
 * @brief Tests pour le service FormulaireService.
 */
public class FormulaireServiceTest {

    /**
     * @brief Teste la création du service.
     * @details Vérifie que la liste de départ est bien vide.
     */
    @Test
    public void testInit() {
        FormulaireService service = new FormulaireService();
        List<Formulaire> liste = service.getTousLesFormulaires();

        assertNotNull(liste);
        assertTrue(liste.isEmpty());
    }

    /**
     * @brief Teste l'ajout d'un formulaire.
     * @details Vérifie que le formulaire est bien dans la liste après l'ajout.
     */
    @Test
    public void testAjout() {
        FormulaireService service = new FormulaireService();
        Formulaire f = new Formulaire();
        f.setIdentifiant(1);

        service.ajouterFormulaire(f);
        List<Formulaire> liste = service.getTousLesFormulaires();

        assertEquals(1, liste.size());
        assertTrue(liste.contains(f));
    }

    /**
     * @brief Teste l'ajout d'un objet null.
     * @details Vérifie qu'un formulaire null n'est pas ajouté à la liste.
     */
    @Test
    public void testAjoutNull() {
        FormulaireService service = new FormulaireService();

        service.ajouterFormulaire(null);
        List<Formulaire> liste = service.getTousLesFormulaires();

        assertTrue(liste.isEmpty());
    }

    /**
     * @brief Teste une suppression réussie.
     * @details Vérifie qu'on peut supprimer un formulaire qui existe.
     */
    @Test
    public void testSuppressionOk() {
        FormulaireService service = new FormulaireService();
        Formulaire f = new Formulaire();
        f.setIdentifiant(42);
        service.ajouterFormulaire(f);

        boolean suppr = service.supprimerFormulaire(42);
        List<Formulaire> liste = service.getTousLesFormulaires();

        assertTrue(suppr);
        assertTrue(liste.isEmpty());
    }

    /**
     * @brief Teste une suppression ratée.
     * @details Vérifie qu'on ne supprime rien si l'identifiant n'existe pas.
     */

    @Test
    public void testSuppressionKo() {
        FormulaireService service = new FormulaireService();
        Formulaire f = new Formulaire();
        f.setIdentifiant(42);
        service.ajouterFormulaire(f);

        boolean suppr = service.supprimerFormulaire(99); // ID inconnu
        List<Formulaire> liste = service.getTousLesFormulaires();

        assertFalse(suppr);
        assertEquals(1, liste.size());
    }
}