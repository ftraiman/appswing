package edu.innova.logica.servicios.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PlataformaServicioImpl implements PlataformaServicio {

    private final String altaPlataforma = "INSERT INTO plataformas (nombre, descripcion, url) VALUES (?, ?, ?)";
    private final String plataformaPorId = "SELECT * FROM plataformas WHERE id = ?";
    private final String plataformaPorNombre = "SELECT * FROM plataformas WHERE nombre = ?";
    private final String todasLasPlataformas = "SELECT * FROM plataformas";

    private static PlataformaServicioImpl plataformaServicio;

    private ConexionDB conexion = new ConexionDB();

    public PlataformaServicioImpl() {
    }

    public PlataformaServicioImpl getInstance() {
        if (null == plataformaServicio) {
            plataformaServicio = new PlataformaServicioImpl();
        }
        return plataformaServicio;
    }

    public void altaPlataforma(Plataforma plataforma) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(altaPlataforma);
        sentencia.setString(1, plataforma.getNombre());
        sentencia.setString(2, plataforma.getDescripcion());
        sentencia.setString(3, plataforma.getUrl());
        sentencia.executeUpdate();
    }

    @Override
    public Plataforma getPlataformaPorId(Long idPlataforma) throws SQLException {
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(plataformaPorId);
        sentencia.setLong(1, idPlataforma);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            return plataformaMapper(rs);
        }
        throw new NoSuchElementException(String.format("Plataforma con id %s no encontrado", idPlataforma));
    }
    
    @Override
    public Plataforma getPlataformaPorNombre(String nombre)  {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(plataformaPorNombre);
            sentencia.setString(1, nombre);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return plataformaMapper(rs);
            }
            throw new NoSuchElementException(String.format("Plataforma con el nombre %s no encontrado", nombre));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }

    @Override
    public List<Plataforma> getTodasLasPlataformas() {
        List<Plataforma> plataformas = new ArrayList<>();
        ResultSet rs;
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todasLasPlataformas);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                plataformas.add(plataformaMapper(rs));
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }

        return plataformas;
    }

    private Plataforma plataformaMapper(ResultSet rs) throws SQLException {
        return new Plataforma(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("url"));
    }

    @Override
    public void altaPlataforma(String nombre, String descripcion, String url) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
