package fr.eseo.projetjava2025.service;

import fr.eseo.projetjava2025.entites.formulaire.Formulaire;

import java.util.List;

/**
 * @file StatistiquesService.java
 * @brief Fichier contenant la classe StatistiquesService.
 */

/**
 * @class StatistiquesService
 * @brief Classe de service gérant le calcul des statistiques sur les fraudes.
 *
 * Cette classe permet de calculer diverses statistiques à partir
 * des formulaires enregistrés : nombre total de fraudes, moyenne
 * et écart-type de fraudes par formulaire.
 */
public class StatistiquesService {

    /** @brief Service formulaire utilisé pour accéder aux données. */
    private FormulaireService formulaireService;

    /**
     * @brief Constructeur initialisant le service avec un FormulaireService.
     * @param formulaireService Le service de gestion des formulaires.
     */
    public StatistiquesService(FormulaireService formulaireService) {
        this.formulaireService = formulaireService;
    }

    /**
     * @brief Retourne le nombre total de formulaires enregistrés.
     * @return int Le nombre total de formulaires.
     */
    public int nombreTotalFormulaires() {
        return formulaireService.getTousLesFormulaires().size();
    }

    /**
     * @brief Retourne le nombre d'étudiants distincts dans tous les formulaires.
     * @return int Le nombre d'étudiants distincts.
     */
    public int nombreEtudiantsDistincts() {
        return (int) formulaireService.getTousLesFormulaires().stream()
                .flatMap(f -> f.getEtudiants().stream())
                .distinct()
                .count();
    }

    /**
     * @brief Calcule le nombre total de fraudes sur tous les formulaires.
     * @return int Le nombre total de fraudes.
     */
    public int nombreTotalFraudes() {
        return formulaireService.getTousLesFormulaires().stream()
                .mapToInt(f -> f.getFraudes().size())
                .sum();
    }

    /**
     * @brief Calcule la moyenne de fraudes par formulaire.
     * @return double La moyenne de fraudes par formulaire, 0 si aucun formulaire.
     */
    public double moyenneFraudesParFormulaire() {
        List<Formulaire> formulaires = formulaireService.getTousLesFormulaires();
        if (formulaires.isEmpty()) return 0;
        return (double) nombreTotalFraudes() / formulaires.size();
    }

    /**
     * @brief Calcule l'écart-type du nombre de fraudes par formulaire.
     * @return double L'écart-type des fraudes par formulaire, 0 si aucun formulaire.
     */
    public double ecartTypeFraudesParFormulaire() {
        List<Formulaire> formulaires = formulaireService.getTousLesFormulaires();
        if (formulaires.isEmpty()) return 0;
        double moyenne = moyenneFraudesParFormulaire();
        double variance = formulaires.stream()
                .mapToDouble(f -> Math.pow(f.getFraudes().size() - moyenne, 2))
                .average()
                .orElse(0);
        return Math.sqrt(variance);
    }
}