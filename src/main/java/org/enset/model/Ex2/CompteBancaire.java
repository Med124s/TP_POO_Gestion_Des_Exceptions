package org.enset.model.Ex2;

import org.enset.Exceptions.CompteInexistantException;
import org.enset.Exceptions.FondsInsuffisantsException;

public class CompteBancaire {
    protected String nomTitulaire;
    protected double solde;

    public CompteBancaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
        this.solde = 0;
    }

    public void deposerArgent(double montant) {
        this.solde += montant;
        System.out.println("Dépôt de " + montant + " effectué. Nouveau solde : " + this.solde);
    }

    public void retirerArgent(double montant) throws FondsInsuffisantsException {
        if (this.solde < montant) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour retirer " + montant);
        }
        this.solde -= montant;
        System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + this.solde);
    }

    public void afficherSolde() {
        System.out.println("Solde du compte de " + this.nomTitulaire + " : " + this.solde);
    }

    public void transfererArgent(CompteBancaire compteDestinataire, double montant)
            throws FondsInsuffisantsException, CompteInexistantException {
        if (this.solde < montant) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour transférer " + montant);
        }
        if (compteDestinataire == null) {
            throw new CompteInexistantException("Compte destinataire inexistant.");
        }
        this.retirerArgent(montant);
        compteDestinataire.deposerArgent(montant);
        System.out.println("Transfert de " + montant + " effectué vers le compte de " + compteDestinataire.nomTitulaire);
    }
}
