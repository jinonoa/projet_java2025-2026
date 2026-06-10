package fr.eseo.projetjava2025.graphe;

import fr.eseo.projetjava2025.entites.etudiant.Etudiant;
import fr.eseo.projetjava2025.entites.formulaire.Formulaire;

import java.util.*;

/**
 * @file GrapheEtudiants.java
 * @brief Fichier contenant la classe GrapheEtudiants.
 */

/**
 * @class GrapheEtudiants
 * @brief Classe représentant le graphe des relations entre étudiants fraudeurs.
 *
 * Cette classe permet de construire et d'exploiter un graphe non orienté
 * reliant les étudiants apparaissant ensemble dans un même formulaire de fraude,
 * afin de représenter les liens potentiels de plagiat.
 */
public class GrapheEtudiants {

    /**
     * @brief Structure de données représentant le graphe.
     * Chaque étudiant est associé à l'ensemble des étudiants avec qui il est lié.
     */
    private Map<Etudiant, Set<Etudiant>> graphe;

    /**
     * @brief Constructeur par défaut.
     * Initialise le graphe vide.
     */
    public GrapheEtudiants() {
        this.graphe = new HashMap<>();
    }

    /**
     * @brief Construit le graphe à partir d'une liste de formulaires.
     * Pour chaque formulaire, relie entre eux tous les étudiants présents.
     * @param formulaires La liste des formulaires à analyser.
     */
    public void construireGraphe(List<Formulaire> formulaires) {
        graphe.clear();
        for (Formulaire f : formulaires) {
            List<Etudiant> etudiants = f.getEtudiants();
            for (int i = 0; i < etudiants.size(); i++) {
                for (int j = i + 1; j < etudiants.size(); j++) {
                    ajouterRelation(etudiants.get(i), etudiants.get(j));
                }
            }
        }
    }

    /**
     * @brief Ajoute une relation bidirectionnelle entre deux étudiants.
     * @param e1 Premier étudiant.
     * @param e2 Deuxième étudiant.
     */
    public void ajouterRelation(Etudiant e1, Etudiant e2) {
        graphe.computeIfAbsent(e1, k -> new HashSet<>()).add(e2);
        graphe.computeIfAbsent(e2, k -> new HashSet<>()).add(e1);
    }

    /**
     * @brief Génère une représentation textuelle du graphe.
     * @return String affichant les relations entre étudiants.
     */
    public String afficherGraphe() {
        StringBuilder sb = new StringBuilder(" Graphe des étudiants fraudeurs \n");
        for (Map.Entry<Etudiant, Set<Etudiant>> entry : graphe.entrySet()) {
            sb.append(entry.getKey().getNom())
                    .append(" <-> ")
                    .append(entry.getValue().stream()
                            .map(Etudiant::getNom)
                            .reduce((a, b) -> a + ", " + b)
                            .orElse("(aucun)"))
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * @brief Retourne l'ensemble des étudiants voisins d'un étudiant donné.
     * @param e L'étudiant dont on veut les voisins.
     * @return Set<Etudiant> L'ensemble des étudiants liés à cet étudiant.
     */
    public Set<Etudiant> getVoisins(Etudiant e) {
        return graphe.getOrDefault(e, new HashSet<>());
    }
}