package edu.innova.logica.servicios.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.dtos.FuncionDTO;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
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
import java.math.BigDecimal;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionServicioImpl implements FuncionServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String altaFunciones = "INSERT INTO funciones (idEspectaculo, nombre, fechaInicio, fechaRegistro,imagen,descripcionPremios,cantidadPremios) VALUES (?,?,?, ?, ?, ?, ?)";
    private final String todosLasFunciones = "SELECT * FROM funciones";
    private final String funcionesPorIdEspectaculo = "SELECT * FROM funciones WHERE idEspectaculo = ?";
    private final String funcionesPorIdUsuario = "SELECT * FROM funciones AS FF, espectadores_funciones AS EF WHERE FF.id = EF.idFuncion AND EF.idUsuario = ?";
    private final String funcionPorId = "SELECT * FROM funciones WHERE id = ?";
    private final String funcionPorIdUsuario = "SELECT * FROM funciones AS FF, espectadores_funciones AS EF WHERE FF.id = EF.idFuncion AND EF.idUsuario = ?;";
    private final String agregarArtistaALaFuncion = "INSERT INTO artistas_funciones (idFuncion, idUsuario) VALUES (?, ?)";
    private final String artistaInvitadosEnFuncion = "SELECT * FROM artistas_funciones WHERE idFuncion = ?";
    private final String agregarArtistasFunciones = "INSERT INTO artistas_funciones(idFuncion, idUsuario) VALUES (?, ?)";
    private final String agregarEspectadorAFuncion = "INSERT INTO espectadores_funciones (idFuncion, idUsuario, fechaRegistro, costo) VALUES (?, ?, ?, ?)";
    private final String todosLasFuncionesPorIdEspectador = "SELECT * FROM espectadores_funciones WHERE idUsuario = ?";
    private final String eliminarFuncionesDeEspectador = "DELETE FROM espectadores_funciones WHERE idUsuario = ? AND idFuncion = ?";
    private final String cantRegistradosParaFuncion = "SELECT COUNT(*) as cnt FROM espectadores_funciones WHERE idFuncion = ?";
    private final String cantFuncionesPorUsuario = "SELECT COUNT(*) as cnt FROM espectadores_funciones WHERE idFuncion = ? AND idUsuario = ?";
    private final String funcionesParaCanjear = "SELECT f.* FROM funciones f JOIN espectadores_funciones ef on f.id = ef.idFuncion WHERE idUsuario = ? AND ef.costo > 0";
    private final String sorteoRealizado = "UPDATE `funciones` SET `sorteo` = '1' WHERE `funciones`.`id` = ?";
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
            sentencia.setString(5, funcion.getImagen());
            sentencia.setString(6, funcion.getDescripcionPremios());
            sentencia.setInt(7,funcion.getCantidadPremios());
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
    public Funcion getFuncionPorId(Long idFuncion) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(funcionPorId);
            sentencia.setLong(1, idFuncion);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return funcionMapper(rs);
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
        throw new NoSuchElementException(String.format("Funcion con id %s no encontrado", idFuncion));
    }
    //==================== OBTENER FUNCION POR ID ============//

    //==================== OBTENER FUNCION POR ID DE USUSARIO ============//
    @Override
    public List<Funcion> getFuncionPorIdUsuario(Long idFuncion) throws SQLException {
        List<Funcion> funciones = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(funcionPorIdUsuario);
        sentencia.setLong(1, idFuncion);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            funciones.add(funcionMapper(rs));
        }
        return funciones;
    }
    //==================== OBTENER FUNCION POR ID DE USUARIO ============//

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
    public List<Funcion> getTodosLasFuncionesPorIdEspectaculo(Long idEspectaculo) {
        List<Funcion> funciones = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(funcionesPorIdEspectaculo);
            sentencia.setLong(1, idEspectaculo);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                funciones.add(funcionMapper(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funciones;
    }
    //==================== OBTENER TODOS LAS FUNCIONES POR ID ESPECTACULO=========//

    //==================== OBTENER TODOS LAS FUNCIONES POR ID USUARIO =========//
    @Override
    public List<Funcion> getTodosLasFuncionesPorIdUsuario(Long IdUsuario) throws SQLException {
        List<Funcion> funciones = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(funcionesPorIdUsuario);
        sentencia.setLong(1, IdUsuario);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            funciones.add(funcionMapper(rs));
        }
        return funciones;
    }
    //==================== OBTENER TODOS LAS FUNCIONES POR ID USUARIO =========//

    @Override
    public void agregarArtistaInvitadoALaFuncion(Long idFuncion, List<Long> idUsuarios) throws SQLException {
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(agregarArtistaALaFuncion);
        for (Long idUsuario : idUsuarios) {
            sentencia.setLong(1, idFuncion);
            sentencia.setLong(2, idUsuario);
            sentencia.executeUpdate();
        }
    }

    //==================== AlTA DE ESPECTADOR A FUNCION =======================//
    @Override
    public void altaEspectadorAFuncion(Funcion funcion, Espectador espectador, Date fechaRegistroEspectaculo, BigDecimal costo) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(agregarEspectadorAFuncion);
            sentencia.setLong(1, funcion.getId());
            sentencia.setLong(2, espectador.getId());
            sentencia.setDate(3, new java.sql.Date(fechaRegistroEspectaculo.getTime()));
            sentencia.setBigDecimal(4, costo);
            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("El Espectador ya se encuentra registrado a la Función", funcion.getNombre()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }

    @Override
    public List<Funcion> getFuncionesPorIdEspectador(Espectador espectador) {
        try {
            List<Funcion> funciones = new ArrayList<>();
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLasFuncionesPorIdEspectador);
            sentencia.setLong(1, espectador.getId());
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                funciones.add(getFuncionPorId(rs.getLong("idFuncion")));
            }
            return funciones;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }

    @Override
    public void eliminarFuncionesDelEspectador(ArrayList<Funcion> funciones, Espectador espectador) {
        try {
            validarParametrosEliminarFuncionesDelEspectador(funciones, espectador);
            for (int i = 0; i < funciones.size(); i++) {
                PreparedStatement sentencia = conexion.getConexion().prepareStatement(eliminarFuncionesDeEspectador);
                sentencia.setLong(1, espectador.getId());
                sentencia.setLong(2, funciones.get(i).getId());
                sentencia.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Integer getCantidadRegistrados(Long idFuncion) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(cantRegistradosParaFuncion);
            sentencia.setLong(1, idFuncion);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return rs.getInt("cnt");
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
        return 0;
    }

    @Override
    public Boolean getUsuarioRegistradoEnFuncion(Long idFuncion, Long idUsuario) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(cantFuncionesPorUsuario);
            sentencia.setLong(1, idFuncion);
            sentencia.setLong(2, idUsuario);
            ResultSet rs = sentencia.executeQuery();
            Integer cantidad = 0;
            while (rs.next()) {
                cantidad = rs.getInt("cnt");
            }
            return cantidad > 0;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
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
        String nombre = rs.getString("nombre");
        String imagen = rs.getString("imagen");
        Boolean sorteo = rs.getBoolean("sorteo");
        String descripcionPremios = rs.getString("descripcionPremios");
        int cantidadPremios = rs.getInt("cantidadPremios");

        List<Artista> artistasInvitados = getArtistasInvitadosAFuncion(idFuncion);

        return new Funcion(idFuncion, idEspectaculo, fechaInicio, fechaRegistro, artistasInvitados, nombre, imagen, sorteo,descripcionPremios,cantidadPremios);
    }

    private void validarParametrosEliminarFuncionesDelEspectador(ArrayList<Funcion> funciones, Espectador espectador) {
        for (int i = 0; i < funciones.size(); i++) {
            if (funciones.get(i).getId() == null) {
                throw new InnovaModelException("La Funcion a eliminar es invalida");
            }
        }
        if (espectador.getId() == null) {
            throw new InnovaModelException("La Espectador es invalido");
        }
    }

    //========== OBTENER TODOS LAS FUNCIONES POR ID ESPECTACULO DTO =========//
    @Override
    public List<FuncionDTO> getFuncionesPorIdEspectaculoDTO(Long idEspectaculo) {
        List<FuncionDTO> funciones = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(funcionesPorIdEspectaculo);
            sentencia.setLong(1, idEspectaculo);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                funciones.add(funcionMapperDTO(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funciones;
    }
    //=========== OBTENER TODOS LAS FUNCIONES POR ID ESPECTACULO DTO =========//

    //========================== MAPPER FUNCION DTO ==========================//
    private FuncionDTO funcionMapperDTO(ResultSet rs) throws SQLException {

        Long idFuncion = rs.getLong("id");
        Long idEspectaculo = rs.getLong("idEspectaculo");
        Date fechaInicio = rs.getTimestamp("fechaInicio");
        Date fechaRegistro = rs.getTimestamp("fechaRegistro");
        String nombre = rs.getString("nombre");
        String imagen = rs.getString("imagen");
        Boolean sorteo = rs.getBoolean("sorteo");
        String descripcionPremios = rs.getString("descripcionPremios");
        int cantidadPremios = rs.getInt("cantidadPremios");

        List<UsuarioDTO> artistasInvitados = getArtistasInvitadosAFuncionDTO(idFuncion);

        return new FuncionDTO(idFuncion, nombre, idEspectaculo, fechaInicio, fechaRegistro, artistasInvitados, imagen, sorteo,descripcionPremios,cantidadPremios);
    }
    //========================== MAPPER FUNCION DTO ==========================//

    //==================== AlTA DE FUNCION DTO=======================//
    @Override
    @Deprecated
    public void altaFuncionDTO(FuncionDTO funcion) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(altaFunciones, Statement.RETURN_GENERATED_KEYS);
            sentencia.setLong(1, funcion.getIdEspectaculo());
            sentencia.setString(2, funcion.getNombre());
            sentencia.setDate(3, new java.sql.Date(funcion.getFechaInicio().getTime()));
            sentencia.setDate(4, new java.sql.Date(funcion.getFechaRegistro().getTime()));
            sentencia.setString(5, funcion.getImagen());
            sentencia.executeUpdate();

            Integer newId = null;
            ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.next()) {
                newId = rs.getInt(1);
            }
            for (UsuarioDTO artista : funcion.getArtistasInvitados()) {
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
    //==================== AlTA DE FUNCION DTO=======================//

    //==================== OBTENER FUNCION DTO POR ID ============//
    @Override
    public FuncionDTO getFuncionDTOPorId(Long idFuncion) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(funcionPorId);
            sentencia.setLong(1, idFuncion);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return funcionMapperDTO(rs);
            }
            return null;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }

    //==================== OBTENER FUNCION DTO POR ID ============//
    @Override
    public List<UsuarioDTO> getArtistasInvitadosAFuncionDTO(Long idFuncion) throws SQLException {
        List<UsuarioDTO> artistasInvitados = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(artistaInvitadosEnFuncion);
        sentencia.setLong(1, idFuncion);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            UsuarioDTO artistaInvitado = usuarioServicio.getUsuarioDTOPorId(rs.getLong("idUsuario"));
            artistasInvitados.add(artistaInvitado);
        }
        return artistasInvitados;
    }

    @Override
    public List<FuncionDTO> getFuncionesDeUsuarioParaCanjear(Long idUsuario) {
        List<FuncionDTO> funciones = new ArrayList<>();
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(funcionesParaCanjear);
            sentencia.setLong(1, idUsuario);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                funciones.add(funcionMapperDTO(rs));
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
        return funciones;
    }

    //============================ MODIFICAR Usuario =========================//
    @Override
    public void entregaDePremios(Long idFuncion) {

        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(sorteoRealizado);
            sentencia.setLong(1, idFuncion);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }
    //============================ MODIFICAR ESPECTADOR =========================//

}
