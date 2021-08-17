package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Plataforma;
import java.sql.SQLException;
import java.util.List;

public interface PlataformaServicio {
    
    void altaPlataforma(Plataforma plataforma) throws SQLException;
    
    Plataforma getPlataformaPorId(Long idPlataforma) throws SQLException;
    
    List<Plataforma> getTodasLasPlataformas() throws SQLException;

    public void altaPlataforma(String nombre, String descripcion, String url);
    
}
