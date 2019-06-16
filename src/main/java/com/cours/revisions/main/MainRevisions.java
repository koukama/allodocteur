/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.main;

import com.cours.revisions.factory.SingletonFactory;
import com.cours.revisions.singletons.AbstractStatisticSingleton;
import com.cours.revisions.singletons.CsvStatisticSingleton;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class MainRevisions {

    private static final Log log = LogFactory.getLog(MainRevisions.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        AbstractStatisticSingleton mySingleton = SingletonFactory.getFactory(SingletonFactory.FactorySingletonType.CSV_SINGLETON_FACTORY);
        //CsvStatisticSingleton myCsv = CsvStatisticSingleton.getInstance();
        //myCsv.getMoyennePoids();
        System.out.println(mySingleton.getMoyennePoids() + "," 
                            + mySingleton.getEcartTypePoids() + ','
                            + mySingleton.getMoyenneTaille() + ','
                            + mySingleton.getEcartTypeTaille());
        
        AbstractStatisticSingleton mySingleton2 = SingletonFactory.getFactory(SingletonFactory.FactorySingletonType.JSON_SINGLETON_FACTORY);
        System.out.println(mySingleton2.getMoyennePoids() + "," 
                            + mySingleton2.getEcartTypePoids() + ','
                            + mySingleton2.getMoyenneTaille() + ','
                            + mySingleton2.getEcartTypeTaille());
    }
}
