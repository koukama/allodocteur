/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.factory;

import com.cours.revisions.singletons.AbstractStatisticSingleton;
import com.cours.revisions.singletons.CsvStatisticSingleton;
import com.cours.revisions.singletons.JsonStatisticSingleton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class SingletonFactory {

    public static String className = SingletonFactory.class.getName();
    private static final Log log = LogFactory.getLog(SingletonFactory.class);

    public enum FactorySingletonType {

        CSV_SINGLETON_FACTORY, XML_SINGLETON_FACTORY, JSON_SINGLETON_FACTORY
    }

    /**
     * @param type
     * @return AbstractStatisticSingleton
     */
    public static AbstractStatisticSingleton getFactory(FactorySingletonType type) {
        
        if (type == FactorySingletonType.CSV_SINGLETON_FACTORY) {
            return CsvStatisticSingleton.getInstance();
        }
        
        if (type == FactorySingletonType.JSON_SINGLETON_FACTORY) {
            return JsonStatisticSingleton.getInstance();
        }
        
        return null;
    }
}
