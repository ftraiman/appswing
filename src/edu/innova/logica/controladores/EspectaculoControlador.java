package edu.innova.logica.controladores;

import edu.innova.logica.entidades.Espectaculo;
import java.util.List;

public interface EspectaculoControlador {
    
     void altaEspectaculo(Long idArtista, Long idPlataforma,Espectaculo espectaculo);
     
     List<Espectaculo> getEspectaculosPorIdPlataforma(Long idPlataforma);
    
}
