package edu.innova.logica.controladores;

import edu.innova.logica.dtos.CategoriaDTO;
import edu.innova.logica.dtos.EspectaculoDTO;
import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.entidades.Espectaculo;
import java.sql.SQLException;
import java.util.List;

public interface EspectaculoControlador {

    void altaEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo);

    List<Espectaculo> getEspectaculosPorIdPlataforma(Long idPlataforma);

    public List<Espectaculo> getTodosLosEspectaculos() throws SQLException;

    public void altaCategoria(Categoria cat);

    public List<Categoria> getTodasLasCategorias() throws SQLException;

    public List<Espectaculo> getTodosLosEspectaculosIngresados() throws SQLException;

    public void aceptarEspectaculo(Long id) throws SQLException;

    public void rechazarEspectaculo(Long id) throws SQLException;

    public List<Categoria> getCategoriaPorIdEspectaculo(Long idEspectaculo) throws SQLException;
    
    public void altaEspectaculoDTO(EspectaculoDTO espectaculo);
    
    public EspectaculoDTO getEspectaculoPorIdDTO(Long idEspectaculo);
    
    public List<EspectaculoDTO> getTodosLosEspectaculosDTO() throws SQLException;
    
    public List<EspectaculoDTO> getTodosLosEspectaculosPorArtistaDTO(Long idArtista);
    
    List<CategoriaDTO> getTodasLasCategoriasDTO();

    public void AltaEspectaculoDTO(EspectaculoDTO espectaculo);
    
    public List<Espectaculo> buscarEspectaculosDTO(Long idPlataforma,Long idCategoria);
}
