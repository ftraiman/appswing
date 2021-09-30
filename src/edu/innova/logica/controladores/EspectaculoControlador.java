package edu.innova.logica.controladores;

import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.entidades.Espectaculo;
import java.sql.SQLException;
import java.util.List;

public interface EspectaculoControlador {

    void altaEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo);

    List<Espectaculo> getEspectaculosPorIdPlataforma(Long idPlataforma);

    public List<Espectaculo> getTodosLosEspectaculos() throws SQLException;

    public void altaCategoria(String Nombre);

    public List<Categoria> getTodasLasCategorias() throws SQLException;

    public List<Espectaculo> getTodosLosEspectaculosIngresados() throws SQLException;

    public void aceptarEspectaculo(Long id) throws SQLException;
    
}
