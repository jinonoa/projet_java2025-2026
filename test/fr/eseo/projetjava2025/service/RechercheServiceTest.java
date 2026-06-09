package fr.eseo.projetjava2025.service;

import fr.eseo.projetjava2025.entites.epreuve.Epreuve;
import fr.eseo.projetjava2025.entites.epreuve.Modalite;
import fr.eseo.projetjava2025.entites.etudiant.Cursus;
import fr.eseo.projetjava2025.entites.etudiant.Etudiant;
import fr.eseo.projetjava2025.entites.formulaire.Formulaire;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @file RechercheServiceTest.java
 * @brief Tests pour la classe RechercheService.
 */
public class RechercheServiceTest {

    /**
     * @brief Teste la recherche de formulaires par étudiant.
     */
    @Test
    public void testChercheEtudiant() {
        FormulaireService formService = new FormulaireService();
        Etudiant e1 = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);
        Etudiant e2 = new Etudiant("Marie", "Curie", 22002, Cursus.E2);

        Formulaire f = new Formulaire();
        f.ajouteEtudiant(e1);
        formService.ajouterFormulaire(f);

        RechercheService recherche = new RechercheService(formService);

        // Cas trouvé
        List<Formulaire> res1 = recherche.rechercherFormulairesParEtudiant(e1);
        assertEquals(1, res1.size());

        // Cas non trouvé
        List<Formulaire> res2 = recherche.rechercherFormulairesParEtudiant(e2);
        assertTrue(res2.isEmpty());
    }

    /**
     * @brief Teste la recherche de formulaires par épreuve.
     */
    @Test
    public void testChercheEpreuve() {
        FormulaireService formService = new FormulaireService();
        Epreuve ep1 = new Epreuve("MAT101", java.time.LocalDate.now(), java.time.LocalTime.of(8, 30), 90, Modalite.EXAMEN_ECRIT);
        Epreuve ep2 = new Epreuve("PHY101", java.time.LocalDate.now(), java.time.LocalTime.of(10, 0), 120, Modalite.ORAL);

        Formulaire f = new Formulaire();
        f.setEpreuve(ep1);
        formService.ajouterFormulaire(f);

        RechercheService recherche = new RechercheService(formService);

        // Cas trouvé
        List<Formulaire> res1 = recherche.rechercherFormulairesParEpreuve(ep1);
        assertEquals(1, res1.size());

        // Cas non trouvé
        List<Formulaire> res2 = recherche.rechercherFormulairesParEpreuve(ep2);
        assertTrue(res2.isEmpty());
    }

    /**
     * @brief Teste la recherche d'étudiants par leur nom.
     */
    @Test
    public void testChercheNom() {
        FormulaireService formService = new FormulaireService();
        Etudiant e = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);

        Formulaire f = new Formulaire();
        f.ajouteEtudiant(e);
        formService.ajouterFormulaire(f);

        RechercheService recherche = new RechercheService(formService);


        List<Etudiant> res1 = recherche.rechercherEtudiantsParNom("dupont");
        assertEquals(1, res1.size());


        List<Etudiant> res2 = recherche.rechercherEtudiantsParNom("Inconnu");
        assertTrue(res2.isEmpty());
    }

    /**
     * @brief Teste la recherche d'étudiants par leur prénom.
     */
    @Test
    public void testCherchePrenom() {
        FormulaireService formService = new FormulaireService();
        Etudiant e = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);

        Formulaire f = new Formulaire();
        f.ajouteEtudiant(e);
        formService.ajouterFormulaire(f);

        RechercheService recherche = new RechercheService(formService);


        List<Etudiant> res1 = recherche.rechercherEtudiantsParPrenom("JEAN");
        assertEquals(1, res1.size());


        List<Etudiant> res2 = recherche.rechercherEtudiantsParPrenom("Inconnu");
        assertTrue(res2.isEmpty());
    }

    /**
     * @brief Teste la recherche d'un étudiant par son numéro.
     */
    @Test
    public void testChercheNumero() {
        FormulaireService formService = new FormulaireService();
        // Correction ici : on s'adapte à l'ordre des paramètres de ton constructeur (Nom, Prenom)
        Etudiant e = new Etudiant("Dupont", "Jean", 22001, Cursus.E1);

        Formulaire f = new Formulaire();
        f.ajouteEtudiant(e);
        formService.ajouterFormulaire(f);

        RechercheService recherche = new RechercheService(formService);

        // Cas trouvé
        Etudiant res1 = recherche.rechercherEtudiantsParNumero("22001");
        assertNotNull(res1);
        assertEquals("Dupont", res1.getNom()); // On vérifie le nom de famille qui est bien Dupont

        // Cas non trouvé
        Etudiant res2 = recherche.rechercherEtudiantsParNumero("99999");
        assertNull(res2);
    }
}
