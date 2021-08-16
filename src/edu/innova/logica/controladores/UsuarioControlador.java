/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.logica.controladores;

import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import java.util.List;

/**
 *
 * @author federico
 */
public interface UsuarioControlador  {
    
    public abstract void altaUsuario(Usuario usuario);
    
    void modificarUsuario(Usuario usuario);
    
    List<Espectador> getTodosLosEspectadores();
    
}
