package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.Fabrica;
import edu.innova.logica.controladores.PlataformaControlador;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.logica.servicios.impl.PlataformaServicioImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PlataformaControladorImpl implements PlataformaControlador{
    
    private PlataformaServicio plataformaServicio = new PlataformaServicioImpl().getInstance();

    private static PlataformaControladorImpl instance;

    //Obtener la instancia
    public PlataformaControladorImpl getInstance() {
        if (null == instance) {
            instance = new PlataformaControladorImpl();
        }
        return instance;
    }
    
    @Override
    public void altaPlataforma(Plataforma plataforma) {

        Fabrica fabrica = new Fabrica();
        try {
            // valido que los datos de entrada sean validos
            validarNuevaPlataforma(plataforma);
            // inserto en la db
            fabrica.getPlataformaServicioImpl().altaPlataforma(plataforma);
            
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        } catch (SQLException ex) {
            Logger.getLogger(PlataformaControladorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public List<Plataforma> getTodasLasPlataformas() {
        return plataformaServicio.getTodasLasPlataformas();
    }

    private void validarNuevaPlataforma(Plataforma plataforma) {
        /*if (plataforma.getNombre() == null) {
            throw new InnovaModelException("La plataforma es inválida");
        }*/
        
        HelperStrings.stringNoVacio(plataforma.getNombre(), "nombre");
              
    }  
}
    
    
  
