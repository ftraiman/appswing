package edu.innova.logica.servicios.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import edu.innova.logica.servicios.UsuarioServicio;

public class UsuarioServicioImpl implements UsuarioServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String usuarioPorId = "SELECT * FROM usuarios u LEFT JOIN datos_artistas da ON u.nickname = da.nickname WHERE id = ?";
    private final String usuarioPorNickname = "SELECT id, u.nickname, nombre, apellido, email, fechaNacimiento, clave, tipo, descripcion, biografia, linkUsuario FROM usuarios u LEFT JOIN datos_artistas da ON u.nickname = da.nickname WHERE u.nickname = ?";
    private final String todosLosEspectadores = "SELECT * FROM usuarios WHERE tipo = 'espectador'";
    private final String todosLosArtistas = "SELECT * FROM usuarios e JOIN datos_artistas da ON e.nickname = da.nickname WHERE tipo = 'artista'";
    private final String nuevoUsuario = "INSERT INTO usuarios (nickname, nombre, apellido, email, fechaNacimiento, tipo) VALUES (?, ?, ?, ?, ?, ?)";
    private final String nuevoDatosArtista = "INSERT INTO datos_artistas (nickname, descripcion, biografia, linkUsuario) VALUES (?, ?, ?, ?)";
    private final String modificarUsuario = "UPDATE usuarios SET nombre = ?, apellido = ?, fechaNacimiento = ? WHERE id = ?";
    private final String modificarDatosArtista = "UPDATE datos_artistas SET descripcion = ?, biografia = ?, linkUsuario= ? WHERE nickname = ?";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//

    //INSTANCIA DE LA CLASE
    private static UsuarioServicioImpl servicioUsuario;

    private ConexionDB conexion = new ConexionDB();//OBTENER LA CONEXION A LA BASE DE DATOS

    public UsuarioServicioImpl() {//DEFAULT
    }

    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public UsuarioServicioImpl getInstance() {
        if (null == servicioUsuario) {
            servicioUsuario = new UsuarioServicioImpl();
        }
        return servicioUsuario;
    }
    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//

    //======================= OBTENER Usuario POR ID =========================//
    @Override
    public Usuario getUsuarioPorId(Long id) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(usuarioPorId);
            sentencia.setLong(1, id);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                if(rs.getString("tipo").equals("espectador")) {
                    return espectadorMapper(rs);
                } else if(rs.getString("tipo").equals("artista")) {
                    return artistaMapper(rs);
                }
            }
            throw new NoSuchElementException(String.format("Usuario con id %s no encontrado", id));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }

    //===================== OBTENER Usuario POR NICKNAME =====================//  
    @Override
    public Usuario getUsuarioPorNickName(String nickname) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(usuarioPorNickname);
            sentencia.setString(1, nickname);
            System.err.println(sentencia);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                if(rs.getString("tipo").equals("espectador")) {
                    return espectadorMapper(rs);
                } else if(rs.getString("tipo").equals("artista")) {
                    return artistaMapper(rs);
                }
            }
            throw new NoSuchElementException(String.format("Usuario con nickname %s no encontrado", nickname));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }

    //================== OBTENER LA LISTA DE TODOS LOS Espectadores ==============//
    @Override
    public List<Espectador> getTodosLosEspectadores() {
        List<Espectador> espectadores = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosEspectadores);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectadores.add(espectadorMapper(rs));
            }
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage(), e.getCause());
        }
        return espectadores;
    }
    //================== OBTENER LA LISTA DE TODOS LOS Artistas ==============//

    @Override
    public List<Artista> getTodosLosArtistas() {
        List<Artista> artistas = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosArtistas);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                artistas.add(artistaMapper(rs));
            }
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage(), e.getCause());
        }
        return artistas;
    }

    //============================= ALTA Usuario =============================//
    @Override
    public void altaUsuario(Usuario usuario) {

        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoUsuario);
            sentencia.setString(1, usuario.getNickname());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getApellido());
            sentencia.setString(4, usuario.getEmail());
            sentencia.setDate(5, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            sentencia.setString(6, usuario.getTipo());
            sentencia.executeUpdate();
            if (usuario instanceof Artista) {
                Artista artista = (Artista) usuario;
                sentencia = conexion.getConexion().prepareStatement(nuevoDatosArtista);
                sentencia.setString(1, artista.getNickname());
                sentencia.setString(2, artista.getDescripcion());
                sentencia.setString(3, artista.getBiografia());
                sentencia.setString(4, artista.getLinkUsuario());
                sentencia.executeUpdate();
            }
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe un usuario con el nickname [%s]", usuario.getNickname()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }
    //============================= ALTA ESPECTADOR =============================//

    //============================ MODIFICAR Usuario =========================//
    @Override
    public void modificarUsuario(Usuario usuario) {

        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(modificarUsuario);
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getApellido());
            sentencia.setDate(3, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            sentencia.setLong(4, usuario.getId());
            sentencia.executeUpdate();
            if (usuario instanceof Artista) {
                Artista artista = (Artista) usuario;
                sentencia = conexion.getConexion().prepareStatement(modificarDatosArtista);
                sentencia.setString(1, artista.getDescripcion());
                sentencia.setString(2, artista.getBiografia());
                sentencia.setString(3, artista.getLinkUsuario());
                sentencia.setString(4, artista.getNickname());
                sentencia.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }

    }
    //============================ MODIFICAR ESPECTADOR =========================//

    //========================= DEVUELVE EL ESPECTADOR =======================//
    private Espectador espectadorMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        return new Espectador(rs.getLong("id"), rs.getString("clave"), rs.getString("nickname"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("email"), fechaNacimiento);

    }
    //========================= DEVUELVE EL Artista =======================//

    private Artista artistaMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        Artista artista = new Artista(rs.getString("descripcion"), rs.getString("biografia"), rs.getString("linkUsuario"), rs.getLong("id"), rs.getString("clave"), rs.getString("nickname"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("email"), fechaNacimiento);
        return artista;
    }
}
