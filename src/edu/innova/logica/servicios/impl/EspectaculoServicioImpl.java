package edu.innova.logica.servicios.impl;

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
import edu.innova.logica.servicios.EspectadorServicio;

public class EspectaculoServicioImpl implements EspectaculoServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String altaEspectaculo = "INSERT INTO espectaculos (idUsuario, idPlataforma, nombre, descripcion, duracion, espectadoresMinimos, url, costo, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String todosLosEspectaculos = "SELECT * FROM espectaculos";
    private final String espectaculoPorId = "SELECT * FROM espectaculos WHERE id = ?";    
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//

    //INSTANCIA DE LA CLASE
    private static EspectaculoServicioImpl servicio;

    //OBTENER LA CONEXION A LA BASE DE DATOS
    private ConexionDB conexion = new ConexionDB();

    private EspectadorServicio usuarioServicio = new EspectadorServicioImpl().getInstance();
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
    public void altaEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo) throws SQLException {
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(altaEspectaculo);
        sentencia.setLong(1, idArtista);
        sentencia.setLong(2, idPlataforma);
        sentencia.setString(3, espectaculo.getNombre());
        sentencia.setString(4, espectaculo.getDescripcion());
        sentencia.setInt(5, espectaculo.getDuracion());
        sentencia.setInt(6, espectaculo.getEspectadoredMinimos());
        sentencia.setString(7, espectaculo.getUrl());
        sentencia.setBigDecimal(8, espectaculo.getCosto());
        sentencia.setDate(9, new java.sql.Date(espectaculo.getFechaRegistro().getTime()));
        sentencia.executeUpdate();
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
    
    
    private Espectaculo espectaculoMapper(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        Integer duracion = rs.getInt("duracion");
        Integer espectadoresMinimos = rs.getInt("espectadoresMinimos");
        String url = rs.getString("url");
        BigDecimal costo = rs.getBigDecimal("costo");
        Date fechaRegistro = rs.getTimestamp("fechaRegistro");       
        Artista artista = (Artista) usuarioServicio.getUsuarioPorId(rs.getLong("idUsuario"));
        Plataforma plataforma = plataformaServicio.getPlataformaPorId(rs.getLong("idPlataforma"));
        
        List<Funcion> funciones = funcionServicio.getTodosLasFuncionesPorIdEspectaculo(id);
        
        return new Espectaculo(id, artista, nombre, plataforma, descripcion, duracion, espectadoresMinimos, url, costo, fechaRegistro, funciones);
    }

}
