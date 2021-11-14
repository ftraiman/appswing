package edu.innova.logica.controladores;

import edu.innova.logica.controladores.impl.FuncionControladorImpl;
import edu.innova.logica.dtos.CanjeTresPorUnoDTO;
import edu.innova.logica.dtos.FuncionDTO;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Funcion;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface FuncionControlador { //Interfaz de Funcion

    FuncionControladorImpl getInstance(); //Obtener la Instancia del Controlador

    void altaFuncion(Funcion funcion, Espectaculo espectaculo);

    void altaEspectadorAFuncion(Funcion funcion, Espectador espectador, Date fechaRegistroEspectaculo, BigDecimal costo);

    List<Funcion> getFuncionesPorIdEspectador(Espectador espectador);

    void canjearFunciones(Espectador espectadorSeleccionado, Funcion funcionSeleccionada, Set<Funcion> funcionesParaCanjear);
    
    public List<FuncionDTO> getFuncionesPorIdEspectaculoDTO(Long idEspectaculo) throws SQLException;
    
    void altaFuncionDTO(FuncionDTO funcion);
    
    FuncionDTO getFuncionDTOPorId(Long idFuncion);

    List<UsuarioDTO> getArtistasInvitadosAFuncionDTO(Long idFuncion) throws SQLException;
    
    Boolean getUsuarioRegistradoEnFuncion(Long idFuncion, Long idUsuario); 
    
    Boolean isFuncionCompleta(Long idFuncion);
    
    void altaEspectadorAFuncionDto(Long idFuncion , Long idUsuario, Date fechaRegistroEspectaculo, BigDecimal costo);
    
    List<FuncionDTO> getFuncionesDeUsuarioParaCanjear(Long idUsuario);
    
    void canjearFunciones(CanjeTresPorUnoDTO canje);
    
    void altaFuncionFavorita(Long idFuncion, Long idUsuario);
    
    void bajaFuncionFavorita(Long idFuncion, Long idUsuario);
    
    List<FuncionDTO> getFuncionFavoritasesDeUsuario(Long idUsuario);
    
}
