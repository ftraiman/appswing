package edu.innova.helpers;

import edu.innova.exceptions.InnovaModelException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

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
    
    public static boolean urlValidator(String url){
        //Abre la url ingresada y si no es una url entra en el catch
         try {
            (new URL(url)).openStream().close();
            return true;
        } 
        catch(IOException e) {
              throw new InnovaModelException(String.format("El parametro [%s] no es un Enlace", url));
            // nada muy importante
        }
        //return false; //Esto porque pide la mierda del IDE
    }
}
