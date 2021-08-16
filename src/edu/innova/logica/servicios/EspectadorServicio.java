package edu.innova.logica.servicios;

import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public interface EspectadorServicio {

    public Usuario getUsuarioPorId(Long id) throws SQLException;

    public Usuario getUsuarioPorNickName(String nickname) throws SQLException;

    public List<Espectador> getTodosLosEspectadores();

    public void altaUsuario(Usuario usuario) throws SQLException;

    public void modificarUsuario(Usuario usuario);

}
