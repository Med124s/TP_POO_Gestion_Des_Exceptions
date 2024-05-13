package org.enset.model.Ex2;

import org.enset.Exceptions.FondsInsuffisantsException;

public class CompteCourant extends CompteBancaire{
    private double decouvertAutorise;

    public CompteCourant(String nomTitulaire, double decouvertAutorise) {
        super(nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirerArgent(double montant) throws FondsInsuffisantsException {
        if (this.solde - montant < -decouvertAutorise) {
            throw new FondsInsuffisantsException("Retrait impossible, dépassement du découvert autorisé.");
        }
        super.retirerArgent(montant);
    }
}
