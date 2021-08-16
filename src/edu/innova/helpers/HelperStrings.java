/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.helpers;

import edu.innova.exceptions.InnovaModelException;

/**
 *
 * @author federico
 */
public class HelperStrings {

    public static boolean stringNoVacio(String str, String nombreParametro) {
        if(null !=str && str.trim().length() > 0) {
            return true;
        }
        throw new InnovaModelException(String.format("El parametro [%s] es vacío o nulo", nombreParametro));
    }
}
