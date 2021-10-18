package edu.innova.logica.controladores;

import edu.innova.logica.dtos.PaqueteDTO;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Paquete;
import java.sql.SQLException;
import java.util.List;

public interface PaqueteControlador {
    
    void altaPaquete(Paquete paquete);

    void altaPaqueteEspectaculo(Long IdPaquete, Long IDEspectaculos);
    
    //List<Espectaculo> getEspectaculoNOPaquete(Plataforma plataformas,Paquete paquetes);

    public List<Paquete> getTodosLosPaquetes() throws SQLException ;

    public List<Espectaculo> getEspectaculoNOPaquete(Long idPlataforma, Long idPaquete);
    
    public List<Paquete> getPaquetePorIdEspectaculo(Long id) throws SQLException;
    
     public void altaPaqueteDTO(PaqueteDTO paquete);
     
     public void altaPaqueteDTOEspectaculo(Long IdPaquete, Long IDEspectaculos);
     
     List<PaqueteDTO> getPaquetesDTOPorIdArtista(Long idArtista);
    
}
