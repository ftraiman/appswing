package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Paquete;
import java.util.List;

public interface PaqueteServicio {
    
    void altaPaquete(Paquete paquete);
    
    void agregarEspectaculoAlPaquete(Long idEspectaculo, Long idPaquete);
    
    List<Paquete> getTodosLosPaquetes();
    
    List<Espectaculo> getEspectaculosNOPaquete(Long idPaquete , Long idPlataforma);
     
    List<Paquete> getPaquetePorIdEspectaculo(Long id);
    
    List<Paquete> getPaquetesPorIdArtista(Long idArtista);
    
    Paquete getPaquetesPorId(Long idPaquete);
    
    void altaUsuarioEnPaquete(Long idUsuario, Long idPaquete);
    
    List<Paquete> getPaquetesContratadosPorIdUsuario(Long idUsuario);
}
