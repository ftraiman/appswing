package edu.innova.logica.servicios;

import edu.innova.logica.dtos.FuncionDTO;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Funcion;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface FuncionServicio {
    
    void altaFuncion(Long idEspectaculo, Funcion funcion);
    
    Funcion getFuncionPorId(Long idFuncion);
    
    List<Funcion> getTodosLasFunciones() throws SQLException;
    
    List<Funcion> getTodosLasFuncionesPorIdEspectaculo(Long idEspectaculo) throws SQLException;
    //Obtener todas las funciones de la base de datos de un usuario espesifico
    List<Funcion> getTodosLasFuncionesPorIdUsuario(Long IdUsuario) throws SQLException;
    
    void agregarArtistaInvitadoALaFuncion(Long idFuncion, List<Long> idUsuarios) throws SQLException;   
    
    void altaEspectadorAFuncion(Funcion funcion, Espectador espectador, Date fechaRegistroEspectaculo, BigDecimal costo);
    
    List<Funcion> getFuncionesPorIdEspectador(Espectador espectador);
    
    List<Funcion> getFuncionPorIdUsuario(Long idFuncion)  throws SQLException;

    public void eliminarFuncionesDelEspectador(ArrayList<Funcion> arrayList, Espectador espectador);

    public Integer getCantidadRegistrados(Long id);
    
    public List<FuncionDTO> getFuncionesPorIdEspectaculoDTO(Long idEspectaculo) throws SQLException;
    
    public void altaFuncionDTO(FuncionDTO funcion);
    
    public FuncionDTO getFuncionDTOPorId(Long idFuncion);
    
    public List<UsuarioDTO> getArtistasInvitadosAFuncionDTO(Long idFuncion) throws SQLException;
    
    Boolean getUsuarioRegistradoEnFuncion(Long idFuncion, Long idUsuario);

    public List<FuncionDTO> getFuncionesDeUsuarioParaCanjear(Long idUsuario);
}
