package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Funcion;
import java.sql.SQLException;
import java.util.List;

public interface FuncionServicio {
    
    void altaFuncion(Long idEspectaculo, Funcion funcion);
    
    Funcion getFuncionPorId(Long idFuncion) throws SQLException;
    
    List<Funcion> getTodosLasFunciones() throws SQLException;
    
    List<Funcion> getTodosLasFuncionesPorIdEspectaculo(Long idEspectaculo) throws SQLException;
    
    void agregarArtistaInvitadoALaFuncion(Long idFuncion, List<Long> idUsuarios) throws SQLException;    
}
