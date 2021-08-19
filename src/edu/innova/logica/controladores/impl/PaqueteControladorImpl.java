package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import java.math.BigDecimal;

import edu.innova.logica.controladores.PaqueteControlador;
import edu.innova.logica.entidades.Paquete;
import edu.innova.logica.servicios.PaqueteServicio;
import edu.innova.logica.servicios.impl.PaqueteServicioImpl;

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
        if (paquete.getDescuento().compareTo(BigDecimal.ZERO) < 0 || paquete.getDescuento().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("Descuento inválido");
        }
        if(paquete.getFechaFin().compareTo(paquete.getFechaInicio()) < 0) {
            throw new InnovaModelException("La fecha de inicio es posterior a la fecha de fin");
        }
    }
}
