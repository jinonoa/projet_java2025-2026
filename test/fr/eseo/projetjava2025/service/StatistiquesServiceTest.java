package fr.eseo.projetjava2025.service;

import fr.eseo.projetjava2025.entites.etudiant.Cursus;
import fr.eseo.projetjava2025.entites.etudiant.Etudiant;
import fr.eseo.projetjava2025.entites.formulaire.Formulaire;
import fr.eseo.projetjava2025.entites.fraude.FraudePapier;
import fr.eseo.projetjava2025.service.FormulaireService;
import fr.eseo.projetjava2025.service.StatistiquesService;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @file StatistiquesServiceTest.java
 * @brief Tests pour la classe StatistiquesService.
 */
public class StatistiquesServiceTest {

    /**
     * @brief Teste les calculs quand la liste est vide.
     */
    @Test
    public void testAideVide() {
        FormulaireService formService = new FormulaireService();
        StatistiquesService statService = new StatistiquesService(formService);

        assertEquals(0, statService.nombreTotalFormulaires());
        assertEquals(0, statService.nombreEtudiantsDistincts());
        assertEquals(0, statService.nombreTotalFraudes());
        assertEquals(0.0, statService.moyenneFraudesParFormulaire());
        assertEquals(0.0, statService.ecartTypeFraudesParFormulaire());
    }

    /**
     * @brief Teste les calculs avec un seul formulaire.
     */
    @Test
    public void testUnFormulaire() {
        FormulaireService formService = new FormulaireService();
        Formulaire f = new Formulaire();
        f.setIdentifiant(1);
        formService.ajouterFormulaire(f);

        StatistiquesService statService = new StatistiquesService(formService);
        assertEquals(1, statService.nombreTotalFormulaires());
        assertEquals(0.0, statService.ecartTypeFraudesParFormulaire());
    }

    /**
     * @brief Teste les calculs avec des données.
     */
    @Test
    public void testCalculs() {
        FormulaireService formService = new FormulaireService();

        Etudiant e1 = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);
        Etudiant e2 = new Etudiant("Marie", "Curie", 22002, Cursus.E2);

        Formulaire f1 = new Formulaire();
        f1.setIdentifiant(1);
        f1.ajouteEtudiant(e1);
        f1.ajouteFraude(new FraudePapier(LocalDate.now(), "Triche 1", "Preuve 1", "A4", true));
        f1.ajouteFraude(new FraudePapier(LocalDate.now(), "Triche 2", "Preuve 2", "A4", true));

        Formulaire f2 = new Formulaire();
        f2.setIdentifiant(2);
        f2.ajouteEtudiant(e1);
        f2.ajouteEtudiant(e2);

        formService.ajouterFormulaire(f1);
        formService.ajouterFormulaire(f2);

        StatistiquesService statService = new StatistiquesService(formService);

        assertEquals(2, statService.nombreTotalFormulaires());
        assertEquals(2, statService.nombreEtudiantsDistincts());
        assertEquals(2, statService.nombreTotalFraudes());
        assertEquals(1.0, statService.moyenneFraudesParFormulaire());
        assertEquals(1.0, statService.ecartTypeFraudesParFormulaire());
    }
}