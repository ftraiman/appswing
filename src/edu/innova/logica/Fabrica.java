/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.logica;

import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.controladores.impl.UsuarioControladorImpl;
import edu.innova.logica.servicios.ArtistaServicio;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.impl.EspectadorServicioImpl;
import edu.innova.logica.servicios.EspectadorServicio;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.logica.servicios.impl.ArtistaServicioImpl;
import edu.innova.logica.servicios.impl.EspectaculoServicioImpl;
import edu.innova.logica.servicios.impl.PlataformaServicioImpl;

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
    public EspectadorServicio getEspectadorServicioImpl() {
        EspectadorServicio cont = new EspectadorServicioImpl();
        return cont;
    }

    //Obtener instancia de UsuarioControladorImpl
    public UsuarioControlador getUsuarioControladorImpl() {
        UsuarioControlador cont = new UsuarioControladorImpl();
        return cont;
    }

    public ArtistaServicio getArtistaServicioImpl() {
        ArtistaServicio cont = new ArtistaServicioImpl();
        return cont;
    }
    
    public PlataformaServicio getPlataformaServicioImpl()
    {
        PlataformaServicio cont = new PlataformaServicioImpl();
        return cont;
    }
     
     public EspectaculoServicio getEspectaculoServicioImpl()
    {
        EspectaculoServicio cont = new EspectaculoServicioImpl();
        return cont;
    }

     public UsuarioControlador getUsuarioControlador() {
        return new UsuarioControladorImpl();
    }
}
