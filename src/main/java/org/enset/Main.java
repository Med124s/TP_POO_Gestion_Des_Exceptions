package org.enset;

import org.enset.Exceptions.CompteInexistantException;
import org.enset.Exceptions.FondsInsuffisantsException;
import org.enset.Exceptions.NombreNegatifException;
import org.enset.model.Ex1.EntierNaturel;
import org.enset.model.Ex2.CompteBancaire;
import org.enset.model.Ex2.CompteCourant;
import org.enset.model.Ex2.CompteEpargne;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Exercice 1:
        System.out.println("************* Exercice 1 *****************");
        try {
            EntierNaturel entier = new EntierNaturel(-5); // Test de création d'entier négatif
        } catch (NombreNegatifException e) {
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("Valeur erronée: " + e.getValeurErronee());
        }

        try {
            EntierNaturel entier = new EntierNaturel(10);
            entier.setVal(-3); // Test de modification avec une valeur négative
        } catch (NombreNegatifException e) {
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("Valeur erronée: " + e.getValeurErronee());
        }

        try {
            EntierNaturel entier = new EntierNaturel(5);
            entier.decrementer(); // Test de décrémentation jusqu'à 0
            entier.decrementer(); // Test de décrémentation d'une valeur nulle
        } catch (NombreNegatifException e) {
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("Valeur erronée: " + e.getValeurErronee());
        }

        System.out.println("********** Exercice 2 **************");

        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        // Ajouter des comptes
        CompteBancaire compte1 = new CompteBancaire("Alice");
        CompteCourant compte2 = new CompteCourant("Bob", 500);
        CompteEpargne compte3 = new CompteEpargne("Charlie", 2.5);

        comptes.add(compte1);
        comptes.add(compte2);
        comptes.add(compte3);

        // Effectuer des opérations sur les comptes
        try {
            compte1.deposerArgent(1000);
            compte2.deposerArgent(2000);
            compte3.deposerArgent(3000);

            compte1.retirerArgent(500);
            compte2.retirerArgent(1500);
            compte3.retirerArgent(2000);

            compte1.transfererArgent(compte2, 200);
            compte2.transfererArgent(compte3, 300);

            compte3.calculerInterets();
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Supprimer un compte
        comptes.remove(compte1);
        System.out.println("Compte de Alice supprimé.");
    }
}