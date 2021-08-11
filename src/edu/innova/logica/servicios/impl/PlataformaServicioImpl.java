package edu.innova.logica.servicios.impl;

import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlataformaServicioImpl implements PlataformaServicio {
    
    private final String altaPlataforma = "INSERT INTO plataformas (nombre, descripcion, url) VALUES (?, ?, ?)";

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

}
