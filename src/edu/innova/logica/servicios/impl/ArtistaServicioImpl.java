package edu.innova.logica.servicios.impl;

import edu.innova.logica.Constantes;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import edu.innova.logica.servicios.ArtistaServicio;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import edu.innova.logica.servicios.EspectadorServicio;

public class ArtistaServicioImpl implements ArtistaServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String artistaPorId = "SELECT * FROM artistas WHERE id = ?";
    private final String artistaPorNickname = "SELECT * FROM artistas WHERE nickname = ?";
    private final String todosLosArtistas = "SELECT * FROM artistas WHERE tipo = 'artista'";
    private final String nuevoArtista = "INSERT INTO artistas (nickname, nombre, apellido, email, tipo, fechaNacimiento, descripcion, biografia, linkUsuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String modificarArtista = "UPDATE artistas SET nombre = ?, apellido = ?, fechaNacimiento = ?, linkUsuario = ?, descripcion = ?, biografia = ? WHERE id = ?";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//

    //INSTANCIA DE LA CLASE
    private static ArtistaServicioImpl servicioUsuario;

    private ConexionDB conexion = new ConexionDB();//OBTENER LA CONEXION A LA BASE DE DATOS

    public ArtistaServicioImpl() {//DEFAULT
    }

    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public ArtistaServicioImpl getInstance() {
        if (null == servicioUsuario) {
            servicioUsuario = new ArtistaServicioImpl();
        }
        return servicioUsuario;
    }
    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//

    //======================= OBTENER USUARIO POR ID =========================//
    @Override
    public Usuario getUsuarioPorId(Long id) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(artistaPorId);
        sentencia.setLong(1, id);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            return artistaMapper(rs);
        }
        throw new NoSuchElementException(String.format("Usuario con id %s no encontrado", id));
    }
    //======================= OBTENER USUARIO POR ID =========================//

    //===================== OBTENER USUARIO POR NICKNAME =====================//
    @Override
    public Usuario getUsuarioPorNickName(String nickname) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(artistaPorNickname);
        sentencia.setString(1, nickname);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            return artistaMapper(rs);
        }
        throw new NoSuchElementException(String.format("Usuario con nickname %s no encontrado", nickname));
    }
    //===================== OBTENER USUARIO POR NICKNAME =====================//

    //================== OBTENER LA LISTA DE TODOS LOS ARTISTAS ===============//
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
    //================== OBTENER LA LISTA DE TODOS LOS ARTISTAS ===============//

    //============================= ALTA ARTISTA =============================//
    @Override
    public void altaUsuario(Usuario usuario) throws SQLException {
        String nuevoArtista = "INSERT INTO artistas (nickname, nombre, apellido, email, fechaNacimiento, descripcion, biografia, linkUsuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        if (usuario instanceof Artista) {
            Artista artista = (Artista) usuario;
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoArtista);
            sentencia.setString(1, artista.getNickname());
            sentencia.setString(2, artista.getNombre());
            sentencia.setString(3, artista.getApellido());
            sentencia.setString(4, artista.getEmail());
            sentencia.setDate(5, new java.sql.Date(artista.getFechaNacimiento().getTime()));
            sentencia.setString(6, artista.getDescripcion());
            sentencia.setString(7, artista.getBiografia());
            sentencia.setString(8, artista.getLinkUsuario());
            sentencia.executeUpdate();
        } else {
            throw new IllegalArgumentException("Estas intentando agregar algo que no es un Artista");
        }
    }
    //============================= ALTA ARTISTA =============================//

    //============================ MODIFICAR USUARIO =========================//
    @Override
    public void modificarUsuario(Usuario usuario) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(modificarArtista);

        String linkUsuario = usuario instanceof Artista ? ((Artista) usuario).getLinkUsuario() : null;
        String descripcion = usuario instanceof Artista ? ((Artista) usuario).getDescripcion() : null;
        String biografia = usuario instanceof Artista ? ((Artista) usuario).getBiografia() : null;

        sentencia.setString(1, usuario.getNombre());
        sentencia.setString(2, usuario.getApellido());
        sentencia.setDate(3, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
        sentencia.setString(4, linkUsuario);
        sentencia.setString(5, descripcion);
        sentencia.setString(6, biografia);
        sentencia.setLong(7, usuario.getId());
        sentencia.executeUpdate();

    }
    //============================ MODIFICAR ARTISTA =========================//

    //============================ DEVOLVER UN ARTISTA =======================//
    private Artista artistaMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        return new Artista(rs.getString("descripcion"), rs.getString("biografia"), rs.getString("linkUsuario"),
                rs.getLong("id"), rs.getString("nickname"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("email"), fechaNacimiento);
    }
    //============================ DEVOLVER UN ARTISTA =======================//
}
