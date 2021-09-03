/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.exceptions;

/**
 *
 * @author federico
 */
public class BaseDeDatosException extends RuntimeException {

    public BaseDeDatosException(String message) {
        super(message);
    }

    public BaseDeDatosException(String message, Throwable cause) {
        super(message, cause);
    }
     
}
