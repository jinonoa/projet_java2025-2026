package fr.eseo.projetjava2025.interfaceUt;

import fr.eseo.projetjava2025.graphe.GrapheEtudiants;
import fr.eseo.projetjava2025.service.FormulaireService;
import fr.eseo.projetjava2025.service.RechercheService;
import fr.eseo.projetjava2025.service.StatistiquesService;

/**
 * @file MenuPrincipal.java
 * @brief Fichier contenant la classe MenuPrincipal.
 */

/**
 * @class MenuPrincipal
 * @brief Classe gérant le menu principal de l'application.
 *
 * Cette classe constitue le point central de l'interface utilisateur.
 * Elle orchestre les interactions entre l'utilisateur et les différents
 * services de l'application via le terminal.
 */
public class MenuPrincipal {

    /** @brief Service de gestion des formulaires. */
    private FormulaireService formulaireService;

    /** @brief Service de recherche. */
    private RechercheService rechercheService;

    /** @brief Service de calcul des statistiques. */
    private StatistiquesService statistiquesService;

    /** @brief Graphe des étudiants fraudeurs. */
    private GrapheEtudiants grapheEtudiants;

    /** @brief Gestionnaire de saisie utilisateur. */
    private SaisieUtilisateur saisie;

    /** @brief Gestionnaire d'affichage console. */
    private AffichageConsole affichage;

    /**
     * @brief Constructeur par défaut.
     * Initialise tous les services et composants de l'interface.
     */
    public MenuPrincipal() {
        this.saisie = new SaisieUtilisateur();
        this.affichage = new AffichageConsole();
        this.formulaireService = new FormulaireService();
        this.rechercheService = new RechercheService(formulaireService);
        this.statistiquesService = new StatistiquesService(formulaireService);
        this.grapheEtudiants = new GrapheEtudiants();
    }

    /**
     * @brief Affiche le menu principal dans le terminal.
     */
    public void afficherMenu() {
        affichage.afficherMessage("\n========== GESTION DES FRAUDES ==========");
        affichage.afficherMessage("1. Ajouter un formulaire de fraude");
        affichage.afficherMessage("2. Consulter les formulaires");
        affichage.afficherMessage("3. Rechercher un étudiant");
        affichage.afficherMessage("4. Afficher les statistiques");
        affichage.afficherMessage("5. Afficher le graphe de plagiat");
        affichage.afficherMessage("0. Quitter");
        affichage.afficherMessage("=========================================");
        affichage.afficherMessage("Votre choix : ");
    }

    /**
     * @brief Lance la boucle principale de l'application.
     * Continue jusqu'à ce que l'utilisateur choisisse de quitter.
     */
    public void lancerApplication() {
        int choix = -1;
        while (choix != 0) {
            afficherMenu();
            choix = saisie.lireInt();
            gererChoix(choix);
        }
        affichage.afficherMessage("Au revoir !");
    }

    /**
     * @brief Gère le choix de l'utilisateur et appelle le service correspondant.
     * @param choix Le numéro de l'option choisie par l'utilisateur.
     */
    public void gererChoix(int choix) {
        switch (choix) {
            case 1:
                affichage.afficherMessage("Fonctionnalité : Ajouter un formulaire (à implémenter)");
                break;
            case 2:
                affichage.afficherMessage("Fonctionnalité : Consulter les formulaires (à implémenter)");
                break;
            case 3:
                affichage.afficherMessage("Fonctionnalité : Rechercher un étudiant (à implémenter)");
                break;
            case 4:
                affichage.afficherMessage("=== Statistiques ===");
                affichage.afficherMessage("Total formulaires : " + statistiquesService.nombreTotalFormulaires());
                affichage.afficherMessage("Total fraudes : " + statistiquesService.nombreTotalFraudes());
                affichage.afficherMessage("Moyenne fraudes/formulaire : " + statistiquesService.moyenneFraudesParFormulaire());
                affichage.afficherMessage("Écart-type : " + statistiquesService.ecartTypeFraudesParFormulaire());
                break;
            case 5:
                grapheEtudiants.construireGraphe(formulaireService.getTousLesFormulaires());
                affichage.afficherMessage(grapheEtudiants.afficherGraphe());
                break;
            case 0:
                break;
            default:
                affichage.afficherErreur("Choix invalide.");
        }
    }
}