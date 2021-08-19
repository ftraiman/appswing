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
            // valido que los datos de entrada sean validos
            validarNuevoEspectaculo(idArtista, idPlataforma, espectaculo);
            // inserto en la db
            espectaculoServicio.altaEspectaculo(idArtista, idPlataforma, espectaculo);

        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Espectaculo> getEspectaculosPorIdPlataforma(Long idPlataforma) {
        return espectaculoServicio.getTodosLosEspectaculosPorPlataforma(idPlataforma);
    }

    private void validarNuevoEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo) {
        if (idArtista == null) {
            throw new InnovaModelException("El Artista es inválido");
        }
        if (idPlataforma == null) {
            throw new InnovaModelException("La plataforma es inválida");
        }

        HelperStrings.stringNoVacio(espectaculo.getNombre(), "nombre");

        if (null == espectaculo.getCosto() || espectaculo.getCosto().compareTo(BigDecimal.ZERO) < 0) {
            throw new InnovaModelException("El costo es inválido");
        }

    }
}
