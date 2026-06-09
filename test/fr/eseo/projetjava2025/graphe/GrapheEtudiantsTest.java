package fr.eseo.projetjava2025.graphe;

import fr.eseo.projetjava2025.entites.etudiant.Cursus;
import fr.eseo.projetjava2025.entites.etudiant.Etudiant;
import fr.eseo.projetjava2025.entites.formulaire.Formulaire;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @file GrapheEtudiantsTest.java
 * @brief Tests pour la classe GrapheEtudiants.
 */
public class GrapheEtudiantsTest {

    /**
     * @brief Teste le graphe quand il n'y a pas de données.
     */
    @Test
    public void testGrapheVide() {
        GrapheEtudiants graphe = new GrapheEtudiants();
        List<Formulaire> listeVide = new ArrayList<>();

        graphe.construireGraphe(listeVide);

        Etudiant e = new Etudiant("Dupont", "Jean", 22001, Cursus.E1);
        assertTrue(graphe.getVoisins(e).isEmpty());
    }

    /**
     * @brief Teste la création des liens de plagiat entre étudiants.
     */
    @Test
    public void testPlagiat() {
        GrapheEtudiants graphe = new GrapheEtudiants();

        Etudiant e1 = new Etudiant("Dupont", "Jean", 22001, Cursus.E1);
        Etudiant e2 = new Etudiant("Curie", "Marie", 22002, Cursus.E2);

        // On met les deux étudiants dans le même formulaire pour créer le lien
        Formulaire f = new Formulaire();
        f.ajouteEtudiant(e1);
        f.ajouteEtudiant(e2);

        List<Formulaire> formulaires = new ArrayList<>();
        formulaires.add(f);

        graphe.construireGraphe(formulaires);

        // Vérification des liens bidirectionnels
        Set<Etudiant> voisinsE1 = graphe.getVoisins(e1);
        Set<Etudiant> voisinsE2 = graphe.getVoisins(e2);

        assertEquals(1, voisinsE1.size());
        assertTrue(voisinsE1.contains(e2));

        assertEquals(1, voisinsE2.size());
        assertTrue(voisinsE2.contains(e1));
    }

    /**
     * @brief Teste l'affichage textuel du graphe.
     */
    @Test
    public void testAffichage() {
        GrapheEtudiants graphe = new GrapheEtudiants();
        Etudiant e1 = new Etudiant("Dupont", "Jean", 22001, Cursus.E1);
        Etudiant e2 = new Etudiant("Curie", "Marie", 22002, Cursus.E2);

        graphe.ajouterRelation(e1, e2);
        String texte = graphe.afficherGraphe();

        assertNotNull(texte);
        assertTrue(texte.contains("Dupont"));
        assertTrue(texte.contains("Curie"));
        assertTrue(texte.contains("<->"));
    }
}