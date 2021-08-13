package edu.innova.logica.servicios.impl;

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
import edu.innova.logica.servicios.EspectadorServicio;

public class EspectadorServicioImpl implements EspectadorServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String espectadorPorId = "SELECT * FROM espectadores WHERE id = ?";
    private final String espectadorPorNickname = "SELECT * FROM espectadores WHERE nickname = ?";
    private final String todosLosEspectadores = "SELECT * FROM espectadores WHERE tipo = 'espectador'";
    private final String nuevoEspectador = "INSERT INTO espectadores (nickname, nombre, apellido, email, fechaNacimiento) VALUES(?, ?, ?, ?, ?)";
    private final String modificarUsuario = "UPDATE espectadores SET nombre = ?, apellido = ?, fechaNacimiento = ? WHERE id = ?";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//

    //INSTANCIA DE LA CLASE
    private static EspectadorServicioImpl servicioUsuario;

    private ConexionDB conexion = new ConexionDB();//OBTENER LA CONEXION A LA BASE DE DATOS

    public EspectadorServicioImpl() {//DEFAULT
    }

    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public EspectadorServicioImpl getInstance() {
        if (null == servicioUsuario) {
            servicioUsuario = new EspectadorServicioImpl();
        }
        return servicioUsuario;
    }
    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//

    //======================= OBTENER ESPECTADOR POR ID =========================//
    @Override
    public Usuario getUsuarioPorId(Long id) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectadorPorId);
        sentencia.setLong(1, id);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            return espectadorMapper(rs);
        }
        throw new NoSuchElementException(String.format("Usuario con id %s no encontrado", id));
    }
    //======================= OBTENER ESPECTADOR POR ID =========================//

    //===================== OBTENER ESPECTADOR POR NICKNAME =====================//
    @Override
    public Usuario getUsuarioPorNickName(String nickname) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectadorPorNickname);
        sentencia.setString(1, nickname);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            return espectadorMapper(rs);

        }
        throw new NoSuchElementException(String.format("Usuario con nickname %s no encontrado", nickname));
    }
    //===================== OBTENER ESPECTADOR POR NICKNAME =====================//

    //================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//
    @Override
    public List<Espectador> getTodosLosEspectadores() throws SQLException {
        List<Espectador> espectadores = new ArrayList<>();

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosEspectadores);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            espectadores.add(espectadorMapper(rs));
        }
        return espectadores;
    }
    //================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//

    //============================= ALTA ESPECTADOR =============================//
    @Override
    public void altaUsuario(Usuario usuario) throws SQLException {

        if (usuario instanceof Espectador) {
            Espectador espectador = (Espectador) usuario;
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoEspectador);
            sentencia.setString(1, espectador.getNickname());
            sentencia.setString(2, espectador.getNombre());
            sentencia.setString(3, espectador.getApellido());
            sentencia.setString(4, espectador.getEmail());
            //Obtiene la fecha del sistema momentaneamente
            sentencia.setDate(5, new java.sql.Date(espectador.getFechaNacimiento().getTime()));
            sentencia.executeUpdate();
        } else {
            throw new IllegalArgumentException("Estas tratando de guardar algo que no es un espectador");
        }
    }
    //============================= ALTA ESPECTADOR =============================//

    //============================ MODIFICAR ESPECTADOR =========================//
    public void modificarUsuario(Usuario usuario) throws SQLException {

        PreparedStatement sentencia = conexion.getConexion().prepareStatement(modificarUsuario);
        sentencia.setString(1, usuario.getNombre());
        sentencia.setString(2, usuario.getApellido());
        sentencia.setDate(3, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
        sentencia.setLong(4, usuario.getId());
        sentencia.executeUpdate();

    }
    //============================ MODIFICAR ESPECTADOR =========================//

    //========================= DEVUELVE EL ESPECTADOR =======================//
    private Espectador espectadorMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        return new Espectador(rs.getLong("id"), rs.getString("nickname"), rs.getString("nombre"),
                rs.getString("apellido"), rs.getString("email"), fechaNacimiento);
    }
    //========================= DEVUELVE EL ESPECTADOR =======================//
}
