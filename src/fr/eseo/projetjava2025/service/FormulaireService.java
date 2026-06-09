package fr.eseo.projetjava2025.service;

import fr.eseo.projetjava2025.entites.formulaire.Formulaire;

import java.util.ArrayList;
import java.util.List;

/**
 * @file FormulaireService.java
 * @brief Fichier contenant la classe FormulaireService.
 */

/**
 * @class FormulaireService
 * @brief Classe de service gérant les opérations sur les formulaires.
 *
 * Cette classe constitue la couche métier pour la gestion des formulaires.
 * Elle permet d'ajouter, supprimer, rechercher et lister les formulaires.
 */
public class FormulaireService {

    /** @brief Liste interne stockant tous les formulaires enregistrés. */
    private List<Formulaire> formulaires;

    /**
     * @brief Constructeur par défaut.
     * Initialise la liste des formulaires vide.
     */
    public FormulaireService() {
        this.formulaires = new ArrayList<>();
    }

    /**
     * @brief Ajoute un formulaire à la liste s'il n'est pas null.
     * @param f Le formulaire à ajouter.
     */
    public void ajouterFormulaire(Formulaire f) {
        if (f != null && !formulaires.contains(f)) {
            formulaires.add(f);
        }
    }

    /**
     * @brief Supprime un formulaire à partir de son identifiant.
     * @param id L'identifiant du formulaire à supprimer.
     * @return true si le formulaire a été supprimé, false sinon.
     */
    public boolean supprimerFormulaire(int id) {
        return formulaires.removeIf(f -> f.getIdentifiant() == id);
    }

    /**
     * @brief Recherche un formulaire par son identifiant.
     * @param id L'identifiant du formulaire recherché.
     * @return Le formulaire correspondant ou null s'il n'existe pas.
     */
    /**
    public Formulaire getFormulaire(int id) {
        return formulaires.stream()
                .filter(f -> f.getIdentifiant() == id)
                .findFirst()
                .orElse(null);
    }
     */
    /**
     * @brief Retourne la liste complète des formulaires enregistrés.
     * @return List<Formulaire> contenant tous les formulaires.
     */
    public List<Formulaire> getTousLesFormulaires() {
        return formulaires;
    }
}