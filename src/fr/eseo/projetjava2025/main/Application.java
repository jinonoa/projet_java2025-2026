package fr.eseo.projetjava2025.main;

import fr.eseo.projetjava2025.graphe.GrapheEtudiants;
import fr.eseo.projetjava2025.interfaceUt.MenuPrincipal;
import fr.eseo.projetjava2025.service.FormulaireService;
import fr.eseo.projetjava2025.service.RechercheService;
import fr.eseo.projetjava2025.service.StatistiquesService;

/**
 * @file Application.java
 * @brief Point d'entrée d'exécution unique (Runtime) de l'application de fraude.
 */
public class Application { //

    /**
     * @brief Méthode exécutable principale bootstrap.
     * @details Initialise l'ensemble des couches d'abstractions logiques (services et graphe),
     * puis transmet ces instances par injection de dépendances au menu utilisateur avant de le lancer.
     * @param args Arguments éventuels passés en ligne de commande (non exploités).
     */
    public static void main(String[] args) { //
        // 1. Instanciation des services de logique métier (Singletons applicatifs en mémoire)
        FormulaireService formulaireService = new FormulaireService();
        RechercheService rechercheService = new RechercheService(formulaireService);
        StatistiquesService statistiquesService = new StatistiquesService(formulaireService);

        // 2. Instanciation de l'infrastructure algorithmique de graphe
        GrapheEtudiants grapheEtudiants = new GrapheEtudiants();

        // 3. Liaison (Injection) vers l'interface utilisateur textuelle (IHM)
        MenuPrincipal menu = new MenuPrincipal(formulaireService, rechercheService, statistiquesService, grapheEtudiants);

        // 4. Lancement opérationnel de l'application console
        menu.lancerApplication();
    }
}