package edu.innova.logica.controladores;

import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Paquete;
import edu.innova.logica.entidades.Plataforma;
import java.util.List;

public interface PaqueteControlador {
    
    void altaPaquete(Paquete paquete);

    void altaPaqueteEspectaculo(Long IdPaquete, Long IDEspectaculos);
    
    List<Espectaculo> getEspectaculoNOPaquete(Plataforma plataformas,Paquete paquetes);
}
