package fr.eseo.projetjava2025.service;

import fr.eseo.projetjava2025.entites.etudiant.Etudiant;
import fr.eseo.projetjava2025.entites.epreuve.Epreuve;
import fr.eseo.projetjava2025.entites.formulaire.Formulaire;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @file RechercheService.java
 * @brief Fichier contenant la classe RechercheService.
 */

/**
 * @class RechercheService
 * @brief Classe de service gérant les recherches sur les formulaires et les étudiants.
 *
 * Cette classe permet d'effectuer des recherches multicritères
 * sur les formulaires et les étudiants enregistrés dans le système.
 */
public class RechercheService {

    /** @brief Service formulaire utilisé pour accéder aux données. */
    private FormulaireService formulaireService;

    /**
     * @brief Constructeur initialisant le service avec un FormulaireService.
     * @param formulaireService Le service de gestion des formulaires.
     */
    public RechercheService(FormulaireService formulaireService) {
        this.formulaireService = formulaireService;
    }

    /**
     * @brief Recherche tous les formulaires impliquant un étudiant donné.
     * @param e L'étudiant à rechercher.
     * @return Liste des formulaires contenant cet étudiant.
     */
    public List<Formulaire> rechercherFormulairesParEtudiant(Etudiant e) {
        return formulaireService.getTousLesFormulaires().stream()
                .filter(f -> f.getEtudiants().contains(e))
                .collect(Collectors.toList());
    }

    /**
     * @brief Recherche tous les formulaires liés à une épreuve donnée.
     * @param ep L'épreuve à rechercher.
     * @return Liste des formulaires concernant cette épreuve.
     */
    public List<Formulaire> rechercherFormulairesParEpreuve(Epreuve ep) {
        return formulaireService.getTousLesFormulaires().stream()
                .filter(f -> f.getEpreuve().equals(ep))
                .collect(Collectors.toList());
    }

    /**
     * @brief Recherche les étudiants par leur nom.
     * @param nom Le nom à rechercher (insensible à la casse).
     * @return Liste des étudiants correspondants.
     */
    public List<Etudiant> rechercherEtudiantsParNom(String nom) {
        return formulaireService.getTousLesFormulaires().stream()
                .flatMap(f -> f.getEtudiants().stream())
                .filter(e -> e.getNom().equalsIgnoreCase(nom))
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * @brief Recherche les étudiants par leur prénom.
     * @param prenom Le prénom à rechercher (insensible à la casse).
     * @return Liste des étudiants correspondants.
     */
    public List<Etudiant> rechercherEtudiantsParPrenom(String prenom) {
        return formulaireService.getTousLesFormulaires().stream()
                .flatMap(f -> f.getEtudiants().stream())
                .filter(e -> e.getPrenom().equalsIgnoreCase(prenom))
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * @brief Recherche un étudiant par son numéro apprenant.
     * @param numero Le numéro apprenant sous forme de String.
     * @return L'étudiant correspondant ou null s'il n'existe pas.
     */
    public Etudiant rechercherEtudiantsParNumero(String numero) {
        return formulaireService.getTousLesFormulaires().stream()
                .flatMap(f -> f.getEtudiants().stream())
                .filter(e -> String.valueOf(e.getNumeroApprenant()).equals(numero))
                .findFirst()
                .orElse(null);
    }
}