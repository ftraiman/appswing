/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.datos.basededatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author federico
 */
public class DataBaseService {

    static final String QUERY = "SELECT * FROM tasks";
    private static Statement stmt;
    private static Properties prop = new Properties();

    public static void main(String[] args) {
        try {
            if (stmt == null || stmt.isClosed()) {
                String path = System.getProperty("user.dir");
                InputStream stream = new FileInputStream(path + File.separator + "params.txt");
                prop.load(stream);
                Connection conn = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("USER"), prop.getProperty("PASS"));
                stmt = conn.createStatement();
            }

            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {

                System.out.println("ID: " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
