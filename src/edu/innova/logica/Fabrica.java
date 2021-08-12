/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.logica;

import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.controladores.impl.UsuarioControladorImpl;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.logica.servicios.impl.UsuarioServicioImpl;

/**
 *
 * @author henry
 */
public class Fabrica {
    private static Fabrica instancia;
    
    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }
    //Obtener instancia de UsuarioServicioImpl
    public UsuarioServicio getUsuarioServicioImpl() 
    {
        UsuarioServicio cont = new UsuarioServicioImpl();
        return cont;
    }
    //Obtener instancia de UsuarioControladorImpl
    public UsuarioControlador getUsuarioControladorImpl() 
    {
        UsuarioControlador cont = new UsuarioControladorImpl();
        return cont;
    }
    
    
}
