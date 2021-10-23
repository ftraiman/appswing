package edu.innova.logica.servicios.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.logica.dtos.CanjeTresPorUnoDTO;
import edu.innova.logica.servicios.CanjeServicio;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.persistencia.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.innova.logica.servicios.UsuarioServicio;
import java.sql.Statement;

public class CanjeServicioImpl implements CanjeServicio {

    private final String altaCanjeTresPorUno = "INSERT INTO canjes_tres_por_uno (idUsuario, idFuncionObtenida, funcionesCanjeadas, fechaRegistro) VALUES (?, ?, ?, NOW())";
    private final String altaEspectaculoPaqueteUtilizado = "INSERT INTO paquetes_espectaculos_utilizados (idUsuario, idPaquete, idEspectaculo) VALUES (?, ?, ?)";
    
    private static CanjeServicioImpl instancia;
    
    private ConexionDB conexion = new ConexionDB();
    private UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();
    private PlataformaServicio plataformaServicio = new PlataformaServicioImpl().getInstance();
    private FuncionServicio funcionServicio = new FuncionServicioImpl().getInstance();

    public CanjeServicioImpl() {
    }

    public static CanjeServicioImpl getInstance() {
        if (null == instancia) {
            instancia = new CanjeServicioImpl();
        }
        return instancia;
    }

    @Override
    public void altaCanjeTresPorUno(CanjeTresPorUnoDTO canje) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(altaCanjeTresPorUno, Statement.RETURN_GENERATED_KEYS);
            sentencia.setLong(1, canje.getIdUsuario());
            sentencia.setLong(2, canje.getIdFuncionObtenida());
            sentencia.setString(3, canje.getFuncionesCanjeadas());
            sentencia.executeUpdate();
            Long idGenerado = null;
            ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getLong(1);
            }
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }

    @Override
    public void altaEspectaculoPaqueteUtilizado(Long idUsuario,Long idPaquete, Long idEspectaculo) {
        PreparedStatement sentencia;
        try {
            sentencia = conexion.getConexion().prepareStatement(altaEspectaculoPaqueteUtilizado);
            sentencia.setLong(1, idUsuario);
            sentencia.setLong(2, idPaquete);
            sentencia.setLong(3, idEspectaculo);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }
}
