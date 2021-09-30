package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.entidades.Espectaculo;
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

}
