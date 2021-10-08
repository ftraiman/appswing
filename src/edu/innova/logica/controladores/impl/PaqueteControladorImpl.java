package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperStrings;
import java.math.BigDecimal;

import edu.innova.logica.controladores.PaqueteControlador;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Paquete;
import edu.innova.logica.servicios.PaqueteServicio;
import edu.innova.logica.servicios.impl.PaqueteServicioImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PaqueteControladorImpl implements PaqueteControlador {

    private final PaqueteServicio paqueteServicio = new PaqueteServicioImpl().getInstance();

    private static PaqueteControladorImpl instance;

    public PaqueteControladorImpl getInstance() {
        if (null == instance) {
            instance = new PaqueteControladorImpl();
        }
        return instance;
    }

    @Override
    public void altaPaquete(Paquete paquete) {
        try {
            validarNuevoPaquete(paquete);
            paqueteServicio.altaPaquete(paquete);

        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    private void validarNuevoPaquete(Paquete paquete) {

        HelperStrings.stringNoVacio(paquete.getNombre(), "nombre");
        HelperStrings.stringNoVacio(paquete.getNombre(), "descripcion");
        HelperStrings.stringNoVacio(paquete.getNombre(), "descuento");

        //Verifica que el descuento sea de 0 a 90
        if (paquete.getDescuento().compareTo(BigDecimal.ZERO) < 0 || paquete.getDescuento().compareTo(BigDecimal.valueOf(90)) > 0) {
            throw new IllegalArgumentException("Descuento inválido, el descuento debe ser de 0 a 90");
        }

        //Verifica que la Fecha Fin no sea mayor a Fecha Inicio
        if (paquete.getFechaFin().compareTo(paquete.getFechaInicio()) < 0) {
            throw new InnovaModelException("La fecha de inicio es posterior a la fecha de fin");
        }
    }

    @Override
    public List<Espectaculo> getEspectaculoNOPaquete(Long idPlataforma, Long idPaquete) {
        if (idPlataforma != null && idPaquete != null) {
            return paqueteServicio.getEspectaculosNOPaquete(idPaquete, idPlataforma);

        } else {
            return new ArrayList<Espectaculo>();
        }

    }

    //Retorna una lista de todos los Paquetes
    @Override
    public List<Paquete> getTodosLosPaquetes() throws SQLException {
        try {
            return paqueteServicio.getTodosLosPaquetes();
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    //======================== ALTA DE PAQUETE-ESPECTACULO ===================//
    @Override
    public void altaPaqueteEspectaculo(Long IdPaquete, Long IDEspectaculos) {
        try {
            paqueteServicio.agregarEspectaculoAlPaquete(IDEspectaculos, IdPaquete);

        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }
    //======================== ALTA DE PAQUETE-ESPECTACULO ===================//

    /* @Override
    public List<Espectaculo> getEspectaculoNOPaquete(Plataforma plataformas, Paquete paquetes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
    @Override
    public List<Paquete> getPaquetePorIdEspectaculo(Long id) throws SQLException {
        return paqueteServicio.getPaquetePorIdEspectaculo(id);
    }
}
