package edu.innova.helpers;

import edu.innova.exceptions.InnovaModelException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            throw new IllegalArgumentException("Monto inválido, Ingrese un Descuento"); //To change body of generated methods, choose Tools | Templates.
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
    
     public static boolean ValidarEmail(String email){
        
        //Comprobamos el correo con Expresiones Regulares
        //Para verificar que sea un correo hay que verificar que este "@" y ".dominio"
        //Para ello se usa expresiones regulares para comparar cadenas de texto
        //y encontrar alguna similitud entre ambas cadenas
        
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher mat = patron.matcher(email);        
        
        if(mat.find()) { //Si el email es correcto
            return true;
        }
        throw new InnovaModelException(String.format("El parametro [%s] NO es un email!!!", email));
    }
}
