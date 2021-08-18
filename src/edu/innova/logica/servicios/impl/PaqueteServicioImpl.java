package edu.innova.logica.servicios.impl;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.entidades.Paquete;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import edu.innova.logica.servicios.PaqueteServicio;

public class PaqueteServicioImpl implements PaqueteServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String altaPaquete = "INSERT INTO paquetes (nombre, descripcion, fechaInicio, fechaFin, descuento) VALUES (?, ?, ?, ?, ?)";
    private final String altaEspectaculoPaquete = "INSERT INTO paquetes_espectaculos (idEspectaculo, idPaquete) VALUES (?, ?)";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//

    private static PaqueteServicioImpl servicio;

    private ConexionDB conexion = new ConexionDB();

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
}
