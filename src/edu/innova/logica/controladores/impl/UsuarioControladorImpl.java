/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.logica.controladores.impl;

import edu.innova.logica.Fabrica;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.entidades.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioControladorImpl implements UsuarioControlador {
    
    private static UsuarioControladorImpl instance;
    
    public UsuarioControladorImpl() {}//Constructor por defecto

    //Obtener la instancia
    public UsuarioControladorImpl getInstance() {
        if (null == instance) {
            instance = new UsuarioControladorImpl();
        }
        return instance;
    }

    //=========================== Alta de usuario ============================//
    @Override
    public void altaUsuario(Usuario usuario) {
        Fabrica fabrica = new Fabrica();
        try {        
            fabrica.getUsuarioServicioImpl().altaUsuario(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControladorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //=========================== Alta de usuario ============================//
}
