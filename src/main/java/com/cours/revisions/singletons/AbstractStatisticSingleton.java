/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author elhad
 */
public abstract class AbstractStatisticSingleton {

    protected List<Personne> personnes = new ArrayList<Personne>();
    protected Double moyennePoids = 0.0;
    protected Double ecartTypePoids = 0.0;

    protected Double moyenneTaille = 0.0;
    protected Double ecartTypeTaille = 0.0;

    public Double getMoyennePoids() {
        Double somme = 0.0;
        for (Personne p: this.personnes) {
            somme += p.getPoids();
        }
        return somme/this.personnes.size();
    }

    public Double getEcartTypePoids() {
        Double ecart = 0.0d;

        for (Personne p : this.personnes){
            ecart += Math.pow((p.getPoids() - this.getMoyennePoids()), 2.0);
        }
        ecart = ecart / this.personnes.size();
        return Math.sqrt(ecart);
    }

    public Double getMoyenneTaille() {
        Double somme = 0.0;
        for (Personne p: this.personnes) {
            somme += p.getTaille();
        }
        return somme/this.personnes.size();
    }

    public Double getEcartTypeTaille() {
        Double ecart = 0.0d;

        for (Personne p : this.personnes){
            ecart += Math.pow((p.getTaille() - this.getMoyenneTaille()), 2.0);
        }
        ecart = ecart / this.personnes.size();
        return Math.sqrt(ecart);
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    protected abstract void extractPersonnesDatas();
}
