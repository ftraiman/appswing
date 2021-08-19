package edu.innova.logica.controladores;

import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import java.util.List;

public interface UsuarioControlador  { //Interfaz usuario
    
    
    public abstract void altaUsuario(Usuario usuario); //Alta Usuario
    
    public abstract void modificarUsuario(Usuario usuario); //Modificar Usuario
    //void modificarUsuario(Usuario usuario); 
    
    List<Espectador> getTodosLosEspectadores();

    public List<Artista> getTodosLosArtistas();
    
}
