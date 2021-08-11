/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Plataforma;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author federico
 */
public interface PlataformaServicio {
    
    void altaPlataforma(Plataforma plataforma) throws SQLException;
    
    Plataforma getPlataformaPorId(Long idPlataforma) throws SQLException;
    
    List<Plataforma> getTodasLasPlataformas() throws SQLException;
    
}
