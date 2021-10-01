package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.controladores.EspectaculoControlador;
import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.impl.EspectaculoServicioImpl;
import java.math.BigDecimal;
import java.sql.SQLException;
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
            } else {
                JOptionPane.showMessageDialog(null, "No se Agrego el Espectaculo");
            }
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    @Override
    public void altaCategoria(String Nombre) {
        try {
            //Valido que los datos de entrada
            //validarNuevoEspectaculo(idArtista, idPlataforma, espectaculo);

            int i = JOptionPane.showConfirmDialog(null, "¿Desea Registrar esta Categoria?", "Confirmar Alta Categoria", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                // espectaculoServicio.altaEspectaculo(idArtista, idPlataforma, espectaculo);
                espectaculoServicio.altaCategoria(Nombre);
                JOptionPane.showMessageDialog(null, "Se agrego correctamente La Categoria");
            } else {
                JOptionPane.showMessageDialog(null, "No se Agrego La categoria");
            }
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Espectaculo> getEspectaculosPorIdPlataforma(Long idPlataforma) {
        return espectaculoServicio.getTodosLosEspectaculosPorPlataforma(idPlataforma);
    }

    @Override
    public List<Espectaculo> getTodosLosEspectaculos() throws SQLException {
        return espectaculoServicio.getTodosLosEspectaculos();
    }

    private void validarNuevoEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo) {

        HelperStrings.stringNoVacio(espectaculo.getNombre(), "nombre");
        HelperStrings.stringNoVacio(espectaculo.getDescripcion(), "descripcion");
        HelperStrings.stringNoVacio(espectaculo.getUrl(), "url");
        //HelperStrings.urlValidator(espectaculo.getUrl());

        //Verificar que el costo no este vacio o menor a 0
        if (null == espectaculo.getCosto() || espectaculo.getCosto().compareTo(BigDecimal.ZERO) < 0) {
            throw new InnovaModelException("El Costo es inválido!");
        }

        //Verificar que haya seleccionado un artista
        if (null == idArtista) {
            throw new InnovaModelException("No se Selecciono un Artista!");
        }

        //Verificar que haya seleccionado una plataforma
        if (null == idPlataforma) {
            throw new InnovaModelException("No se Selecciono una Plataforma!");
        }
    }

    @Override
    public List<Categoria> getTodasLasCategorias() throws SQLException {
        return espectaculoServicio.getTodasLasCategorias();
    }

    @Override
    public List<Espectaculo> getTodosLosEspectaculosIngresados() throws SQLException {
        return espectaculoServicio.getTodosLosEspectaculosIngresados();
    }

    @Override
    public void aceptarEspectaculo(Long id) throws SQLException {
        try {
            int i = JOptionPane.showConfirmDialog(null, "Desea Aceptar este Espectaculo??", "Aceptar Espectaculo", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) { //Si confirma el alta
                espectaculoServicio.aceptarEspectaculo(id);
                JOptionPane.showMessageDialog(null, "Espectaculo Aceptado");
            } else { //Si no agrega muestra
                espectaculoServicio.rechazarEspectaculo(id);
                JOptionPane.showMessageDialog(null, "Espectaculo Rechazado");
            }

        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Categoria> getCategoriaPorIdEspectaculo(Long idEspectaculo) throws SQLException {
        return espectaculoServicio.getCategoriaPorIdEspectaculo(idEspectaculo);
    }

}
