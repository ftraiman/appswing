package edu.innova.persistencia;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import edu.innova.exceptions.BaseDeDatosException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDB {

    static final String QUERY = "SELECT * FROM usuarios";
    private static Connection conexion;
    private static Properties prop = new Properties();
    
    public ConexionDB() {
        try {
            if (conexion == null || conexion.isClosed()) {
                String path = System.getProperty("user.dir");
                InputStream stream = new FileInputStream(path + File.separator + "params.txt");
                prop.load(stream);
                conexion = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("USER"), prop.getProperty("PASS"));
                System.err.println("Conexion exitosa a la DB");
            }
        } catch (CommunicationsException e) {
            throw new BaseDeDatosException(String.format("Error al conectar a la DB [%s]", e.getMessage()));
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage());
        } catch (IOException ex) {
            throw new BaseDeDatosException("Error al encontrar el archivo de configuracion");
        }
    }
    
    public Connection getConexion() {
        return conexion;
    }

    // Borrar esto despues
    @Deprecated
    public static void main(String[] args) {
        try {
            if (conexion == null || conexion.isClosed()) {
                String path = System.getProperty("user.dir");
                InputStream stream = new FileInputStream(path + File.separator + "params.txt");
                prop.load(stream);
                conexion = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("USER"), prop.getProperty("PASS"));
//                conexion = conn
//                conexion = conn.createStatement();
            }

            ResultSet rs = conexion.createStatement().executeQuery(QUERY);

            while (rs.next()) {

                System.out.println("ID: " + rs.getString("nickname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
