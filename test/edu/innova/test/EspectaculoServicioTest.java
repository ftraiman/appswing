package edu.innova.test;

import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.impl.EspectaculoServicioImpl;
import java.sql.SQLException;

public class EspectaculoServicioTest {

    public static void main(String[] args) throws SQLException {
        
        EspectaculoServicio espectaculoServicio = new EspectaculoServicioImpl().getInstance();
        
//        // Alta Espectaculo
        
//        Espectaculo espectaculo = new Espectaculo("NTVG", "En el teatro de verano", 90, 1500, "www.ntcg.com", BigDecimal.valueOf(450), new Date());
//        espectaculoServicio.altaEspectaculo(Long.valueOf(21),Long.valueOf(3), espectaculo);
//        
//        //Obtener todos los Espectaculos
//        espectaculoServicio.getTodosLosEspectaculos().forEach(e -> System.err.println(e));
        
        // Obtener espectaculo por id
        Espectaculo e = espectaculoServicio.getEspectaculoPorId(Long.valueOf(1));
        System.err.println(espectaculoServicio.getEspectaculoPorId(Long.valueOf(1)));



    }

}
