package edu.innova.logica;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class Hash {
    
    //Metodo que transforma neustra password en una hash
    //Recibe como parametros los Bytes de la cadena y el algoritmo a utilizar
    public static String getHash(byte[] inputByte, String algoritmo) {
        //Creamos la cadena que tendra la hash
        String hashValue = "";
        try {
            //Se crea una "messageDigest" con el algoridmo pasado por parametro
            MessageDigest messageDigest = MessageDigest.getInstance(algoritmo);
            //Despues se actualizan los Bytes de la contraseña con el algoritmo
            messageDigest.update(inputByte);
            //Luego creamos una variable de tipo byte que tendra los bytes de la hash
            byte[] digestedBytes = messageDigest.digest();
            //Para finalmente le cargamos los bytes convertidos a hexbinary en la cadena a retornar en minuscula
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();

        } catch (Exception e) {
        }
        return hashValue;//Retornar la cadena con la hash creada
    }

}
