package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperStrings;
import java.math.BigDecimal;

import edu.innova.logica.controladores.PaqueteControlador;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Paquete;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.PaqueteServicio;
import edu.innova.logica.servicios.impl.PaqueteServicioImpl;
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
            
            int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Paquete??", "Confirmar Paquete", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) { //Si confirma el alta
                    paqueteServicio.altaPaquete(paquete);
                    JOptionPane.showMessageDialog(null, "El Paquete fue ingresado correctamente");
                } 
                else { //Si no agrega muestra
                    JOptionPane.showMessageDialog(null, "No se Agrego el Paquete");
                }
                
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
    public List<Espectaculo> getEspectaculoNOPaquete(Plataforma plataformas, Paquete paquetes) {
        if (plataformas != null && paquetes != null) {
            return paqueteServicio.getEspectaculosNOPaquete(paquetes.getId(), plataformas.getId());

        } else {
            return new ArrayList<Espectaculo>();
        }

    }

    @Override
    public void altaPaqueteEspectaculo(Long IdPaquete, Long IDEspectaculos) {
        try {
            int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Espectaculo al Paquete??", "Confirmar Espectaculo al Paquete", JOptionPane.YES_NO_OPTION);
               if (i == JOptionPane.YES_OPTION) { //Si confirma el alta
               paqueteServicio.agregarEspectaculoAlPaquete(IDEspectaculos,IdPaquete);

                   JOptionPane.showMessageDialog(null, "El Espectaculo fue ingresado correctamente al Paquete");
               } 
               else { //Si no agrega muestra
                   JOptionPane.showMessageDialog(null, "No se Agrego el Espectaculo al Paquete");
               }
            
        } catch (BaseDeDatosException ex){
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

}
