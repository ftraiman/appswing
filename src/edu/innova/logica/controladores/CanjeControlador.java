package edu.innova.logica.controladores;

import edu.innova.logica.dtos.CanjeTresPorUnoDTO;

public interface CanjeControlador {

    void altaCanjeTresPorUno(CanjeTresPorUnoDTO canje);
    
    void altaEspectaculoPaqueteUtilizado(Long idUsuario,Long idPaquete, Long idEspectaculo);
}
