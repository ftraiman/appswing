package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Funcion;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface FuncionServicio {
    
    void altaFuncion(Long idEspectaculo, Funcion funcion);
    
    Funcion getFuncionPorId(Long idFuncion) throws SQLException;
    
    List<Funcion> getTodosLasFunciones() throws SQLException;
    
    List<Funcion> getTodosLasFuncionesPorIdEspectaculo(Long idEspectaculo) throws SQLException;
    
    void agregarArtistaInvitadoALaFuncion(Long idFuncion, List<Long> idUsuarios) throws SQLException;   
    
    void altaEspectadorAFuncion(Funcion funcion, Espectador espectador, Date fechaRegistroEspectaculo, BigDecimal costo);
    
    List<Funcion> getFuncionesPorIdEspectador(Espectador espectador);
}
