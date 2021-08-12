package edu.innova.logica.servicios.impl;

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

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String usuarioPorId = "SELECT * FROM usuarios WHERE id = ?";
    private final String usuarioPorNickname = "SELECT * FROM usuarios WHERE nickname = ?";
    private final String todosLosEspectadores = "SELECT * FROM usuarios WHERE tipo = 'espectador'";
    private final String todosLosArtistas = "SELECT * FROM usuarios WHERE tipo = 'artista'";
    private final String nuevoEspectador = "INSERT INTO usuarios (nickname, nombre, apellido, email, tipo, fechaNacimiento) VALUES(?, ?, ?, ?, ?, ?)";
    private final String nuevoArtista = "INSERT INTO usuarios (nickname, nombre, apellido, email, tipo, fechaNacimiento, descripcion, biografia, linkUsuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String modificarUsuario = "UPDATE usuarios SET nombre = ?, apellido = ?, fechaNacimiento = ?, linkUsuario = ?, descripcion = ?, biografia = ? WHERE id = ?";
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
    
    //======================= OBTENER USUARIO POR ID =========================//
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
    //======================= OBTENER USUARIO POR ID =========================//
    
    //===================== OBTENER USUARIO POR NICKNAME =====================//
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
    //===================== OBTENER USUARIO POR NICKNAME =====================//
    
    //================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//
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
    //================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//
    
    
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
        
    //============================= ALTA USUARIO =============================//
    @Override
    public void altaUsuario(Usuario usuario) throws SQLException {

        if (usuario instanceof Espectador) {
            Espectador espectador = (Espectador) usuario;
            try {
                
                
                PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoEspectador);
                sentencia.setString(1, espectador.getNickname());
                sentencia.setString(2, espectador.getNombre());
                sentencia.setString(3, espectador.getApellido());
                sentencia.setString(4, espectador.getEmail());
                sentencia.setString(5, espectador.getTipo());
                //Obtiene la fecha del sistema momentaneamente
                sentencia.setDate(6, new java.sql.Date(espectador.getFechaNacimiento().getTime()));
                sentencia.executeUpdate();
                
                
                /*PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoEspectador);
                
                sentencia.setString(1, espectador.getNickname());
                sentencia.setString(2, espectador.getNombre());
                sentencia.setString(3, espectador.getApellido());
                sentencia.setString(4, espectador.getEmail());
                sentencia.setString(5, espectador.getTipo());
                sentencia.setDate(6, new java.sql.Date(espectador.getFechaNacimiento().getTime()));
                sentencia.executeQuery();*/
            } catch (Exception e) {

            }
            
        } else if (usuario instanceof Artista) {
            Artista artista = (Artista) usuario;
            try {
                
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
                
                /*PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoArtista);
                sentencia.setString(1, artista.getNickname());
                sentencia.setString(2, artista.getNombre());
                sentencia.setString(3, artista.getApellido());
                sentencia.setString(4, artista.getEmail());
                sentencia.setString(5, artista.getTipo());
                sentencia.setDate(6, new java.sql.Date(artista.getFechaNacimiento().getTime()));
                sentencia.setString(7, artista.getDescripcion());
                sentencia.setString(8, artista.getBiografia());
                sentencia.setString(9, artista.getLinkUsuario());
                sentencia.executeQuery();*/
            } catch (Exception e) {
            }
            
        }
    }
    //============================= ALTA USUARIO =============================//
    
    //============================ MODIFICAR USUARIO =========================//
    public void modificarUsuario(Usuario usuario) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(modificarUsuario);

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
    //============================ MODIFICAR USUARIO =========================//
    
    
    //========================= DEVUELVE EL ESPECTADOR =======================//
    private Usuario espectadorMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        return new Espectador(rs.getLong("id"), rs.getString("nickname"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("email"), fechaNacimiento, rs.getString("tipo"));
    }
    //========================= DEVUELVE EL ESPECTADOR =======================//
    
    //============================ DEVOLVER UN ARTISTA =======================//
    private Usuario artistaMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        return new Artista(rs.getString("descripcion"), rs.getString("biografia"), rs.getString("linkUsuario"),
                rs.getLong("id"), rs.getString("nickname"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("email"), fechaNacimiento, rs.getString("tipo"));
    }
    //============================ DEVOLVER UN ARTISTA =======================//
}
