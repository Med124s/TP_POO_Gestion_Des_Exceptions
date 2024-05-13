package org.enset.model.Ex2;

public class CompteEpargne extends CompteBancaire{
    private double tauxInteret;

    public CompteEpargne(String nomTitulaire, double tauxInteret) {
        super(nomTitulaire);
        this.tauxInteret = tauxInteret;
    }

    public void calculerInterets() {
        double interets = this.solde * this.tauxInteret / 100;
        this.solde += interets;
        System.out.println("Intérêts calculés et ajoutés. Nouveau solde : " + this.solde);
    }
}
