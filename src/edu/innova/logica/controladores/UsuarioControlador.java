package edu.innova.logica.controladores;

import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import java.util.List;

public interface UsuarioControlador { //Interfaz usuario

    public UsuarioDTO getUsuarioDto(String nickname, String email, String clave);

    void altaUsuario(Usuario usuario); //Alta Usuario

    void altaUsuarioWeb(Usuario usuario); //Alta Usuario

    //En las interfaces de JAVA ya por defecto son publicos y abstracto
    void modificarUsuario(Usuario usuario);

    List<Espectador> getTodosLosEspectadores();

    List<Artista> getTodosLosArtistas();

    void crearUsuarioDTO(UsuarioDTO usuario);
    
    void seguirUsuario(Long idUsuarioSeguidor, Long idUsuarioSeguido);
    
    List<UsuarioDTO> usuariosQueSigue(Long idUsuarioSeguidor);
    
    List<UsuarioDTO> usuariosQueLoSiguen(Long idUsuarioSeguido);

    void dejarDeSeguir(Long idUsuarioSeguidor, Long idUsuarioSeguido);
    
    List<UsuarioDTO> getTodosLosUsuarioDTO();
    
    public UsuarioDTO getUsuarioDTOPorId(Long id);
    
    public void modificarUsuarioDTO(UsuarioDTO usuario);
}
