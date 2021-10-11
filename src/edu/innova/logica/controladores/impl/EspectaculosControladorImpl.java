package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.controladores.EspectaculoControlador;
import edu.innova.logica.dtos.EspectaculoDTO;
import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.impl.EspectaculoServicioImpl;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class EspectaculosControladorImpl implements EspectaculoControlador {

    private final EspectaculoServicio espectaculoServicio = new EspectaculoServicioImpl().getInstance();

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
            espectaculoServicio.altaEspectaculo(idArtista, idPlataforma, espectaculo);

        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    //============================= ALTA CATEGORIA ===========================//
    @Override
    public void altaCategoria(Categoria cat) {
        try {
            espectaculoServicio.altaCategoria(cat.getNombre());
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }
    //============================= ALTA CATEGORIA ===========================//

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
            espectaculoServicio.aceptarEspectaculo(id);
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public void rechazarEspectaculo(Long id) throws SQLException {
        try {
            espectaculoServicio.rechazarEspectaculo(id);
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Categoria> getCategoriaPorIdEspectaculo(Long idEspectaculo) throws SQLException {
        return espectaculoServicio.getCategoriaPorIdEspectaculo(idEspectaculo);
    }

    //====================== ALTA ESPECTACULO DTO ============================//
    @Override
    public void altaEspectaculoDTO(EspectaculoDTO espectaculo) {
        Long idArtista = espectaculo.getArtista().getId();
        Long idPlataforma = espectaculo.getPlataforma().getId();
        Espectaculo espc = new Espectaculo(espectaculo.getNombre(), espectaculo.getDescripcion(), espectaculo.getDuracion(), espectaculo.getEspectadoresMinimos(), espectaculo.getEspectadoresMaximos(), espectaculo.getUrl(), espectaculo.getCosto(), espectaculo.getFechaRegistro(), espectaculo.getIdCategoria(), espectaculo.getEstado(), espectaculo.getImagen());

        validarNuevoEspectaculo(idArtista, idPlataforma, espc);

        altaEspectaculo(idArtista, idPlataforma, espc);
    }
    //====================== ALTA ESPECTACULO DTO ============================//

    @Override
    public EspectaculoDTO getEspectaculoPorIdDTO(Long idEspectaculo) throws SQLException{
        return espectaculoServicio.getEspectaculoPorIdDTO(idEspectaculo);
    }

    @Override
    public List<EspectaculoDTO> getTodosLosEspectaculosDTO() throws SQLException {
        return espectaculoServicio.getTodosLosEspectaculosDTO();
    }

    @Override
    public List<EspectaculoDTO> getTodosLosEspectaculosPorArtistaDTO(Long idArtista) throws SQLException {
        return espectaculoServicio.getTodosLosEspectaculosPorArtistaDTO(idArtista);
    }

}
