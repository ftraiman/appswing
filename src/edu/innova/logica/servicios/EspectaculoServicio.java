package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Espectaculo;
import java.sql.SQLException;
import java.util.List;

public interface EspectaculoServicio {

    void altaEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo) throws SQLException;

    List<Espectaculo> getTodosLosEspectaculos() throws SQLException;
    
    public Espectaculo getEspectaculoPorId(Long idEspectaculo) throws SQLException;

}
