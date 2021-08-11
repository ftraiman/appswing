/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.logica.servicios.impl;

import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioServicioImpl implements UsuarioServicio {

    private final String usuarioPorId = "SELECT * FROM usuarios WHERE id = ?";
    private final String usuarioPorNickname = "SELECT * FROM usuarios WHERE nickname = ?";
    private final String todosLosEspectadores = "SELECT * FROM usuarios WHERE tipo = 'espectador'";
    private final String todosLosArtistas = "SELECT * FROM usuarios WHERE tipo = 'artista'";
    private final String nuevoEspectador = "INSERT INTO usuarios (nickname, nombre, apellido, email, tipo, fechaNacimiento) VALUES(?, ?, ?, ?, ?, ?)";
    private final String nuevoArtista = "INSERT INTO usuarios (nickname, nombre, apellido, email, tipo, fechaNacimiento, descripcion, biografia, linkUsuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static UsuarioServicioImpl servicioUsuario;

    private ConexionDB conexion = new ConexionDB();

    public UsuarioServicioImpl() {
    }

    public UsuarioServicioImpl getInstance() {
        if (null == servicioUsuario) {
            servicioUsuario = new UsuarioServicioImpl();
        }
        return servicioUsuario;
    }

    @Override
    public Usuario getUsuarioPorId(Long id) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(usuarioPorId);
        sentencia.setLong(1, id);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            String tipo = rs.getString("tipo");
            if ("espectador".equalsIgnoreCase(tipo)) {
                return espectadorMapper(rs);
            } else if ("artista".equalsIgnoreCase(tipo)) {
                return artistaMapper(rs);
            }
        }
        throw new NoSuchElementException(String.format("Usuario con id %s no encontrado", id));
    }

    @Override
    public Usuario getUsuarioPorNickName(String nickname) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(usuarioPorNickname);
        sentencia.setString(1, nickname);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            String tipo = rs.getString("tipo");
            if ("espectador".equalsIgnoreCase(tipo)) {
                return espectadorMapper(rs);
            } else if ("artista".equalsIgnoreCase(tipo)) {
                return artistaMapper(rs);
            }
        }
        throw new NoSuchElementException(String.format("Usuario con nickname %s no encontrado", nickname));
    }

    @Override
    public List<Espectador> getTodosLosEspectadores() throws SQLException {
        List<Espectador> espectadores = new ArrayList<>();

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosEspectadores);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            espectadores.add((Espectador) espectadorMapper(rs));
        }
        return espectadores;
    }

    @Override
    public List<Artista> getTodosLosArtistas() throws SQLException {
        List<Artista> espectadores = new ArrayList<>();

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosArtistas);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            espectadores.add((Artista) artistaMapper(rs));
        }
        return espectadores;
    }

    @Override
    public void altaUsuario(Usuario usuario) {

        if (usuario instanceof Espectador) {
            Espectador espectador = (Espectador) usuario;
            try {
//                String nuevoEspectador = "INSERT INTO usuarios (nickname, nombre, apellido, email, tipo, fechaNacimiento)"
//                        + "VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoEspectador);
                sentencia.setString(1, espectador.getNickname());
                sentencia.setString(2, espectador.getNombre());
                sentencia.setString(3, espectador.getApellido());
                sentencia.setString(4, espectador.getEmail());
                sentencia.setString(5, espectador.getTipo());
                sentencia.setDate(6, new java.sql.Date(espectador.getFechaNacimiento().getTime()));
                sentencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (usuario instanceof Artista) {
            Artista artista = (Artista) usuario;
            try {
                String nuevoArtista = "INSERT INTO usuarios (nickname, nombre, apellido, email, tipo, fechaNacimiento, descripcion, biografia, linkUsuario)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoArtista);
                sentencia.setString(1, artista.getNickname());
                sentencia.setString(2, artista.getNombre());
                sentencia.setString(3, artista.getApellido());
                sentencia.setString(4, artista.getEmail());
                sentencia.setString(5, artista.getTipo());
                sentencia.setDate(6, new java.sql.Date(artista.getFechaNacimiento().getTime()));
                sentencia.setString(7, artista.getDescripcion());
                sentencia.setString(8, artista.getBiografia());
                sentencia.setString(9, artista.getLinkUsuario());
                sentencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Usuario espectadorMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        return new Espectador(rs.getLong("id"), rs.getString("nickname"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("email"), fechaNacimiento, rs.getString("tipo"));
    }

    private Usuario artistaMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        return new Artista(rs.getString("descripcion"), rs.getString("biografia"), rs.getString("linkUsuario"),
                rs.getLong("id"), rs.getString("nickname"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("email"), fechaNacimiento, rs.getString("tipo"));
    }
}
