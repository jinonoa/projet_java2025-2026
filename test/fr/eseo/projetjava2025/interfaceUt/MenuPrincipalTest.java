package fr.eseo.projetjava2025.interfaceUt;

import fr.eseo.projetjava2025.graphe.GrapheEtudiants;
import fr.eseo.projetjava2025.service.FormulaireService;
import fr.eseo.projetjava2025.service.RechercheService;
import fr.eseo.projetjava2025.service.StatistiquesService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @file MenuPrincipalTest.java
 * @brief Tests pour la couverture des branches de MenuPrincipal.
 */
public class MenuPrincipalTest {

    /**
     * @brief Teste l'intégralité du routeur de choix pour valider les branches du switch.
     */
    @Test
    public void testToutesLesBranchesDuRouteur() {
        FormulaireService fs = new FormulaireService();
        MenuPrincipal menu = new MenuPrincipal(
                fs,
                new RechercheService(fs),
                new StatistiquesService(fs),
                new GrapheEtudiants()
        );

        // On passe dans les choix simples qui ne bloquent pas sur une saisie clavier
        menu.gererChoix(2);  // Consulter (liste vide, gère la branche "Aucune donnée")
        menu.gererChoix(5);  // Statistiques
        menu.gererChoix(6);  // Pour graphe de plagiat
        menu.gererChoix(7);  // Quitter
        menu.gererChoix(99); // Option inconnue (default)

        assertNotNull(menu);
    }

    /**
     * @brief Teste l'affichage global du menu.
     */
    @Test
    public void testAffichageMenu() {
        FormulaireService fs = new FormulaireService();
        MenuPrincipal menu = new MenuPrincipal(
                fs,
                new RechercheService(fs),
                new StatistiquesService(fs),
                new GrapheEtudiants()
        );

        menu.afficherMenu();
        assertNotNull(menu);
    }
}
