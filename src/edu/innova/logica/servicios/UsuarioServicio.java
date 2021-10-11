package edu.innova.logica.servicios;

import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioServicio {

    public UsuarioDTO getUsuarioDto(String nickname, String email, String clave);

    void altaUsuario(Usuario usuario);

    void altaUsuarioWeb(Usuario usuario);

    void modificarUsuario(Usuario usuario);

    List<Espectador> getTodosLosEspectadores();

    List<Artista> getTodosLosArtistas();

    Usuario getUsuarioPorId(Long id);

    Usuario getUsuarioPorNickName(String nickname);

    void seguirUsuario(Long idUsuarioSeguidor, Long idUsuarioSeguido);

    List<UsuarioDTO> usuariosQueSigue(Long idUsuarioSeguidor);

    List<UsuarioDTO> usuariosQueLoSiguen(Long idUsuarioSeguido);

    void dejarDeSeguir(Long idUsuarioSeguidor, Long idUsuarioSeguido);

    public List<UsuarioDTO> getTodosLosUsuarioDTO();
    
    public UsuarioDTO getUsuarioDTOPorId(Long id);
}

