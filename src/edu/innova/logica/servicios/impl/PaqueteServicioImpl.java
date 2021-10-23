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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaqueteServicioImpl implements PaqueteServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String altaPaquete = "INSERT INTO paquetes (nombre, descripcion, fechaInicio, fechaFin, descuento, fechaRegistro,imagen) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String altaEspectaculoPaquete = "INSERT INTO paquetes_espectaculos (idEspectaculo, idPaquete) VALUES (?, ?)";
    private final String todosLosPaquetes = "SELECT * FROM paquetes";
    private final String todosLosPaquetesPorIdEspectaculos = "SELECT * FROM paquetes p, paquetes_espectaculos pe WHERE p.id = pe.idPaquete AND pe.idEspectaculo = ?";
    private final String espectaculosEnPaquetes = "SELECT * FROM paquetes_espectaculos WHERE idPaquete = ?";
    private final String espectaculosDeNOPaquetes = "SELECT * FROM espectaculos e JOIN plataformas p on e.idPlataforma = p.id WHERE p.id = ? AND NOT EXISTS(SELECT * FROM paquetes_espectaculos pe WHERE pe.idEspectaculo = e.id AND idPaquete = ?);";
    private final String paquetesPorIdArtista = "SELECT p.* FROM paquetes p JOIN paquetes_artistas pa on p.id = pa.idPaquete WHERE idArtista = ?";
    private final String paquetePorIdPaquete = "SELECT * FROM paquetes WHERE id = ?";
    private final String altaUsuarioEnPaquete = "INSERT INTO paquetes_usuarios (idUsuario, idPaquete, fechaRegistro) VALUES (?, ?, NOW())";
    private final String paquetesCompradosPorUsuario = "SELECT p.* FROM paquetes p JOIN paquetes_usuarios pu on p.id = pu.idPaquete WHERE pu.idUsuario = ?";
    private final String paqueteArtista = "INSERT INTO paquetes_artistas (idPaquete, idArtista) VALUES (?, ?)";
    private final String paquetesPorFuncionYUsuario = "SELECT p.* FROM paquetes p JOIN paquetes_espectaculos pe on p.id = pe.idPaquete JOIN funciones f on pe.idEspectaculo = f.idEspectaculo JOIN paquetes_usuarios pu on p.id = pu.idPaquete WHERE pu.idUsuario = ? AND f.id = ? AND NOT EXISTS(SELECT * FROM paquetes_espectaculos_utilizados peu WHERE peu.idUsuario = pu.idUsuario AND peu.idPaquete = pe.idPaquete AND peu.idEspectaculo = pe.idEspectaculo)";
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
    public Long altaPaquete(Paquete paquete) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaPaquete, Statement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, paquete.getNombre());
            sentencia.setString(2, paquete.getDescripcion());
            sentencia.setDate(3, new java.sql.Date(paquete.getFechaInicio().getTime()));
            sentencia.setDate(4, new java.sql.Date(paquete.getFechaFin().getTime()));
            sentencia.setBigDecimal(5, paquete.getDescuento());
            sentencia.setDate(6, new java.sql.Date((new Date()).getTime()));
            sentencia.setString(7, paquete.getImagen());
            sentencia.executeUpdate();
            
            ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe un espectaculo con el nombre [%s]", paquete.getNombre()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
        return null;
    }
    
    @Override
    public void altaPaqueteArtista(Long idPaquete, Long idArtista) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(paqueteArtista);
            sentencia.setLong(1, idPaquete);
            sentencia.setLong(2, idArtista);
            sentencia.executeUpdate();
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
    public List<Paquete> getTodosLosPaquetes() {
        List<Paquete> paquetes = new ArrayList<>();
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(todosLosPaquetes);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                paquetes.add((Paquete) paqueteMapper(rs));
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
        paquetes.forEach(paquete -> paquete.setEspectaculos(getEspectaculosDelPaquete(paquete.getId())));
        return paquetes;
    }

    @Override
    public List<Paquete> getPaquetesPorIdArtista(Long idArtista) {
        List<Paquete> paquetes = new ArrayList<>();
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(paquetesPorIdArtista);
            sentencia.setLong(1, idArtista);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                paquetes.add((Paquete) paqueteMapper(rs));
            }
            paquetes.forEach(paquete -> paquete.setEspectaculos(getEspectaculosDelPaquete(paquete.getId())));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
        return paquetes;
    }

    @Override
    public List<Paquete> getPaquetesContratadosPorIdUsuario(Long idUsuario) {
        List<Paquete> paquetes = new ArrayList<>();
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(paquetesCompradosPorUsuario);
            sentencia.setLong(1, idUsuario);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                paquetes.add((Paquete) paqueteMapper(rs));
            }
            paquetes.forEach(paquete -> paquete.setEspectaculos(getEspectaculosDelPaquete(paquete.getId())));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
        return paquetes;
    }

    @Override
    public Paquete getPaquetesPorId(Long idPaquete) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(paquetePorIdPaquete);
            sentencia.setLong(1, idPaquete);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return paqueteMapper(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Paquete paqueteMapper(ResultSet rs) throws SQLException {
        Date fechaInicio = rs.getTimestamp("fechaInicio");
        BigDecimal descuento = HelperStrings.getBigDecimalValue(rs.getString("descuento"));
        Date fechaFin = rs.getTimestamp("fechaFin");
        List<Espectaculo> espectaculosDelPaquete = getEspectaculosDelPaquete(rs.getLong("id"));
        String imagen = rs.getString("imagen");
        return new Paquete(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"), fechaInicio, fechaFin, descuento, espectaculosDelPaquete, imagen);
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

    @Override
    public List<Espectaculo> getEspectaculosNOPaquete(Long idPaquete, Long idPlataforma) {
        List<Espectaculo> espectaculos = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectaculosDeNOPaquetes);
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
    public List<Paquete> getPaquetePorIdEspectaculo(Long id) {
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

    @Override
    public void altaUsuarioEnPaquete(Long idUsuario, Long idPaquete) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(altaUsuarioEnPaquete);
            sentencia.setLong(1, idUsuario);
            sentencia.setLong(2, idPaquete);
            sentencia.executeUpdate();
        } catch (MysqlDataTruncation ex) {
            throw new InnovaModelException("Ya existe el Espectáculo en el Paquete");
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException("El usuario ya dispone del paquete");
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Paquete> getPaquetesConLaFuncion(Long idUsuario, Long idFuncion) {
        List<Paquete> paquetes = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(paquetesPorFuncionYUsuario);
            sentencia.setLong(1, idUsuario);
            sentencia.setLong(2, idFuncion);
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
