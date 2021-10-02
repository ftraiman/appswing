package edu.innova.logica.servicios.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.servicios.DtoServicio;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.NoSuchElementException;

public class DtoServicioImpl implements DtoServicio {

//INSTANCIA DE LA CLASE
    private static DtoServicioImpl servicioDto;

    private ConexionDB conexion = new ConexionDB();//OBTENER LA CONEXION A LA BASE DE DATOS   

    public DtoServicioImpl() {//DEFAULT
    }

    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public DtoServicioImpl getInstance() {
        if (null == servicioDto) {
            servicioDto = new DtoServicioImpl();
        }
        return servicioDto;
    }

//====================== CONSULTAS PARA LA BASE DE DATOS =====================//
//private final String BuscarUsuarioParaDto = "SELECT * FROM usuarios AS U, datos_artistas AS DA WHERE U.nickname = ? AND U.email = ? AND U.clave = ? AND DA.nickname = U.nickname;";
    private final String BuscarUsuarioParaDto = "SELECT * FROM usuarios U LEFT JOIN datos_artistas DA ON U.nickname = DA.nickname WHERE (U.nickname = ? OR U.email = ?) AND U.clave = ?";

//====================== CONSULTAS PARA LA BASE DE DATOS =====================//
    //======================= BUSCAR Usuario PARA DTO =========================//
    
    //TODO insert de nuevo espectador o artista
    //TODO update de espectador o artista
    
    @Override
    public UsuarioDTO getUsuarioDto(String nickname, String email, String clave) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(BuscarUsuarioParaDto);
            sentencia.setString(1, nickname);
            sentencia.setString(2, email);
            sentencia.setString(3, clave);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                if (rs.getString("tipo").equals("espectador")) {
                    return DtoEspectadorMapper(rs);
                } else if (rs.getString("tipo").equals("artista")) {
                    return DtoArtistaMapper(rs);
                }
            }
            return null;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }
    //======================= BUSCAR Usuario PARA DTO =========================//

    //========================= MAPPERS DE DTO USUARIOS =======================//
    private UsuarioDTO DtoArtistaMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        UsuarioDTO artista = new UsuarioDTO(rs.getString("tipo"), rs.getString("nickname"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), fechaNacimiento, rs.getString("descripcion"), rs.getString("biografia"), rs.getString("linkUsuario"));
        return artista;
    }

    private UsuarioDTO DtoEspectadorMapper(ResultSet rs) throws SQLException {
        Date fechaNacimiento = rs.getTimestamp("fechaNacimiento");
        UsuarioDTO espectador = new UsuarioDTO(rs.getString("tipo"), rs.getString("nickname"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), fechaNacimiento);
        return espectador;
    }
    //========================= MAPPERS DE DTO USUARIOS =======================//
}
