package fr.eseo.projetjava2025.main;

import fr.eseo.projetjava2025.entites.epreuve.Epreuve;
import fr.eseo.projetjava2025.entites.epreuve.Modalite;
import fr.eseo.projetjava2025.entites.etudiant.Cursus;
import fr.eseo.projetjava2025.entites.etudiant.Etudiant;
import fr.eseo.projetjava2025.entites.formulaire.Formulaire;
import fr.eseo.projetjava2025.entites.fraude.*;
import fr.eseo.projetjava2025.graphe.GrapheEtudiants;
import fr.eseo.projetjava2025.interfaceUt.MenuPrincipal;
import fr.eseo.projetjava2025.service.FormulaireService;
import fr.eseo.projetjava2025.service.RechercheService;
import fr.eseo.projetjava2025.service.StatistiquesService;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @file Application.java
 * @brief Point d'entrée d'exécution unique (Runtime) de l'application de fraude.
 * @details Initialise le système, génère le jeu de données initial obligatoire
 * et lance l'interface utilisateur console.
 */
public class Application {

    /**
     * @brief Méthode exécutable principale bootstrap.
     * @details Initialise l'ensemble des couches d'abstractions logiques (services et graphe),
     * pré-charge un jeu de données de test obligatoire conformément aux contraintes réglementaires
     * de la section 5 du cahier des charges, puis transmet ces instances par injection de dépendances
     * au menu utilisateur.
     * @param args Arguments éventuels passés en ligne de commande (non exploités).
     */
    public static void main(String[] args) {
        // 1. Instanciation des services de logique métier (Singletons applicatifs en mémoire)
        FormulaireService formularioService = new FormulaireService();
        RechercheService rechercheService = new RechercheService(formularioService);
        StatistiquesService statistiquesService = new StatistiquesService(formularioService);

        // 2. Instanciation de l'infrastructure algorithmique de graphe
        GrapheEtudiants grapheEtudiants = new GrapheEtudiants();

        // =========================================================================
        // INITIALISATION DU JEU DE DONNÉES DE TEST OBLIGATOIRE (Cahier des charges Page 3)
        // =========================================================================

        // Initialisation de 4 étudiants de cursus différents (Utilisation directe des imports)
        Etudiant e1 = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);
        Etudiant e2 = new Etudiant("Marie", "Curie", 22002, Cursus.E2);
        Etudiant e3 = new Etudiant("Paul", "Dirac", 22003, Cursus.E3e);
        Etudiant e4 = new Etudiant("Alice", "Bob", 22004, Cursus.E4);

        // Initialisation de 2 épreuves de modalités différentes
        Epreuve ep1 = new Epreuve("M4102", LocalDate.of(2026, 6, 15), null, 120, Modalite.EXAMEN_ECRIT);
        Epreuve ep2 = new Epreuve("M3105", LocalDate.of(2026, 6, 18), null, 180, Modalite.TP);

        // --- FORMULAIRE 1 : Contient une Fraude Papier et implique DEUX étudiants ---
        // (Crée le lien de plagiat exigé pour valider directement le graphe sans saisie)
        Formulaire form1 = new Formulaire(1, LocalDateTime.now(), LocalDateTime.now(), ep1);
        form1.ajouteEtudiant(e1);
        form1.ajouteEtudiant(e2); // Jean et Marie partagent ce dossier -> Lien de plagiat établi
        form1.ajouteFraude(new FraudePapier(LocalDate.of(2026, 6, 15), "Aide-mémoire dissimulé sous la copie", "Formules de mathématiques", "A5", true));
        formularioService.ajouterFormulaire(form1);

        // --- FORMULAIRE 2 : Contient une Fraude IA et une Fraude IA Connectée ---
        Formulaire form2 = new Formulaire(2, LocalDateTime.now(), LocalDateTime.now(), ep1);
        form2.ajouteEtudiant(e3);
        form2.ajouteFraude(new FraudeIA(LocalDate.of(2026, 6, 15), "Génération intégrale du code demandé", "Prompt et structure fournis", "ChatGPT"));
        form2.ajouteFraude(new FraudeIAConnectee(LocalDate.of(2026, 6, 15), "Appels API cloud non autorisés", "Logs de requêtes proxy", "DeepSeek", "192.168.1.45"));
        formularioService.ajouterFormulaire(form2);

        // --- FORMULAIRE 3 : Contient une Fraude Calculatrice ---
        Formulaire form3 = new Formulaire(3, LocalDateTime.now(), LocalDateTime.now(), ep2);
        form3.ajouteEtudiant(e4);
        form3.ajouteFraude(new FraudeCalculatrice(LocalDate.of(2026, 6, 18), "Fichiers de cours enregistrés en mémoire", "Texte complet du chapitre 3", "Casio", "Graph90+"));
        formularioService.ajouterFormulaire(form3);

        // =========================================================================

        // 3. Liaison (Injection) vers l'interface utilisateur textuelle (IHM)
        MenuPrincipal menu = new MenuPrincipal(formularioService, rechercheService, statistiquesService, grapheEtudiants);

        // 4. Lancement opérationnel de l'application console
        menu.lancerApplication();
    }
}