package edu.innova.logica.servicios.impl;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Paquete;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import edu.innova.logica.servicios.PaqueteServicio;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaqueteServicioImpl implements PaqueteServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String altaPaquete = "INSERT INTO paquetes (nombre, descripcion, fechaInicio, fechaFin, descuento, fechaRegistro) VALUES (?, ?, ?, ?, ?, ?)";
    private final String altaEspectaculoPaquete = "INSERT INTO paquetes_espectaculos (idEspectaculo, idPaquete) VALUES (?, ?)";
    private final String todosLosPaquetes = "SELECT * FROM paquetes";
    private final String todosLosPaquetesPorIdEspectaculos = "SELECT * FROM paquetes p, paquetes_espectaculos pe WHERE p.id = pe.idPaquete AND pe.idEspectaculo = ?";
    private final String espectaculosEnPaquetes = "SELECT * FROM paquetes_espectaculos WHERE idPaquete = ?";
    private final String EspectaculosDeNOPaquetes = "SELECT * FROM espectaculos e JOIN plataformas p on e.idPlataforma = p.id WHERE p.id = ? AND NOT EXISTS(SELECT * FROM paquetes_espectaculos pe WHERE pe.idEspectaculo = e.id AND idPaquete = ?);";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//

    private static PaqueteServicioImpl servicio;

    private ConexionDB conexion = new ConexionDB();

    private EspectaculoServicio espectaculoServicio = new EspectaculoServicioImpl().getInstance();

    public PaqueteServicioImpl() {
    }

    public PaqueteServicioImpl getInstance() {
        if (null == servicio) {
            servicio = new PaqueteServicioImpl();
        }
        return servicio;
    }

    @Override
    public void altaPaquete(Paquete paquete) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaPaquete);
            sentencia.setString(1, paquete.getNombre());
            sentencia.setString(2, paquete.getDescripcion());
            sentencia.setDate(3, new java.sql.Date(paquete.getFechaInicio().getTime()));
            sentencia.setDate(4, new java.sql.Date(paquete.getFechaFin().getTime()));
            sentencia.setBigDecimal(5, paquete.getDescuento());
            sentencia.setDate(6, new java.sql.Date((new Date()).getTime()));
            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe un espectaculo con el nombre [%s]", paquete.getNombre()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    @Override
    public void agregarEspectaculoAlPaquete(Long idEspectaculo, Long idPaquete) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaEspectaculoPaquete);
            sentencia.setLong(1, idEspectaculo);
            sentencia.setLong(2, idPaquete);
            sentencia.executeUpdate();
        } catch (MysqlDataTruncation ex) {
            throw new InnovaModelException("Ya existe el Espectáculo en el Paquete");
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    public static void main(String[] args) {
        PaqueteServicioImpl psi = new PaqueteServicioImpl().getInstance();
        psi.agregarEspectaculoAlPaquete(Long.MIN_VALUE, Long.MIN_VALUE);
    }

    @Override
    public List<Paquete> getTodosLosPaquetes() throws SQLException {
        List<Paquete> paquetes = new ArrayList<>();
        PreparedStatement sentencia;

        sentencia = conexion.getConexion().prepareStatement(todosLosPaquetes);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            paquetes.add((Paquete) paqueteMapper(rs));
        }

        return paquetes;
    }

    private Paquete paqueteMapper(ResultSet rs) throws SQLException {
        Date fechaInicio = rs.getTimestamp("fechaInicio");
        BigDecimal descuento = HelperStrings.getBigDecimalValue(rs.getString("descuento"));
        Date fechaFin = rs.getTimestamp("fechaFin");
        List<Espectaculo> espectaculosDelPaquete = getEspectaculosDelPaquete(rs.getLong("id"));
        return new Paquete(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"), fechaInicio, fechaFin, descuento, espectaculosDelPaquete);
    }

    private List<Espectaculo> getEspectaculosDelPaquete(Long idPaquete) {
        List<Espectaculo> espectaculos = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectaculosEnPaquetes);
            sentencia.setLong(1, idPaquete);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectaculos.add(espectaculoServicio.getEspectaculoPorId(rs.getLong("idEspectaculo")));
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
        return espectaculos;
    }
    
    
  public List<Espectaculo> getEspectaculosNOPaquete(Long idPaquete , Long idPlataforma) {
        List<Espectaculo> espectaculos = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(EspectaculosDeNOPaquetes);
            sentencia.setLong(1, idPlataforma);
            sentencia.setLong(2, idPaquete);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectaculos.add(espectaculoServicio.getEspectaculoPorId(rs.getLong("id")));
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
        return espectaculos;
    }

    @Override
    public List<Paquete> getPaquetePorIdEspectaculo(Long id) throws SQLException {
         List<Paquete> paquetes = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosPaquetesPorIdEspectaculos);
            sentencia.setLong(1, id);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                paquetes.add((Paquete) paqueteMapper(rs));

            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
        return paquetes;
    }
}

