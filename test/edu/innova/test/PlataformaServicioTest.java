/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.test;

import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.logica.servicios.impl.PlataformaServicioImpl;
import edu.innova.logica.servicios.impl.UsuarioServicioImpl;
import java.sql.SQLException;

/**
 *
 * @author federico
 */
public class PlataformaServicioTest {

    public static void main(String[] args) throws SQLException {
        PlataformaServicio plataformaServicio = new PlataformaServicioImpl().getInstance();
        
        // Alta Plataforma
        plataformaServicio.altaPlataforma(new Plataforma(null, "Facebook", "Feisbuk", "www.facebook.com"));

    }

}
