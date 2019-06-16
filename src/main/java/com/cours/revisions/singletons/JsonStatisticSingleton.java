/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author elhad
 */
public class JsonStatisticSingleton extends AbstractStatisticSingleton {

    final String personnesJsonPathFile = "personnesJson.json";
    
    private static JsonStatisticSingleton INSTANCE = null;
     
    public static JsonStatisticSingleton getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new JsonStatisticSingleton();
        }
        return INSTANCE;
    }

    private JsonStatisticSingleton() {
        this.extractPersonnesDatas();
    }

    public Personne createPersonneWithFileObject(JSONObject jsonObjectPerson) {
        Personne p = new Personne(jsonObjectPerson.get("prenom").toString(), 
                                          jsonObjectPerson.get("nom").toString(), 
                                          Double.parseDouble(jsonObjectPerson.get("poids").toString()),
                                          Double.parseDouble(jsonObjectPerson.get("taille").toString()),
                                          jsonObjectPerson.get("rue").toString(),
                                          jsonObjectPerson.get("ville").toString(),
                                          jsonObjectPerson.get("codePostal").toString());
        return p;
    }

    @Override
    protected void extractPersonnesDatas() {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader fileReader = new FileReader(this.personnesJsonPathFile);
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject =  (JSONObject) obj;
            JSONArray personnes = (JSONArray) jsonObject.get("personnes");
            for (Object p : personnes) {
                JSONObject jsonObjectPerson = (JSONObject) p;
                Personne person = this.createPersonneWithFileObject(jsonObjectPerson);
                this.personnes.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
