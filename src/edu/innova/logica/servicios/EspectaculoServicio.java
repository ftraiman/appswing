package edu.innova.logica.servicios;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.dtos.EspectaculoDTO;
import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.entidades.Espectaculo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface EspectaculoServicio {

    void altaEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo);

    List<Espectaculo> getTodosLosEspectaculos() throws SQLException;

    Espectaculo getEspectaculoPorId(Long idEspectaculo);

    List<Espectaculo> getTodosLosEspectaculosPorPlataforma(Long idPlataforma);

    public List<Espectaculo> getEspectaculosPorIdArtista(Long idArtista);

    public void altaCategoria(String nombre);

    public List<Categoria> getTodasLasCategorias();

    public List<Espectaculo> getTodosLosEspectaculosIngresados() throws SQLException;

    public void aceptarEspectaculo(Long id);

    public void rechazarEspectaculo(Long id);

    public List<Categoria> getCategoriaPorIdEspectaculo(Long idEspectaculo) throws SQLException;

    public EspectaculoDTO getEspectaculoPorIdDTO(Long idEspectaculo);
    
    public List<EspectaculoDTO> getTodosLosEspectaculosPorArtistaDTO(Long idArtista);

    public List<EspectaculoDTO> getTodosLosEspectaculosDTO() throws SQLException;
    
    public void altaEspectaculoDTO(EspectaculoDTO espectaculo);
    
    public List<EspectaculoDTO> buscarEspectaculosDTO(Long idPlataforma,Long idCategoria);
    
    List<EspectaculoDTO> getEspectaculosDTONoIncluidosEnPaquete(Long idArtista, Long idPaquete);
    
    public EspectaculoDTO getEspectaculoPorNombre(String nombre);

    public List<Espectaculo> getTodosLosEspectaculosAceptados();
    
    public List<Espectaculo> getTodosLosEspectaculosAceptadosPorNombre(String nombre);
    
    public void finalizarEspectaculo(Long id);
    
    void altaEspectaculoFavorito(Long idFuncion, Long idUsuario);
    
    void bajaEspectaculoFavorito(Long idFuncion, Long idUsuario);

    List<EspectaculoDTO> getEspectaculosFavoritosDeUsuario(Long idUsuario);
}
