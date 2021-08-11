package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioServicio {

    Usuario getUsuarioPorId(Long id) throws SQLException;

    Usuario getUsuarioPorNickName(String nickname) throws SQLException;

    List<Espectador> getTodosLosEspectadores() throws SQLException;

    List<Artista> getTodosLosArtistas() throws SQLException;

    void altaUsuario(Usuario usuario) throws SQLException;
    
    void modificarUsuario(Usuario usuario) throws SQLException;
}
