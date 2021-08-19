package edu.innova.logica;

import edu.innova.logica.controladores.EspectaculoControlador;
import edu.innova.logica.controladores.PaqueteControlador;
import edu.innova.logica.controladores.PlataformaControlador;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.controladores.impl.EspectaculosControladorImpl;
import edu.innova.logica.controladores.impl.PlataformaControladorImpl;
import edu.innova.logica.controladores.impl.PaqueteControladorImpl;
import edu.innova.logica.controladores.impl.UsuarioControladorImpl;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.PaqueteServicio;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.logica.servicios.impl.EspectaculoServicioImpl;
import edu.innova.logica.servicios.impl.PaqueteServicioImpl;
import edu.innova.logica.servicios.impl.PlataformaServicioImpl;

public class Fabrica {

    private static Fabrica instancia;

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    //Obtener instancia de UsuarioControladorImpl
    public UsuarioControlador getUsuarioControladorImpl() {
        UsuarioControlador cont = new UsuarioControladorImpl();
        return cont;
    }

    public PlataformaServicio getPlataformaServicioImpl() {
        PlataformaServicio cont = new PlataformaServicioImpl();
        return cont;
    }

    public PlataformaControlador getPlataformaControlador() {
        return new PlataformaControladorImpl();
    }

    public EspectaculoServicio getEspectaculoServicioImpl() {
        EspectaculoServicio cont = new EspectaculoServicioImpl();
        return cont;
    }

    public EspectaculoControlador getEspectaculoControlador() {
        return new EspectaculosControladorImpl();
    }

    public UsuarioControlador getUsuarioControlador() {
        return new UsuarioControladorImpl();
    }

    public PaqueteControlador getPaqueteControlador() {
        return new PaqueteControladorImpl().getInstance();
    }
    
    public PaqueteServicio getPaqueteServicioImpl() {
        return new PaqueteServicioImpl().getInstance();
    }
}
