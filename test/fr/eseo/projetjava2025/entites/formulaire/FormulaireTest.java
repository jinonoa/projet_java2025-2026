package fr.eseo.projetjava2025.entites.formulaire;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fr.eseo.projetjava2025.entites.epreuve.Epreuve;
import fr.eseo.projetjava2025.entites.epreuve.Modalite;
import fr.eseo.projetjava2025.entites.etudiant.Cursus;
import fr.eseo.projetjava2025.entites.etudiant.Etudiant;
import fr.eseo.projetjava2025.entites.fraude.Fraude;
import fr.eseo.projetjava2025.entites.fraude.FraudePapier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @file FormulaireTest.java
 * @brief Classe de tests unitaires automatiques pour la classe Formulaire.
 * @details Valide le comportement des différents constructeurs, la gestion dynamique
 * des listes (étudiants et fraudes), la mise à jour automatique de la date de modification
 * et la génération de la chaîne textuelle.
 */
public class FormulaireTest {

    /**
     * @brief Test du constructeur par défaut.
     * @details Vérifie l'initialisation automatique des dates et des listes à blanc.
     */
    @Test
    public void testConstructeurParDefaut() {
        Formulaire form = new Formulaire();

        assertNotNull(form.getDateDeCreation(), "La date de création ne doit pas être nulle.");
        assertNotNull(form.getDateDeModification(), "La date de modification ne doit pas être nulle.");
        assertNotNull(form.getEtudiants(), "La liste des étudiants doit être initialisée.");
        assertNotNull(form.getFraudes(), "La liste des fraudes doit être initialisée.");
        assertTrue(form.getEtudiants().isEmpty(), "La liste des étudiants doit être vide par défaut.");
        assertTrue(form.getFraudes().isEmpty(), "La liste des fraudes doit être vide par défaut.");
    }

    /**
     * @brief Test du constructeur à 4 paramètres (utilisé lors de la saisie initiale).
     */
    @Test
    public void testConstructeurQuatreParametres() {
        Epreuve epreuve = new Epreuve("M4102", LocalDate.now(), null, 120, Modalite.EXAMEN_ECRIT);
        LocalDateTime dateCreation = LocalDateTime.now().minusDays(1);
        LocalDateTime dateModif = LocalDateTime.now().minusDays(1);

        Formulaire form = new Formulaire(10, dateCreation, dateModif, epreuve);

        assertEquals(10, form.getIdentifiant(), "L'identifiant doit correspondre.");
        assertEquals(dateCreation, form.getDateDeCreation(), "La date de création doit correspondre.");
        assertEquals(dateModif, form.getDateDeModification(), "La date de modification doit correspondre.");
        assertEquals(epreuve, form.getEpreuve(), "L'épreuve doit correspondre.");
        assertTrue(form.getEtudiants().isEmpty(), "La liste des étudiants doit être vide.");
        assertTrue(form.getFraudes().isEmpty(), "La liste des fraudes doit être vide.");
    }

    /**
     * @brief Test du constructeur complet à 6 paramètres, y compris la gestion du paramètre null.
     */
    @Test
    public void testConstructeurCompletEtSecuriteNull() {
        Epreuve epreuve = new Epreuve("M4102", LocalDate.now(), null, 120, Modalite.EXAMEN_ECRIT);

        // Test avec des listes null pour vérifier la robustesse et l'instanciation automatique
        Formulaire formNullLists = new Formulaire(1, LocalDateTime.now(), LocalDateTime.now(), epreuve, null, null);
        assertNotNull(formNullLists.getEtudiants(), "Le constructeur doit remplacer une liste d'étudiants null par une liste vide.");
        assertNotNull(formNullLists.getFraudes(), "Le constructeur doit remplacer une liste de fraudes null par une liste vide.");

        // Test nominal avec des listes valides
        List<Etudiant> listEtud = new ArrayList<>();
        listEtud.add(new Etudiant("Jean", "Dupont", 22001, Cursus.E1));
        List<Fraude> listFraud = new ArrayList<>();
        listFraud.add(new FraudePapier(LocalDate.now(), "Notes", "Contenu", "A4", false));

        Formulaire formNominal = new Formulaire(2, LocalDateTime.now(), LocalDateTime.now(), epreuve, listEtud, listFraud);
        assertEquals(1, formNominal.getEtudiants().size(), "La liste d'étudiants doit contenir 1 élément.");
        assertEquals(1, formNominal.getFraudes().size(), "La liste de fraudes doit contenir 1 élément.");
    }

    /**
     * @brief Test de l'ajout et de la suppression d'un étudiant avec vérification des doublons.
     * @details Le cahier des charges stipule qu'une action met à jour la date de dernière modification.
     */
    @Test
    public void testGestionEtudiants() {
        Formulaire form = new Formulaire();
        Etudiant e1 = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);

        // Ajout nominal
        form.ajouteEtudiant(e1);
        assertEquals(1, form.getEtudiants().size(), "L'étudiant doit être ajouté.");
        assertTrue(form.getEtudiants().contains(e1), "L'étudiant e1 doit être présent.");

        // Tentative d'ajout d'un doublon
        form.ajouteEtudiant(e1);
        assertEquals(1, form.getEtudiants().size(), "Un étudiant déjà présent ne doit pas être ré-ajouté.");

        // Tentative d'ajout d'un élément null
        form.ajouteEtudiant(null);
        assertEquals(1, form.getEtudiants().size(), "L'ajout d'un étudiant null doit être ignoré.");

        // Suppression nominale
        form.supprimeEtudiant(e1);
        assertTrue(form.getEtudiants().isEmpty(), "La liste doit être vide après suppression.");
    }

    /**
     * @brief Test de l'ajout et de la suppression d'une fraude avec vérification des doublons.
     */
    @Test
    public void testGestionFraudes() {
        Formulaire form = new Formulaire();
        Fraude f1 = new FraudePapier(LocalDate.now(), "Aide-mémoire", "Formules", "A5", true);

        // Ajout nominal
        form.ajouteFraude(f1);
        assertEquals(1, form.getFraudes().size(), "La fraude doit être ajoutée.");

        // Tentative d'ajout d'un doublon
        form.ajouteFraude(f1);
        assertEquals(1, form.getFraudes().size(), "Une fraude déjà présente ne doit pas être ré-ajoutée.");

        // Tentative d'ajout d'un élément null
        form.ajouteFraude(null);
        assertEquals(1, form.getFraudes().size(), "L'ajout d'une fraude null doit être ignoré.");

        // Suppression nominale
        form.supprimeFraude(f1);
        assertTrue(form.getFraudes().isEmpty(), "La liste doit être vide après suppression.");
    }

    /**
     * @brief Test des mutateurs (setters) et du mécanisme de rafraîchissement de l'horodatage.
     */
    @Test
    public void testSettersEtMiseAJourDate() {
        Formulaire form = new Formulaire();
        LocalDateTime ancienneDateModif = form.getDateDeModification();

        // Forcer un changement d'identifiant
        form.setIdentifiant(42);
        assertEquals(42, form.getIdentifiant());
        assertNotNull(form.getDateDeModification(), "La date de modification doit être actualisée.");

        // Forcer un changement d'épreuve
        Epreuve epreuve = new Epreuve("M3105", LocalDate.now(), null, 90, Modalite.TP);
        form.setEpreuve(epreuve);
        assertEquals(epreuve, form.getEpreuve());

        // Forcer manuellement le changement de la date de création
        LocalDateTime dateFixe = LocalDateTime.of(2026, 5, 1, 10, 0);
        form.setDateDeCreation(dateFixe);
        assertEquals(dateFixe, form.getDateDeCreation());
    }

    /**
     * @brief Test de la méthode de sérialisation textuelle toString().
     * @details S'assure de la couverture des branches conditionnelles (listes vides vs listes remplies).
     */
    @Test
    public void testToString() {
        Formulaire form = new Formulaire();
        form.setIdentifiant(99);

        // 1. Test à vide
        String renduVide = form.toString();
        assertTrue(renduVide.contains("DOSSIER DE FRAUDE N° 99"), "Le rendu doit afficher le bon ID.");
        assertTrue(renduVide.contains("Aucun étudiant enregistré"), "Le rendu doit identifier l'absence d'étudiant.");
        assertTrue(renduVide.contains("Aucune fraude enregistrée"), "Le rendu doit identifier l'absence de fraude.");

        // 2. Test avec des données rattachées
        Epreuve epreuve = new Epreuve("M4102", LocalDate.now(), null, 120, Modalite.EXAMEN_ECRIT);
        Etudiant etudiant = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);
        Fraude fraude = new FraudePapier(LocalDate.now(), "Triche", "Contenu", "A5", true);

        form.setEpreuve(epreuve);
        form.ajouteEtudiant(etudiant);
        form.ajouteFraude(fraude);

        String renduRempli = form.toString();
        assertTrue(renduRempli.contains("Jean Dupont"), "Le rendu doit lister l'étudiant impliqué.");
        assertTrue(renduRempli.contains("M4102"), "Le rendu doit afficher les détails de l'épreuve.");
    }
}