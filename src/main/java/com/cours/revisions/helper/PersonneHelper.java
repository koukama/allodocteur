/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.helper;

import com.cours.revisions.entities.Personne;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

/**
 *
 * @author elhad
 */
public class PersonneHelper {

    private static List<Personne> personnes = null;

    public List<Personne> createListPersonnes() {
        PersonneHelper.personnes = new ArrayList<Personne>();
        return PersonneHelper.personnes;
    }

    public void addPersonne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
       Personne p = this.createPersonne(idPersonne, prenom, nom, poids,taille, rue, ville, codePostal);
       PersonneHelper.personnes.add(p);
       System.out.print(p.getNom());
       System.out.print(PersonneHelper.personnes.size());
    }

    public Personne createPersonne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
       return new Personne(idPersonne, prenom, nom, poids,taille, rue, ville, codePostal);
    }

    public List<Personne> createListPersonnesReflexive() throws InvocationTargetException {
        Method method = null;
        List<Personne> persons = null;
        try {
            method = this.getClass().getMethod("createListPersonnes", null);
            persons =  (List<Personne>) method.invoke(this, null);
        } catch (SecurityException e) { e.printStackTrace();
        } catch(NoSuchMethodException e) { e.printStackTrace();
        } catch (IllegalArgumentException e) { e.printStackTrace();
        } catch (IllegalAccessException e) { e.printStackTrace(); }

        return persons;        
    }

    public void addPersonneReflexive(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) throws InvocationTargetException {
        Method method = null;
        try {
            method = this.getClass().getMethod("addPersonne", Integer.class, String.class, String.class, Double.class, Double.class, String.class, String.class, String.class);
            method.invoke(this, idPersonne, prenom, nom, poids,taille, rue, ville, codePostal);
        } catch (SecurityException e) { e.printStackTrace();
        } catch(NoSuchMethodException e) { e.printStackTrace();
        } catch (IllegalArgumentException e) { e.printStackTrace(); 
        } catch (IllegalAccessException e) { e.printStackTrace(); }
    }

    public Personne createPersonneReflexive(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) throws InvocationTargetException {
        Method method = null;
        Personne p = null;

        try {
            method = this.getClass().getMethod("createPersonne", Integer.class, String.class, String.class, Double.class, Double.class, String.class, String.class, String.class);
            p = (Personne) method.invoke(this, idPersonne, prenom, nom, poids,taille, rue, ville, codePostal);
        } catch (SecurityException e) { e.printStackTrace();
        } catch(NoSuchMethodException e) { e.printStackTrace();
        } catch (IllegalArgumentException e) { e.printStackTrace(); 
        } catch (IllegalAccessException e) { e.printStackTrace(); }

        return p;
    }
}
