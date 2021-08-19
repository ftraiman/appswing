package edu.innova.logica.controladores;

import edu.innova.logica.entidades.Plataforma;
import java.util.List;

public interface PlataformaControlador {
    
   void altaPlataforma(Plataforma plataforma);
   
   List<Plataforma> getTodasLasPlataformas();
    
}
