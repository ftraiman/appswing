package edu.innova.logica.servicios;

import edu.innova.logica.dtos.CanjeTresPorUnoDTO;

public interface CanjeServicio {
    
    void altaCanjeTresPorUno(CanjeTresPorUnoDTO canje);
    
    void altaEspectaculoPaqueteUtilizado(Long idUsuario,Long idPaquete, Long idEspectaculo);
}
