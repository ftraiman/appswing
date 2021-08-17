/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.helpers;

import edu.innova.exceptions.InnovaModelException;
import java.math.BigDecimal;

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
    
    public static Long getLongValue(String id) {
        try {
            return Long.valueOf(id);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("id"); //To change body of generated methods, choose Tools | Templates.
        }          
    }
    
    public static BigDecimal getBigDecimalValue(String valor) {
        try {
            return new BigDecimal(valor);
        } catch(Exception e) {
            throw new IllegalArgumentException("Monto inválido"); //To change body of generated methods, choose Tools | Templates.
        }          
    }
    
    public static Integer getIntValue(String valor, String nombreParametro) {
        try {
            return new Integer(valor);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Número inválido para el parametro [%s]", nombreParametro)); //To change body of generated methods, choose Tools | Templates.
        }          
    }
}
