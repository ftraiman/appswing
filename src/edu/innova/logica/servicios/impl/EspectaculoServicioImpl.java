package edu.innova.logica.servicios.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.dtos.EspectaculoDTO;
import edu.innova.logica.dtos.FuncionDTO;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Categoria;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.persistencia.ConexionDB;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import edu.innova.logica.servicios.UsuarioServicio;

public class EspectaculoServicioImpl implements EspectaculoServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String altaEspectaculo = "INSERT INTO espectaculos (nombre,costo,url,duracion,descripcion,fechaRegistro,idUsuario,idPlataforma,espectadoresMinimos,espectadoresMaximos,idCategoria,estado,imagen) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String altaCategoria = "INSERT INTO categorias (nombre) VALUES (?)";
    private final String todosLosEspectaculos = "SELECT * FROM espectaculos";
    private final String todosLosEspectaculosPorIdPlataforma = "SELECT * FROM espectaculos WHERE idPlataforma = ? AND estado = 'Aceptado'";
    private final String espectaculoPorId = "SELECT * FROM espectaculos WHERE id = ?";
    private final String espectaculoPorIdA = "SELECT * FROM espectaculos WHERE idUsuario = ?";
    private final String todasLasCategorias = "SELECT * FROM categorias";
    private final String todosLosEspectaculosIngresados = "SELECT * FROM espectaculos WHERE estado = 'Ingresado'";
    private final String aceptarEspectaculo = "UPDATE espectaculos SET estado = 'Aceptado' WHERE espectaculos.id = ?";
    private final String rechazarEspectaculo = "UPDATE espectaculos SET estado = 'Rechazado' WHERE espectaculos.id = ?";
    private final String categoriasPorIdEspectaculo = "SELECT C.id, C.nombre FROM categorias AS C, espectaculos AS E WHERE C.id = E.idCategoria AND E.id = ?";
    private final String buscarEspectaculoDTO = "SELECT * FROM espectaculos E WHERE EXISTS(SELECT * FROM funciones F WHERE ((E.idPlataforma = ? OR E.idCategoria = ?) OR (E.idPlataforma = ? AND E.idCategoria = ?)) AND E.id = F.idEspectaculo AND E.estado = 'Aceptado')";
    private final String buscarEspectaculoDTOCategoria = "SELECT * FROM espectaculos e WHERE e.idCategoria = ? AND e.estado = 'Aceptado'";
    private final String buscarEspectaculoDTOPlataforma = "SELECT * FROM espectaculos e WHERE e.idPlataforma = ? AND e.estado = 'Aceptado'";
    private final String espectaculoPorNombre = "SELECT * FROM espectaculos WHERE nombre = ?";
    private final String buscarEspectaculoDTOCategoriaPlataforma = "SELECT * FROM espectaculos e WHERE e.idCategoria = ? AND e.idPlataforma = ? AND e.estado = 'Aceptado'";
    private final String espectaculosNoIncluidosEnPaquete = "SELECT e.* FROM espectaculos e LEFT JOIN paquetes_espectaculos pe on e.id = pe.idEspectaculo WHERE idUsuario = ? AND e.estado = 'aceptado' AND NOT EXISTS(SELECT * FROM paquetes_espectaculos pe WHERE pe.idEspectaculo = e.id\n"
            + "AND pe.idPaquete = ?)";

    //private final String altaEspectaculoDTO 
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    //INSTANCIA DE LA CLASE
    private static EspectaculoServicioImpl servicio;

    //OBTENER LA CONEXION A LA BASE DE DATOS
    private ConexionDB conexion = new ConexionDB();

    private UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();
    private PlataformaServicio plataformaServicio = new PlataformaServicioImpl().getInstance();
    private FuncionServicio funcionServicio = new FuncionServicioImpl().getInstance();

    public EspectaculoServicioImpl() {//DEFAULT
    }

    //========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public EspectaculoServicioImpl getInstance() {
        if (null == servicio) {
            servicio = new EspectaculoServicioImpl();
        }
        return servicio;
    }

    //==================== AlTA DE ESPECTACULO ===================//
    @Override
    public void altaEspectaculo(Long idArtista, Long idPlataforma, Espectaculo espectaculo) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaEspectaculo);
            sentencia.setString(1, espectaculo.getNombre());
            sentencia.setBigDecimal(2, espectaculo.getCosto());
            sentencia.setString(3, espectaculo.getUrl());
            sentencia.setInt(4, espectaculo.getDuracion());
            sentencia.setString(5, espectaculo.getDescripcion());
            sentencia.setDate(6, new java.sql.Date(espectaculo.getFechaRegistro().getTime()));
            sentencia.setLong(7, idArtista);
            sentencia.setLong(8, idPlataforma);
            sentencia.setInt(9, espectaculo.getEspectadoresMinimos());
            sentencia.setInt(10, espectaculo.getEspectadoresMaximos());
            sentencia.setLong(11, espectaculo.getIdCategoria());
            sentencia.setString(12, espectaculo.getEstado());
            sentencia.setString(13, espectaculo.getImagen());

            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe un espectaculo con el nombre [%s]", espectaculo.getNombre()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }

    }
    //==================== AlTA DE ESPECTACULO ===================//

    //==================== AlTA DE CATEGORIA ===================//
    @Override
    public void altaCategoria(String nombre) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaCategoria);
            sentencia.setString(1, nombre);
            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe una Categoria con el nombre [%s]", nombre));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }

    }
    //==================== AlTA DE CATEGORIA ===================//

    //==================== OBTENER ESPECTACULO POR ID ============//
    @Override
    public Espectaculo getEspectaculoPorId(Long idEspectaculo) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectaculoPorId);
            sentencia.setLong(1, idEspectaculo);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return espectaculoMapper(rs);
            }
            throw new NoSuchElementException(String.format("Espectaculo con id %s no encontrado", idEspectaculo));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }
    //==================== OBTENER ESPECTACULO POR ID ============//

    //==================== OBTENER CATEGORIA POR ID ============//
    @Override
    public List<Categoria> getCategoriaPorIdEspectaculo(Long idEspectaculo) throws SQLException {
        try {
            List<Categoria> categorias = new ArrayList<>();
            ResultSet rs;
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(categoriasPorIdEspectaculo);
            sentencia.setLong(1, idEspectaculo);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                categorias.add(categoriaMapper(rs));
            }
            return categorias;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }
    //==================== OBTENER CATEGORIA POR ID ============//

    //==================== OBTENER ESPECTACULO POR ID Arista============//
    @Override
    public List<Espectaculo> getEspectaculosPorIdArtista(Long idArtista) {
        List<Espectaculo> espectaculos = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectaculoPorIdA);
            sentencia.setLong(1, idArtista);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectaculos.add(espectaculoMapper(rs));
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL %s", ex.getMessage()));
        }
        return espectaculos;
    }

    //==================== OBTENER ESPECTACULO POR ID Artista============//
    //==================== OBTENER TODOS LOS ESPECTACULOS=========//
    @Override
    public List<Espectaculo> getTodosLosEspectaculos() throws SQLException {
        List<Espectaculo> espectaculos = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosEspectaculos);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            espectaculos.add(espectaculoMapper(rs));
        }
        return espectaculos;
    }
    //==================== OBTENER TODOS LOS ESPECTACULOS=========//

    @Override
    public List<Espectaculo> getTodosLosEspectaculosPorPlataforma(Long idPlataforma) {
        try {
            List<Espectaculo> espectaculos = new ArrayList<>();
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosEspectaculosPorIdPlataforma);
            sentencia.setLong(1, idPlataforma);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectaculos.add(espectaculoMapper(rs));
            }
            return espectaculos;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }

    //==================== OBTENER TODOS LOS ESPECTACULOS "INGRESADO"=========//
    @Override
    public List<Espectaculo> getTodosLosEspectaculosIngresados() throws SQLException {
        try {
            List<Espectaculo> espectaculos = new ArrayList<>();
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosEspectaculosIngresados);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectaculos.add(espectaculoMapper(rs));
            }
            return espectaculos;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }

    //==================== OBTENER TODAS LAS CATEGORIAS=======================//
    @Override
    public List<Categoria> getTodasLasCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        ResultSet rs;
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todasLasCategorias);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                categorias.add(categoriaMapper(rs));
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }

        return categorias;
    }

    //==================== OBTENER TODAS LAS CATEGORIAS=======================//
    private Espectaculo espectaculoMapper(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        Integer duracion = rs.getInt("duracion");
        Integer espectadoresMinimos = rs.getInt("espectadoresMinimos");
        Integer espectadoresMaximos = rs.getInt("espectadoresMaximos");
        String url = rs.getString("url");
        BigDecimal costo = rs.getBigDecimal("costo");
        Date fechaRegistro = rs.getTimestamp("fechaRegistro");
        Artista artista = (Artista) usuarioServicio.getUsuarioPorId(rs.getLong("idUsuario"));
        Plataforma plataforma = plataformaServicio.getPlataformaPorId(rs.getLong("idPlataforma"));
        Long idCategoria = rs.getLong("idCategoria");
        String estado = rs.getString("estado");
        String imagen = rs.getString("imagen");

        List<Funcion> funciones = funcionServicio.getTodosLasFuncionesPorIdEspectaculo(id);

        return new Espectaculo(id, artista, nombre, plataforma, descripcion, duracion, espectadoresMinimos, espectadoresMaximos, url, costo, fechaRegistro, funciones, idCategoria, estado, imagen);
    }

    private Categoria categoriaMapper(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");

        return new Categoria(id, nombre);
    }

    //====================== ACEPTAR ESPECTACULO =============================== 
    @Override
    public void aceptarEspectaculo(Long id) {

        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(aceptarEspectaculo);
            sentencia.setString(1, id.toString());
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }
    //====================== ACEPTAR ESPECTACULO ===============================

    //====================== RECHAZAR ESPECTACULO =============================== 
    @Override
    public void rechazarEspectaculo(Long id) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(rechazarEspectaculo);
            sentencia.setString(1, id.toString());
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }
    //====================== RECHAZAR ESPECTACULO ==============================

    //==================== OBTENER ESPECTACULO POR ID ============//
    @Override
    public EspectaculoDTO getEspectaculoPorIdDTO(Long idEspectaculo) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectaculoPorId);
            sentencia.setLong(1, idEspectaculo);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return espectaculoMapperDTO(rs);
            }
            return null;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }
    //==================== OBTENER ESPECTACULO POR ID ============//

    //===================== OBTENER ESPECTACULOS DTO ==========================//
    @Override
    public List<EspectaculoDTO> getTodosLosEspectaculosDTO() throws SQLException {
        List<EspectaculoDTO> espectaculos = new ArrayList<>();
        PreparedStatement sentencia = conexion.getConexion().prepareStatement(todosLosEspectaculos);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            espectaculos.add(espectaculoMapperDTO(rs));
        }
        return espectaculos;
    }
    //===================== OBTENER ESPECTACULOS DTO ==========================//

    @Override
    public List<EspectaculoDTO> getEspectaculosDTONoIncluidosEnPaquete(Long idArtista, Long idPaquete) {
        List<EspectaculoDTO> espectaculos = new ArrayList<>();
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(espectaculosNoIncluidosEnPaquete);
            sentencia.setLong(1, idArtista);
            sentencia.setLong(2, idPaquete);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectaculos.add(espectaculoMapperDTO(rs));
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }

        return espectaculos;
    }

    //=============== OBTENER ESPECTACULOS POR ID ARTISTA DTO ================//
    @Override
    public List<EspectaculoDTO> getTodosLosEspectaculosPorArtistaDTO(Long idArtista) {
        try {
            List<EspectaculoDTO> espectaculos = new ArrayList<>();
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectaculoPorIdA);
            sentencia.setLong(1, idArtista);

            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                espectaculos.add(espectaculoMapperDTO(rs));
            }
            return espectaculos;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }
    //=============== OBTENER ESPECTACULOS POR ID ARTISTA DTO ================//

    //======================= MAPPER ESPECTACULO DTO =========================//
    private EspectaculoDTO espectaculoMapperDTO(ResultSet rs) throws SQLException {

        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        Integer duracion = rs.getInt("duracion");
        Integer espectadoresMinimos = rs.getInt("espectadoresMinimos");
        Integer espectadoresMaximos = rs.getInt("espectadoresMaximos");
        String url = rs.getString("url");
        BigDecimal costo = rs.getBigDecimal("costo");
        Date fechaRegistro = rs.getTimestamp("fechaRegistro");
        Long idArtista = rs.getLong("idUsuario");
        Long idPlataforma = rs.getLong("idPlataforma");
        //Artista artista = (Artista) usuarioServicio.getUsuarioPorId(rs.getLong("idUsuario"));
        //Plataforma plataforma = plataformaServicio.getPlataformaPorId(rs.getLong("idPlataforma"));
        Long idCategoria = rs.getLong("idCategoria");
        String estado = rs.getString("estado");
        String imagen = rs.getString("imagen");

        List<FuncionDTO> funciones = funcionServicio.getFuncionesPorIdEspectaculoDTO(id);

        return new EspectaculoDTO(id, idArtista, nombre, idPlataforma, descripcion, duracion, espectadoresMinimos, espectadoresMaximos, url, costo, fechaRegistro, funciones, estado, idCategoria, imagen);
    }
    //======================= MAPPER ESPECTACULO DTO =========================//

    //==================== AlTA DE ESPECTACULO DTO ===================//
    @Override
    public void altaEspectaculoDTO(EspectaculoDTO espectaculo) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaEspectaculo);
            sentencia.setString(1, espectaculo.getNombre());
            sentencia.setBigDecimal(2, espectaculo.getCosto());
            sentencia.setString(3, espectaculo.getUrl());
            sentencia.setInt(4, espectaculo.getDuracion());
            sentencia.setString(5, espectaculo.getDescripcion());
            sentencia.setDate(6, new java.sql.Date(espectaculo.getFechaRegistro().getTime()));
            sentencia.setLong(7, espectaculo.getIdArtista());
            sentencia.setLong(8, espectaculo.getIdPlataforma());
            sentencia.setInt(9, espectaculo.getEspectadoresMinimos());
            sentencia.setInt(10, espectaculo.getEspectadoresMaximos());
            sentencia.setLong(11, espectaculo.getIdCategoria());
            sentencia.setString(12, espectaculo.getEstado());
            sentencia.setString(13, espectaculo.getImagen());

            sentencia.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new InnovaModelException(String.format("Ya existe un espectaculo con el nombre [%s]", espectaculo.getNombre()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }

    }
    //==================== AlTA DE ESPECTACULO DTO ===================//

    //==================== OBTENER ESPECTACULO DTO ============//
    @Override
    public List<EspectaculoDTO> buscarEspectaculosDTO(Long idPlataforma, Long idCategoria) {
        try {
            List<EspectaculoDTO> espectaculos = new ArrayList<>();

            PreparedStatement sentencia = null;
            if (idPlataforma != null && idCategoria != null) {
                sentencia = conexion.getConexion().prepareStatement(buscarEspectaculoDTOCategoriaPlataforma);
                sentencia.setLong(1, idCategoria);
                sentencia.setLong(2, idPlataforma);
            } else if (idPlataforma != null && idCategoria == null) {
                sentencia = conexion.getConexion().prepareStatement(buscarEspectaculoDTOPlataforma);
                sentencia.setLong(1, idPlataforma);
            } else if (idPlataforma == null && idCategoria != null) {
                sentencia = conexion.getConexion().prepareStatement(buscarEspectaculoDTOCategoria);
                sentencia.setLong(1, idCategoria);
            }
            if (sentencia != null) {
                ResultSet rs = sentencia.executeQuery();
                while (rs.next()) {
                    espectaculos.add(espectaculoMapperDTO(rs));
                }
            }
            return espectaculos;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }
    //==================== OBTENER ESPECTACULO DTO ============//
    
    //==================== OBTENER ESPECTACULO POR Nombre ============//
    @Override
    public EspectaculoDTO getEspectaculoPorNombre(String nombre) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(espectaculoPorNombre);
            sentencia.setString(1, nombre);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return espectaculoMapperDTO(rs);
            }
            return null;
            //throw new NoSuchElementException(String.format("Espectaculo con id %s no encontrado", nombre));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }
    //==================== OBTENER ESPECTACULO POR Nombre ============//
}
