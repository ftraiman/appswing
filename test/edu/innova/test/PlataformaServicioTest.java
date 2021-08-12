package edu.innova.test;

import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.logica.servicios.impl.PlataformaServicioImpl;
import java.sql.SQLException;

public class PlataformaServicioTest {

    public static void main(String[] args) throws SQLException {
        PlataformaServicio plataformaServicio = new PlataformaServicioImpl().getInstance();
        
//        // Alta Plataforma
//        plataformaServicio.altaPlataforma(new Plataforma(null, "Facebook", "Feisbuk", "www.facebook.com"));
        
//          // Obtener plataforma por Id
//          System.err.println(plataformaServicio.getPlataformaPorId(Long.valueOf(3)));

//          // Obtener Todas las plataformas
//            plataformaServicio.getTodasLasPlataformas().forEach(p-> System.err.println(p));



    }

}
