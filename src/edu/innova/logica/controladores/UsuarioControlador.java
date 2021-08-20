package edu.innova.logica.controladores;

import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import java.util.List;

public interface UsuarioControlador  { //Interfaz usuario
   
    
    void altaUsuario(Usuario usuario); //Alta Usuario
    
    //En las interfaces de JAVA ya por defecto son publicos y abstracto
    void modificarUsuario(Usuario usuario); 
    
    List<Espectador> getTodosLosEspectadores();

    List<Artista> getTodosLosArtistas();
    
}
