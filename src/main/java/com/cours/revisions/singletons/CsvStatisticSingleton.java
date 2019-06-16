/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author elhad
 */
public class CsvStatisticSingleton extends AbstractStatisticSingleton {

    final String personnesCsvPathFile = "personnesCsv.csv";
    
    private static CsvStatisticSingleton INSTANCE = null;

    public static CsvStatisticSingleton getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new CsvStatisticSingleton();
        }
        return INSTANCE;
    }
    
    private CsvStatisticSingleton() {
        this.extractPersonnesDatas();
    }

    private Personne createPersonneWithFileObject(String[] attributs) {
        Personne p = new Personne(attributs[1], 
                                          attributs[2], 
                                          Double.parseDouble(attributs[3]),
                                          Double.parseDouble(attributs[4]),
                                          attributs[5],
                                          attributs[6],
                                          attributs[7]);
        return p;
    }

    @Override
    protected void extractPersonnesDatas() {
        BufferedReader br = null;
        String line = "";
        String seperator = ";";

        try {
            br = new BufferedReader(new FileReader(this.personnesCsvPathFile));
            line = br.readLine(); // We read the reader of CVS first
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(seperator);
                Personne personne = this.createPersonneWithFileObject(attributes);
                this.personnes.add(personne);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
