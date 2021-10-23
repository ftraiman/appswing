package edu.innova.logica.controladores;

import edu.innova.logica.dtos.PaqueteDTO;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Paquete;
import java.sql.SQLException;
import java.util.List;

public interface PaqueteControlador {

    Long altaPaquete(Paquete paquete);

    void altaPaqueteEspectaculo(Long idPaquete, Long idEspectaculo);

    //List<Espectaculo> getEspectaculoNOPaquete(Plataforma plataformas,Paquete paquetes);
    List<Paquete> getTodosLosPaquetes() throws SQLException;

    List<Espectaculo> getEspectaculoNOPaquete(Long idPlataforma, Long idPaquete);

    List<Paquete> getPaquetePorIdEspectaculo(Long id);

    void altaPaqueteDTO(PaqueteDTO paquete, Long idArtista);

    void altaPaqueteDTOEspectaculo(Long idPaquete, Long iDEspectaculo);

    List<PaqueteDTO> getPaquetesDTOPorIdArtista(Long idArtista);

    PaqueteDTO getPaqueteDTOporId(Long idPaquete);
    
    List<PaqueteDTO> getPaqueteDTOPorIdEspectaculo(Long idEspectaculo);
    
    List<PaqueteDTO> getTodosLosPaquetesDTO();
    
    void altaUsuarioEnPaquete(Long idUsuario, Long idPaquete);

    List<PaqueteDTO> getPaquetesContratadosPorIdUsuario(Long idUsuario);
    
    void altaPaqueteArtista(Long idPaquete, Long idArtista);
    
    List<PaqueteDTO> getPaquetesConLaFuncion(Long idUsuario, Long idFuncion);
    
}
