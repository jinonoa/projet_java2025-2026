package fr.eseo.projetjava2025.interfaceUt;

import fr.eseo.projetjava2025.entites.epreuve.Epreuve;
import fr.eseo.projetjava2025.entites.epreuve.Modalite;
import fr.eseo.projetjava2025.entites.etudiant.Cursus;
import fr.eseo.projetjava2025.entites.etudiant.Etudiant;
import fr.eseo.projetjava2025.entites.formulaire.Formulaire;
import fr.eseo.projetjava2025.entites.fraude.*;
import fr.eseo.projetjava2025.graphe.GrapheEtudiants;
import fr.eseo.projetjava2025.service.FormulaireService;
import fr.eseo.projetjava2025.service.RechercheService;
import fr.eseo.projetjava2025.service.StatistiquesService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @file MenuPrincipal.java
 * @brief Classe principale de pilotage de l'IHM textuelle de l'application de gestion des fraudes.
 * @details Gère la boucle globale d'exécution, l'aiguillage des choix du gestionnaire et orchestre
 * les intéractions entres les différents services conformément aux diagrammes de séquences.
 */
public class MenuPrincipal {

    /** @brief Composant d'acquisition clavier. */
    private SaisieUtilisateur saisie = new SaisieUtilisateur();
    /** @brief Composant de restitution visuelle console. */
    private AffichageConsole affichage = new AffichageConsole();

    // Attributs d'injections des couches métiers et structures de données
    private FormulaireService formulaireService;
    private RechercheService rechercheService;
    private StatistiquesService statistiquesService;
    private GrapheEtudiants grapheEtudiants;

    /**
     * @brief Constructeur par initialisation/injection de dépendances.
     */
    public MenuPrincipal(FormulaireService fs, RechercheService rs, StatistiquesService ss, GrapheEtudiants ge) {
        this.formulaireService = fs;
        this.rechercheService = rs;
        this.statistiquesService = ss;
        this.grapheEtudiants = ge;
    }

    /**
     * @brief Permet à l'utilisateur de choisir et de saisir une fraude.
     * @return Fraude L'instance de la fraude créée selon le type choisi.
     */
    private Fraude saisirFraude() {
        affichage.afficherMessage("\nType de fraude :");
        affichage.afficherMessage("1. Fraude IA");
        affichage.afficherMessage("2. Fraude IA Connectée");
        affichage.afficherMessage("3. Fraude Calculatrice");
        affichage.afficherMessage("4. Fraude Papier");
        int choix = saisie.lireInt();

        affichage.afficherMessage("Description : ");
        String description = saisie.lireString();
        affichage.afficherMessage("Contenu : ");
        String contenu = saisie.lireString();
        affichage.afficherMessage("Date de relevé (dd/MM/yyyy) : ");
        LocalDate dateReleve = saisie.lireDate();

        switch (choix) {
            case 1:
                affichage.afficherMessage("Nom du service IA : ");
                String nomIA = saisie.lireString();
                return new FraudeIA(dateReleve, description, contenu, nomIA);
            case 2:
                affichage.afficherMessage("Nom du service IA : ");
                String nomIAC = saisie.lireString();
                affichage.afficherMessage("Adresse IP : ");
                String ip = saisie.lireString();
                return new FraudeIAConnectee(dateReleve, description, contenu, nomIAC, ip);
            case 3:
                affichage.afficherMessage("Marque de la calculatrice : ");
                String marque = saisie.lireString();
                affichage.afficherMessage("Programme stocké : ");
                String programme = saisie.lireString();
                return new FraudeCalculatrice(dateReleve, description, contenu, marque, programme);
            case 4:
                affichage.afficherMessage("Dimensions du papier : ");
                String dimensions = saisie.lireString();
                affichage.afficherMessage("Plié ? (o/n) : ");
                boolean plie = saisie.lireString().equalsIgnoreCase("o");
                return new FraudePapier(dateReleve, description, contenu, dimensions, plie);
            default:
                affichage.afficherErreur("Type invalide, fraude papier créée par défaut.");
                return new FraudePapier(dateReleve, description, contenu, "inconnue", false);
        }
    }

    /**
     * @brief Affiche textuellement la liste des fonctionnalités disponibles.
     */
    public void afficherMenu() {
        affichage.afficherMessage("\n================ GESTION DES CAS DE FRAUDE ================");
        affichage.afficherMessage("1. Enregistrer un nouveau formulaire de fraude");
        affichage.afficherMessage("2. Consulter l'intégralité des formulaires existants");
        affichage.afficherMessage("3. Supprimer (retirer) un formulaire par son identifiant");
        affichage.afficherMessage("4. Rechercher un étudiant par son numéro unique d'apprenant");
        affichage.afficherMessage("5. Générer et afficher les statistiques globales");
        affichage.afficherMessage("6. Générer et visualiser le graphe de plagiat");
        affichage.afficherMessage("7. Quitter le programme");
        affichage.afficherMessage("===========================================================");
        System.out.print("Veuillez renseigner votre choix : ");
    }

    /**
     * @brief Lance l'exécution continue de l'application.
     */
    public void lancerApplication() {
        int choix = 0;
        do {
            afficherMenu();
            choix = saisie.lireInt();
            gererChoix(choix);
        } while (choix != 7);
    }

    /**
     * @brief Routeur interne appelant l'action métier associée à l'option saisie.
     * @param choix Option numérique saisie par l'utilisateur.
     */
    private void gererChoix(int choix) {
        switch (choix) {
            case 1 -> ajouterNouveauFormulaire();
            case 2 -> consulterFormulaires();
            case 3 -> retirerFormulaire();
            case 4 -> rechercherEtudiant();
            case 5 -> afficherStatistiques();
            case 6 -> afficherGraphePlagiat();
            case 7 -> affichage.afficherMessage("Fermeture en cours... Merci d'avoir utilisé l'application.");
            default -> affichage.afficherErreur("Option inconnue. Veuillez entrer un nombre entre 1 et 7.");
        }
    }

    /**
     * @brief Scénario d'ajout de formulaire traduit fidèlement depuis votre diagramme de séquence (Page 6).
     * @note Utilise précisément les attributs : codeECUE, date, heure, duree, modalite pour l'Epreuve.
     */
    private void ajouterNouveauFormulaire() {
        affichage.afficherMessage("\n--- SÉQUENCE D'ENREGISTREMENT D'UNE FRAUDE ---");

        // Saisie des métadonnées de l'épreuve
        System.out.print("Code ECUE de l'épreuve (Ex: M4102) : ");
        String codeECUE = saisie.lireString();
        System.out.print("Date de l'épreuve (JJ/MM/AAAA) : ");
        java.time.LocalDate date = saisie.lireDate();
        System.out.print("Durée de l'épreuve (en minutes) : ");
        int duree = saisie.lireInt();

        // Affectation d'une modalité standard pour la console
        Modalite modaliteChoisie = choisirModalite();
        Epreuve epreuve = new Epreuve(codeECUE, date, null, duree, modaliteChoisie);

        // Attribution d'un identifiant numérique incrémental automatique pour le Formulaire
        int identifiant = formulaireService.getTousLesFormulaires().size() + 1;

        // Création du formulaire (dateDeCreation et dateDeModification fixées à l'instant t)
        Formulaire formulaire = new Formulaire(identifiant, LocalDateTime.now(), LocalDateTime.now(), epreuve);


        // Boucle d'enregistrement des étudiants impliqués (Diagramme de Séquence, boucle 1)
        String optionEtudiant;
        do {
            affichage.afficherMessage("\n-> Enregistrement d'un étudiant impliqué :");
            System.out.print("Nom : ");
            String nom = saisie.lireString();
            System.out.print("Prénom : ");
            String prenom = saisie.lireString();
            System.out.print("Numéro d'apprenant (entier) : ");
            int numeroApprenant = saisie.lireInt();

            Cursus cursusChoisi = choisirCursus();
            Etudiant etudiant = new Etudiant(prenom, nom, numeroApprenant, cursusChoisi);
            formulaire.ajouteEtudiant(etudiant);

            System.out.print("Y a-t-il un autre étudiant impliqué conjointement ? (o/n) : ");
            optionEtudiant = saisie.lireString();
        } while (optionEtudiant.equalsIgnoreCase("o"));

        // Boucle d'enregistrement des pièces de fraude constatées (Diagramme de Séquence, boucle 2)
        String optionFraude;
        do {
            // APPEL DE VOTRE MÉTHODE ICI :
            Fraude fraude = saisirFraude();

            // Ajout de l'objet créé (qu'il soit IA, Calculatrice ou Papier) au formulaire
            formulaire.ajouteFraude(fraude);

            System.out.print("Souhaitez-vous annexer un autre fait de fraude à ce dossier ? (o/n) : ");
            optionFraude = saisie.lireString();
        } while (optionFraude.equalsIgnoreCase("o"));

        // Persistance finale au sein du service
        formulaireService.ajouterFormulaire(formulaire);
        affichage.afficherSucces("Le dossier de fraude N°" + identifiant + " a été consigné avec succès !");
    }


    /**
     * @brief Scénario interactif de retrait de dossier (Exigence du Cahier des charges).
     */
    private void retirerFormulaire() {
        affichage.afficherMessage("\n--- RETRAIT D'UN DOSSIER DE FRAUDE ---");
        System.out.print("Entrez l'identifiant du formulaire à supprimer : ");
        int id = saisie.lireInt();

        // Appel de la méthode de suppression créée à l'étape 1
        boolean succes = formulaireService.supprimerFormulaire(id);

        if (succes) {
            affichage.afficherSucces("Le formulaire N°" + id + " a bien été retiré du système.");
        } else {
            affichage.afficherErreur("L'identifiant " + id + " est inconnu. Aucun retrait effectué.");
        }
    }

    private Cursus choisirCursus() {
        affichage.afficherMessage("Sélectionnez le cursus de l'étudiant :");
        Cursus[] lesCursus = Cursus.values();

        // On affiche dynamiquement toutes les options de l'Enum
        for (int i = 0; i < lesCursus.length; i++) {
            affichage.afficherMessage((i + 1) + ". " + lesCursus[i].name());
        }

        System.out.print("Votre choix : ");
        int choix = saisie.lireInt();

        // Securité au cas où l'utilisateur saisit un nombre en dehors des options
        while (choix < 1 || choix > lesCursus.length) {
            System.out.print("Choix invalide. Veuillez entrer un nombre entre 1 et " + lesCursus.length + " : ");
            choix = saisie.lireInt();
        }

        // On retourne le cursus correspondant (index - 1 car les tableaux commencent à 0)
        return lesCursus[choix - 1];
    }

    private Modalite choisirModalite() {
        affichage.afficherMessage("Sélectionnez la modalité de l'épreuve :");
        Modalite[] lesModalites = Modalite.values();

        for (int i = 0; i < lesModalites.length; i++) {
            affichage.afficherMessage((i + 1) + ". " + lesModalites[i].name());
        }

        System.out.print("Votre choix : ");
        int choix = saisie.lireInt();

        while (choix < 1 || choix > lesModalites.length) {
            System.out.print("Choix invalide. Veuillez entrer un nombre entre 1 et " + lesModalites.length + " : ");
            choix = saisie.lireInt();
        }

        return lesModalites[choix - 1];
    }

    private void consulterFormulaires() {
        List<Formulaire> formulaires = formulaireService.getTousLesFormulaires();
        if (formulaires.isEmpty()) {
            affichage.afficherMessage("Aucune donnée enregistrée dans l'application.");
            return;
        }
        for (Formulaire f : formulaires) {
            affichage.afficherMessage(f.toString());
        }
    }

    private void rechercherEtudiant() {
        System.out.print("\nSaisissez le numéro d'apprenant à rechercher : ");
        String numero = saisie.lireString();
        Etudiant e = rechercheService.rechercherEtudiantsParNumero(numero);
        if (e != null) {
            affichage.afficherMessage("Résultat de recherche : " + e.getPrenom() + " " + e.getNom() + " (Cursus : " + e.getCursus() + ")");
        } else {
            affichage.afficherErreur("Aucun étudiant ne correspond à ce numéro dans la base de données de fraude.");
        }
    }

    private void afficherStatistiques() {
        affichage.afficherMessage("\n--- ÉDITION DES METRIQUES ET STATISTIQUES ---");
        // Les appels s'enchaînent de manière synchrone, à l'image du diagramme de séquence (Page 7)
        affichage.afficherMessage("Nombre total de formulaires instanciés : " + statistiquesService.nombreTotalFormulaires());
        affichage.afficherMessage("Nombre global d'étudiants fraudeurs uniques : " + statistiquesService.nombreEtudiantsDistincts());
        affichage.afficherMessage("Nombre cumulé d'infractions (fraudes) : " + statistiquesService.nombreTotalFraudes());
        affichage.afficherMessage("Moyenne arithmétique de fraudes par formulaire : " + statistiquesService.moyenneFraudesParFormulaire());
        affichage.afficherMessage("Écart-type de la distribution des fraudes : " + statistiquesService.ecartTypeFraudesParFormulaire());
    }

    private void afficherGraphePlagiat() {
        // Exécution de la cinématique décrite en Page 8 : calcul, puis récupération textuelle
        grapheEtudiants.construireGraphe(formulaireService.getTousLesFormulaires());
        affichage.afficherMessage("\n" + grapheEtudiants.afficherGraphe());
    }
}