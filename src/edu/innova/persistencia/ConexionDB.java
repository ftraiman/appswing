package edu.innova.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConexionDB {

    static final String QUERY = "SELECT * FROM tasks";
    private static Statement conexion;
    private static Properties prop = new Properties();
    
    public ConexionDB() {
        try {
            if (conexion == null || conexion.isClosed()) {
                String path = System.getProperty("user.dir");
                InputStream stream = new FileInputStream(path + File.separator + "params.txt");
                prop.load(stream);
                Connection conn = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("USER"), prop.getProperty("PASS"));
                conexion = conn.createStatement();
                System.err.println("Conexion exitosa a la DB");
            }
        } catch (Exception e) {
            System.err.println("Error al conectar a la DB");
            e.printStackTrace();
        }
    }
    
    public Statement getConexion() {
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
                Connection conn = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("USER"), prop.getProperty("PASS"));
                conexion = conn.createStatement();
            }

            ResultSet rs = conexion.executeQuery(QUERY);

            while (rs.next()) {

                System.out.println("ID: " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
