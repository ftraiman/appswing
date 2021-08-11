package edu.innova.logica;

import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.logica.servicios.impl.PlataformaServicioImpl;
import edu.innova.logica.servicios.impl.UsuarioServicioImpl;

/**
 *
 * @author henry
 */
public class Fabrica {
        
        private static Fabrica instance;
        UsuarioServicio usuarioServicio;
        PlataformaServicio plataformaServicio;
        
    public static Fabrica getInstance() {
        if (instance == null) {
            instance = new Fabrica();
        }
            return instance;
    }
        
    public UsuarioServicio getUsuarioServicioImpl() 
    {
        UsuarioServicio cont = new UsuarioServicioImpl();
        return cont;
    }
    
    public PlataformaServicio getPlataformaServicioImpl() 
    {
        PlataformaServicio cont = new PlataformaServicioImpl();
        return cont;
    }
}
