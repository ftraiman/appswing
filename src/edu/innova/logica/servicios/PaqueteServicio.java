package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Paquete;

public interface PaqueteServicio {
    
    void altaPaquete(Paquete paquete);
    
    void agregarEspectaculoAlPaquete(Long idEspectaculo, Long idPaquete);
        
}
