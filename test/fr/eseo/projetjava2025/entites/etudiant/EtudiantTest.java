package fr.eseo.projetjava2025.entites.etudiant;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @file EtudiantTest.java
 * @brief Classe de tests unitaires automatiques pour la classe Etudiant.
 * @details Valide le constructeur, les accesseurs (getters), ainsi que les méthodes comportementales
 * fondamentales de l'objet (equals, hashCode et toString) pour obtenir 100% de couverture.
 */
public class EtudiantTest {

    /**
     * @brief Test unitaire du constructeur et des méthodes d'accès (Getters).
     * @details Vérifie que les informations d'identité, de numéro unique et de cursus sont correctement lues.
     */
    @Test
    public void testConstructeurEtGetters() {
        String prenomAttendu = "Jean";
        String nomAttendu = "Dupont";
        int numeroAttendu = 22001;
        Cursus cursusAttendu = Cursus.E1;

        Etudiant etudiant = new Etudiant(prenomAttendu, nomAttendu, numeroAttendu, cursusAttendu);

        assertNotNull(etudiant, "L'instance d'étudiant ne doit pas être nulle.");
        assertEquals(prenomAttendu, etudiant.getPrenom(), "Le prénom doit correspondre.");
        assertEquals(nomAttendu, etudiant.getNom(), "Le nom doit correspondre.");
        assertEquals(numeroAttendu, etudiant.getNumeroApprenant(), "Le numéro d'apprenant doit correspondre.");
        assertEquals(cursusAttendu, etudiant.getCursus(), "Le cursus doit correspondre.");
    }

    /**
     * @brief Test unitaire de la méthode d'égalité (equals).
     * @details Le cahier des charges spécifie que deux étudiants sont égaux si et seulement si ils possèdent le même numéro d'apprenant.
     */
    @Test
    public void testEquals() {
        Etudiant e1 = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);
        Etudiant e2 = new Etudiant("Jean", "Dupont", 22001, Cursus.E1); // Strictement identique
        Etudiant e3 = new Etudiant("Marie", "Curie", 22001, Cursus.E2); // Même numéro d'apprenant, identité différente
        Etudiant e4 = new Etudiant("Jean", "Dupont", 33999, Cursus.E1); // Même identité, numéro différent

        // Réflectivité et égalité nominale
        assertEquals(e1, e1, "Un étudiant doit être égal à lui-même.");
        assertEquals(e1, e2, "Deux étudiants avec le même numéro d'apprenant doivent être égaux.");
        assertEquals(e1, e3, "Deux étudiants ayant le même numéro unique doivent être égaux, peu importe le nom.");

        // Non-égalité
        assertNotEquals(e1, e4, "Deux étudiants avec des numéros d'apprenant différents ne doivent pas être égaux.");
        assertNotEquals(e1, null, "Un étudiant ne peut pas être égal à null.");
        assertNotEquals(e1, "Une Chaîne de Caractères", "Un étudiant ne peut pas être égal à un objet d'un autre type.");
    }

    /**
     * @brief Test unitaire de la génération du code de hachage (hashCode).
     * @details Vérifie que deux objets logiquement égaux (même numéro d'apprenant) produisent le même hashCode.
     */
    @Test
    public void testHashCode() {
        Etudiant e1 = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);
        Etudiant e2 = new Etudiant("Marie", "Curie", 22001, Cursus.E2);

        assertEquals(e1.hashCode(), e2.hashCode(), "Deux étudiants avec le même numéro d'apprenant doivent avoir le même hashCode.");
    }

    /**
     * @brief Test de la méthode de formatage textuel toString().
     * @details S'assure que le format de sortie respecte strictement le modèle attendu par l'application.
     */
    @Test
    public void testToString() {
        Etudiant etudiant = new Etudiant("Jean", "Dupont", 22001, Cursus.E1);
        String chaineRendue = etudiant.toString();

        assertNotNull(chaineRendue, "La méthode toString() ne doit pas renvoyer une chaîne nulle.");
        assertEquals("Jean Dupont (E1 - n°22001)", chaineRendue, "La chaîne textuelle renvoyée ne correspond pas au format attendu.");
    }
}