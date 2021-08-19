package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectaculo;
import java.sql.SQLException;
import java.util.List;

public interface EspectaculoServicio {

    void altaEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo);

    List<Espectaculo> getTodosLosEspectaculos() throws SQLException;
    
    public Espectaculo getEspectaculoPorId(Long idEspectaculo) throws SQLException;
    
    List<Espectaculo> getTodosLosEspectaculosPorPlataforma(Long idPlataforma);
    
    public Espectaculo getEspectaculoPorIdA(Long idArtista) throws SQLException ;

}
