package edu.innova.logica.servicios.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import edu.innova.logica.servicios.UsuarioServicio;
import java.sql.Statement;

public class FuncionServicioImpl implements FuncionServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String altaFunciones = "INSERT INTO funciones (idEspectaculo, nombre, fechaInicio, fechaRegistro) VALUES (?, ?, ?, ?)";
    private final String todosLasFunciones = "SELECT * FROM funciones";
    private final String funcionesPorIdEspectaculo = "SELECT * FROM funciones WHERE idEspectaculo = ?";
    private final String funcionPorId = "SELECT * FROM funciones WHERE id = ?";
    private final String agregarArtistaALaFuncion = "INSERT INTO artistas_funciones (idFuncion, idUsuario) VALUES (?, ?)";
    private final String artistaInvitadosEnFuncion = "SELECT * FROM artistas_funciones WHERE idFuncion = ?";
    private final String agregarArtistasFunciones = "INSERT INTO artistas_funciones(idFuncion, idUsuario) VALUES (?, ?)";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//

    //INSTANCIA DE LA CLASE
    private static FuncionServicioImpl servicio;

    //OBTENER LA CONEXION A LA BASE DE DATOS
    private ConexionDB conexion = new ConexionDB();

    private UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();
//    private EspectaculoServicio espectaculoServicio = new EspectaculoServicioImpl().getInstance();

    public FuncionServicioImpl() {//DEFAULT
    }

    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public FuncionServicioImpl getInstance() {
        if (null == servicio) {
            servicio = new FuncionServicioImpl();
        }
        return servicio;
    }

    //==================== AlTA DE FUNCION =======================//
    @Override
    public void altaFuncion(Long idEspectaculo, Funcion funcion) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(altaFunciones, Statement.RETURN_GENERATED_KEYS);
            sentencia.setLong(1, idEspectaculo);
            sentencia.setString(2, funcion.getNombre());
            sentencia.setDate(3, new java.sql.Date(funcion.getFechaInicio().getTime()));
            sentencia.setDate(4, new java.sql.Date(funcion.getFechaRegistro().getTime()));
            sentencia.executeUpdate();
            
            Integer newId = null;
            ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.next()) {
                newId = rs.getInt(1);
            }
            for (Artista artista : funcion.getArtistasInvitados()) {
                sentencia = conexion.getConexion().prepareStatement(agregarArtistasFunciones);
                sentencia.setLong(1, Long.valueOf(newId));
                sentencia.setLong(2, artista.getId());
                sentencia.executeUpdate();
            }
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe una funcion con el nombre [%s]", funcion.getNombre()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }
    //==================== AlTA DE FUNCION =======================//

    //==================== OBTENER FUNCION POR ID ============//
    @Override
    public Funcion getFuncionPorId(Long idFuncion) throws SQLException {
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(funcionPorId);
        sentencia.setLong(1, idFuncion);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            return funcionMapper(rs);
        }
        throw new NoSuchElementException(String.format("Funcion con id %s no encontrado", idFuncion));
    }
    //==================== OBTENER FUNCION POR ID ============//

    //==================== OBTENER TODOS LAS FUNCIONES=========//
    @Override
    public List<Funcion> getTodosLasFunciones() throws SQLException {
        List<Funcion> espectaculos = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLasFunciones);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            espectaculos.add(funcionMapper(rs));
        }
        return espectaculos;
    }
    //==================== OBTENER TODOS LAS FUNCIONES=========//

    //==================== OBTENER TODOS LAS FUNCIONES POR ID ESPECTACULO=========//
    @Override
    public List<Funcion> getTodosLasFuncionesPorIdEspectaculo(Long idEspectaculo) throws SQLException {
        List<Funcion> espectaculos = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(funcionesPorIdEspectaculo);
        sentencia.setLong(1, idEspectaculo);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            espectaculos.add(funcionMapper(rs));
        }
        return espectaculos;
    }
    //==================== OBTENER TODOS LAS FUNCIONES POR ID ESPECTACULO=========//

    public void agregarArtistaInvitadoALaFuncion(Long idFuncion, List<Long> idUsuarios) throws SQLException {
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(agregarArtistaALaFuncion);
        for (Long idUsuario : idUsuarios) {
            sentencia.setLong(1, idFuncion);
            sentencia.setLong(2, idUsuario);
            sentencia.executeUpdate();
        }
    }

    private List<Artista> getArtistasInvitadosAFuncion(Long idFuncion) throws SQLException {
        List<Artista> artistasInvitados = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(artistaInvitadosEnFuncion);
        sentencia.setLong(1, idFuncion);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            Artista artistaInvitado = (Artista) usuarioServicio.getUsuarioPorId(rs.getLong("idUsuario"));
            artistasInvitados.add(artistaInvitado);
        }
        return artistasInvitados;
    }

    private Funcion funcionMapper(ResultSet rs) throws SQLException {

        Long idFuncion = rs.getLong("id");
        Long idEspectaculo = rs.getLong("idEspectaculo");
        Date fechaInicio = rs.getTimestamp("fechaInicio");
        Date fechaRegistro = rs.getTimestamp("fechaRegistro");

        List<Artista> artistasInvitados = getArtistasInvitadosAFuncion(idFuncion);

        return new Funcion(idFuncion, idEspectaculo, fechaInicio, fechaRegistro, artistasInvitados);
    }
}
