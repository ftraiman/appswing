package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.controladores.EspectaculoControlador;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.impl.EspectaculoServicioImpl;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;

public class EspectaculosControladorImpl implements EspectaculoControlador {

    private EspectaculoServicio espectaculoServicio = new EspectaculoServicioImpl().getInstance();

    private static EspectaculosControladorImpl instance;

    //Obtener la instancia
    public EspectaculosControladorImpl getInstance() {
        if (null == instance) {
            instance = new EspectaculosControladorImpl();
        }
        return instance;
    }

    @Override
    public void altaEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo) {
        try {
            //Valido que los datos de entrada
            validarNuevoEspectaculo(idArtista, idPlataforma, espectaculo);
            
            int i = JOptionPane.showConfirmDialog(null, "¿Desea Registrar este Espectaculo?", "Confirmar Alta Espectaculo", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                espectaculoServicio.altaEspectaculo(idArtista, idPlataforma, espectaculo);
                JOptionPane.showMessageDialog(null, "Se agrego correctamente el Espectáculo");
            } 
            else {
                JOptionPane.showMessageDialog(null, "No se Agrego el Espectaculo");
            }
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Espectaculo> getEspectaculosPorIdPlataforma(Long idPlataforma) {
        return espectaculoServicio.getTodosLosEspectaculosPorPlataforma(idPlataforma);
    }

    private void validarNuevoEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo) {

        HelperStrings.stringNoVacio(espectaculo.getNombre(), "nombre");
        HelperStrings.stringNoVacio(espectaculo.getDescripcion(), "descripcion");
        HelperStrings.stringNoVacio(espectaculo.getUrl(), "url");
        HelperStrings.urlValidator(espectaculo.getUrl());
          

        //Verificar que el costo no este vacio o menor a 0
        if (null == espectaculo.getCosto() || espectaculo.getCosto().compareTo(BigDecimal.ZERO) < 0) {
            throw new InnovaModelException("El Costo es inválido!");
        }

    }
}
