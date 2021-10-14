package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Paquete;
import java.sql.SQLException;
import java.util.List;

public interface PaqueteServicio {
    
    void altaPaquete(Paquete paquete);
    
    void agregarEspectaculoAlPaquete(Long idEspectaculo, Long idPaquete);
    
    List<Paquete> getTodosLosPaquetes() throws SQLException;
    
    public List<Espectaculo> getEspectaculosNOPaquete(Long idPaquete , Long idPlataforma);
     
    public List<Paquete> getPaquetePorIdEspectaculo(Long id) throws SQLException ;
        
}
