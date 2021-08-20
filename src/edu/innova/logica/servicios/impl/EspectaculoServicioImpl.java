package edu.innova.logica.servicios.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.persistencia.ConexionDB;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import edu.innova.logica.servicios.UsuarioServicio;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EspectaculoServicioImpl implements EspectaculoServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String altaEspectaculo = "INSERT INTO espectaculos (nombre,costo,url,duracion,descripcion,fechaRegistro,idUsuario,idPlataforma,espectadoresMinimos,espectadoresMaximos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String todosLosEspectaculos = "SELECT * FROM espectaculos";
    private final String todosLosEspectaculosPorIdPlataforma = "SELECT * FROM espectaculos WHERE idPlataforma = ?";
    private final String espectaculoPorId = "SELECT * FROM espectaculos WHERE id = ?";
    private final String espectaculoPorIdA = "SELECT * FROM espectaculos WHERE idUsuario = ?";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//

    //INSTANCIA DE LA CLASE
    private static EspectaculoServicioImpl servicio;

    //OBTENER LA CONEXION A LA BASE DE DATOS
    private ConexionDB conexion = new ConexionDB();

    private UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();
    private PlataformaServicio plataformaServicio = new PlataformaServicioImpl().getInstance();
    private FuncionServicio funcionServicio = new FuncionServicioImpl().getInstance();

    public EspectaculoServicioImpl() {//DEFAULT
    }

    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public EspectaculoServicioImpl getInstance() {
        if (null == servicio) {
            servicio = new EspectaculoServicioImpl();
        }
        return servicio;
    }

    //==================== AlTA DE ESPECTACULO ===================//
    @Override
    public void altaEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaEspectaculo);
            sentencia.setString(1, espectaculo.getNombre());
            sentencia.setBigDecimal(2, espectaculo.getCosto());
            sentencia.setString(3, espectaculo.getUrl());
            sentencia.setInt(4, espectaculo.getDuracion());
            sentencia.setString(5, espectaculo.getDescripcion());
            sentencia.setDate(6, new java.sql.Date(espectaculo.getFechaRegistro().getTime()));
            sentencia.setLong(7, idArtista);
            sentencia.setLong(8, idPlataforma);
            sentencia.setInt(9, espectaculo.getEspectadoresMinimos());
            sentencia.setInt(10, espectaculo.getEspectadoresMaximos());
            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe un espectaculo con el nombre [%s]",espectaculo.getNombre()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }

    }
    //==================== AlTA DE ESPECTACULO ===================//

    //==================== OBTENER ESPECTACULO POR ID ============//
    @Override
    public Espectaculo getEspectaculoPorId(Long idEspectaculo) throws SQLException {
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectaculoPorId);
        sentencia.setLong(1, idEspectaculo);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            return espectaculoMapper(rs);
        }
        throw new NoSuchElementException(String.format("Espectaculo con id %s no encontrado", idEspectaculo));
    }
    //==================== OBTENER ESPECTACULO POR ID ============//
    
    
     //==================== OBTENER ESPECTACULO POR ID Arista============//
    @Override
    public List<Espectaculo> getEspectaculosPorIdArtista(Long idArtista) {
        List<Espectaculo> espectaculos = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectaculoPorIdA);
            sentencia.setLong(1, idArtista);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectaculos.add(espectaculoMapper(rs));
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL %s", ex.getMessage())); 
        }
        return espectaculos;
    }
    
    //==================== OBTENER ESPECTACULO POR ID Artista============//
    
    //==================== OBTENER TODOS LOS ESPECTACULOS=========//
    @Override
    public List<Espectaculo> getTodosLosEspectaculos() throws SQLException {
        List<Espectaculo> espectaculos = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosEspectaculos);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            espectaculos.add(espectaculoMapper(rs));
        }
        return espectaculos;
    }
    //==================== OBTENER TODOS LOS ESPECTACULOS=========//
    
    @Override
    public List<Espectaculo> getTodosLosEspectaculosPorPlataforma(Long idPlataforma) {
        try {
            List<Espectaculo> espectaculos = new ArrayList<>();
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosEspectaculosPorIdPlataforma);
            sentencia.setLong(1, idPlataforma);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectaculos.add(espectaculoMapper(rs));
            }
            return espectaculos;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()),ex.getCause());
        }
    }

    private Espectaculo espectaculoMapper(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        Integer duracion = rs.getInt("duracion");
        Integer espectadoresMinimos = rs.getInt("espectadoresMinimos");
        Integer espectadoresMaximos = rs.getInt("espectadoresMaximos");
        String url = rs.getString("url");
        BigDecimal costo = rs.getBigDecimal("costo");
        Date fechaRegistro = rs.getTimestamp("fechaRegistro");
        Artista artista = (Artista) usuarioServicio.getUsuarioPorId(rs.getLong("idUsuario"));
        Plataforma plataforma = plataformaServicio.getPlataformaPorId(rs.getLong("idPlataforma"));

        List<Funcion> funciones = funcionServicio.getTodosLasFuncionesPorIdEspectaculo(id);

        return new Espectaculo(id, artista, nombre, plataforma, descripcion, duracion, espectadoresMinimos, espectadoresMaximos, url, costo, fechaRegistro, funciones);
    }

}
