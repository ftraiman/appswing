package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.Constantes;
import static edu.innova.logica.Constantes.ALGORITMO;
import static edu.innova.logica.Hash.getHash;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.logica.servicios.impl.UsuarioServicioImpl;
import java.util.List;

public class UsuarioControladorImpl implements UsuarioControlador {

    private static UsuarioControladorImpl instance;

    public UsuarioControladorImpl() {
    }//Constructor por defecto

    //Obtener la instancia
    public UsuarioControladorImpl getInstance() {
        if (null == instance) {
            instance = new UsuarioControladorImpl();
        }
        return instance;
    }

    //Obtener instancia de servicio usuario
    private final UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();

    @Override
    public UsuarioDTO getUsuarioDto(String nickname, String email, String clave) {
        try {
            return usuarioServicio.getUsuarioDto(nickname, email, clave);
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    //=========================== Alta de usuario ============================//
    @Override
    public void altaUsuario(Usuario usuario) {
        try {
            if (usuario instanceof Espectador) { //Si el Usuario es un Espectador

                Espectador espectador = (Espectador) usuario;
                validarParametrosEspectador(espectador); //Verificar que los datos no esten vacios o nulos
                usuarioServicio.altaUsuario(usuario); //Llama a servicio y muetsra
            } else if (usuario instanceof Artista) { //Si el Usuario es un Artista

                Artista artista = (Artista) usuario;
                validarParametrosArtista(artista); //Verificar que los datos no esten vacios o nulos
                usuarioServicio.altaUsuario(usuario);

            }
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(ex.getMessage(), ex.getCause());
        }
    }
    //=========================== Alta de usuario ============================//

    //=========================== Alta de usuario WEB============================//
    @Override
    public void altaUsuarioWeb(Usuario usuario) {
        try {
            if (usuario instanceof Espectador) { //Si el Usuario es un Espectador

                Espectador espectador = (Espectador) usuario;
                validarParametrosEspectadorWeb(espectador); //Verificar que los datos no esten vacios o nulos

                //=========== CAMBIA LA PASSWORD POR UNA HASH =============//
                String claveHash = getHash(usuario.getClave().getBytes(), ALGORITMO);
                usuario.setClave(claveHash);
                //=========== CAMBIA LA PASSWORD POR UNA HASH =============//

                usuarioServicio.altaUsuarioWeb(usuario); //Llama a servicio y muetsra

            } else if (usuario instanceof Artista) { //Si el Usuario es un Artista

                Artista artista = (Artista) usuario;
                validarParametrosArtistaWeb(artista); //Verificar que los datos no esten vacios o nulos

                //=========== CAMBIA LA PASSWORD POR UNA HASH =============//
                String claveHash = getHash(usuario.getClave().getBytes(), ALGORITMO);
                usuario.setClave(claveHash);
                //=========== CAMBIA LA PASSWORD POR UNA HASH =============//

                usuarioServicio.altaUsuarioWeb(usuario);
            }
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(ex.getMessage(), ex.getCause());
        }
    }
    //=========================== Alta de usuario WEB============================//

    @Override
    public void modificarUsuario(Usuario usuario) {
        try {
            if (usuario instanceof Espectador) {
                String claveHash = getHash(usuario.getClave().getBytes(), ALGORITMO);
                usuario.setClave(claveHash);

                Espectador espectador = (Espectador) usuario;
                validarParametrosModificarEspectador(espectador);
                usuarioServicio.modificarUsuario(espectador);

            } else if (usuario instanceof Artista) {
                String claveHash = getHash(usuario.getClave().getBytes(), ALGORITMO);
                usuario.setClave(claveHash);

                Artista artista = (Artista) usuario;
                validarParametrosModificarArtista(artista);
                usuarioServicio.modificarUsuario(artista);
            }
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Espectador> getTodosLosEspectadores() {
        try {
            return usuarioServicio.getTodosLosEspectadores();
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Artista> getTodosLosArtistas() {
        try {
            return usuarioServicio.getTodosLosArtistas();
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error SQL [%s]", ex.getMessage()));
        }
    }

    //=========================== Validar Datos ==============================//
    private void validarParametrosModificarEspectador(Espectador espectador) {
        HelperStrings.stringNoVacio(espectador.getNombre(), "nombre");
        HelperStrings.stringNoVacio(espectador.getApellido(), "apellido");
        HelperFecha.validarFechaAnteriorALaActual(espectador.getFechaNacimiento());
        HelperFecha.validarFecha18(espectador.getFechaNacimiento());
    }

    private void validarParametrosModificarArtista(Artista artista) {
        HelperStrings.stringNoVacio(artista.getNombre(), "nombre");
        HelperStrings.stringNoVacio(artista.getApellido(), "apellido");
        HelperFecha.validarFechaAnteriorALaActual(artista.getFechaNacimiento());

        HelperStrings.stringNoVacio(artista.getDescripcion(), "descripcion");
        HelperStrings.stringNoVacio(artista.getBiografia(), "biografia");
        HelperStrings.stringNoVacio(artista.getLinkUsuario(), "link");
        HelperStrings.urlValidator(artista.getLinkUsuario());
        HelperFecha.validarFecha18(artista.getFechaNacimiento());
    }

    private void validarParametrosEspectador(Espectador espectador) {
        HelperStrings.stringNoVacio(espectador.getNombre(), "nombre");
        HelperStrings.stringNoVacio(espectador.getApellido(), "apellido");
        HelperStrings.stringNoVacio(espectador.getNickname(), "nickname");
        HelperStrings.stringNoVacio(espectador.getEmail(), "email");
        HelperStrings.ValidarEmail(espectador.getEmail());
        HelperFecha.validarFechaAnteriorALaActual(espectador.getFechaNacimiento());
        HelperFecha.validarFecha18(espectador.getFechaNacimiento());
    }

    private void validarParametrosArtista(Artista artista) {
        HelperStrings.stringNoVacio(artista.getNombre(), "nombre");
        HelperStrings.stringNoVacio(artista.getApellido(), "apellido");
        HelperStrings.stringNoVacio(artista.getNickname(), "nickname");
        HelperStrings.stringNoVacio(artista.getEmail(), "email");
        HelperStrings.ValidarEmail(artista.getEmail());

        HelperStrings.stringNoVacio(artista.getDescripcion(), "descripcion");
        HelperStrings.stringNoVacio(artista.getBiografia(), "biografia");
        HelperStrings.stringNoVacio(artista.getLinkUsuario(), "link");
        HelperStrings.urlValidator(artista.getLinkUsuario());
        HelperFecha.validarFechaAnteriorALaActual(artista.getFechaNacimiento());
        HelperFecha.validarFecha18(artista.getFechaNacimiento());
    }

    private void validarParametrosEspectadorWeb(Espectador espectador) {
        HelperStrings.stringNoVacio(espectador.getNombre(), "nombre");
        HelperStrings.stringNoVacio(espectador.getApellido(), "apellido");
        HelperStrings.stringNoVacio(espectador.getNickname(), "nickname");
        HelperStrings.stringNoVacio(espectador.getEmail(), "email");
        HelperStrings.ValidarEmail(espectador.getEmail());
        HelperStrings.stringNoVacio(espectador.getClave(), "clave");
        HelperFecha.validarFechaAnteriorALaActual(espectador.getFechaNacimiento());
        HelperFecha.validarFecha18(espectador.getFechaNacimiento());
    }

    private void validarParametrosArtistaWeb(Artista artista) {
        HelperStrings.stringNoVacio(artista.getNombre(), "nombre");
        HelperStrings.stringNoVacio(artista.getApellido(), "apellido");
        HelperStrings.stringNoVacio(artista.getNickname(), "nickname");
        HelperStrings.stringNoVacio(artista.getEmail(), "email");
        HelperStrings.ValidarEmail(artista.getEmail());
        HelperStrings.stringNoVacio(artista.getClave(), "clave");

        HelperStrings.stringNoVacio(artista.getDescripcion(), "descripcion");
        HelperStrings.stringNoVacio(artista.getBiografia(), "biografia");
        HelperStrings.stringNoVacio(artista.getLinkUsuario(), "link");
        HelperStrings.urlValidator(artista.getLinkUsuario());
        HelperFecha.validarFechaAnteriorALaActual(artista.getFechaNacimiento());
        HelperFecha.validarFecha18(artista.getFechaNacimiento());
    }
    //=========================== Validar Datos ==============================//

    //===================== CREAR USUARIO A PARTIR DE UN DTO =================//
    @Override
    public void crearUsuarioDTO(UsuarioDTO usuarioDTO) {//INGRESAR EL USUARIO DTO EN LA BD
        Usuario usuario = null;//INSTANCIAR EL USER
        //SI ES ARTISTA
        if (Constantes.ARTISTA.equals(usuarioDTO.getTipo())) {
            usuario = crearArtistaConDTO(usuarioDTO);
            //SI ES ESPECTADOR
        } else if (Constantes.ESPECTADOR.equals(usuarioDTO.getTipo())) {
            usuario = crearEspectadorConDTO(usuarioDTO);
            //SI HAY ERROR
        } else {
            throw new InnovaModelException(String.format("Tipo de usuario [%s]", usuarioDTO.getTipo()));
        }
        //SI NO HAY PROBLEMAS Y SE CREO EL USUARIO SE LE DA ALTA
        if (usuario != null) {
            altaUsuarioWeb(usuario);
            //usuarioServicio.altaUsuario(usuario);
        }
    }

    @Override
    public void seguirUsuario(Long idUsuarioSeguidor, Long idUsuarioSeguido) {
        if (idUsuarioSeguido == null || idUsuarioSeguidor == null) {
            throw new InnovaModelException(String.format("Datos de ingreso invalidos [%s] [%s]", idUsuarioSeguidor, idUsuarioSeguido));
        }
        usuarioServicio.seguirUsuario(idUsuarioSeguidor, idUsuarioSeguido);
    }

    @Override
    public List<UsuarioDTO> usuariosQueSigue(Long idUsuarioSeguidor) {
        if (idUsuarioSeguidor == null) {
            throw new InnovaModelException("idUsuario inválido");
        }
        try {
            return usuarioServicio.usuariosQueSigue(idUsuarioSeguidor);
        } catch (BaseDeDatosException e) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", e.getMessage()));
        }
    }

    @Override
    public List<UsuarioDTO> usuariosQueLoSiguen(Long idUsuarioSeguido) {
        if (idUsuarioSeguido == null) {
            throw new InnovaModelException("idUsuario inválido");
        }
        try {
            return usuarioServicio.usuariosQueLoSiguen(idUsuarioSeguido);
        } catch (BaseDeDatosException e) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", e.getMessage()));
        }
    }

    public void dejarDeSeguir(Long idUsuarioSeguidor, Long idUsuarioSeguido) {
        if (idUsuarioSeguido == null || idUsuarioSeguidor == null) {
            throw new InnovaModelException("Parametros invalidos");
        }
        try {
            usuarioServicio.dejarDeSeguir(idUsuarioSeguidor, idUsuarioSeguido);
        } catch (BaseDeDatosException e) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", e.getMessage()));
        }
    }

    @Override
    public List<UsuarioDTO> getTodosLosUsuarioDTO() {
        return usuarioServicio.getTodosLosUsuarioDTO();
    }

    //CREAR UN ARTISTA CON UN DTO
    private Artista crearArtistaConDTO(UsuarioDTO usuario) {
        return new Artista(usuario.getDescripcion(), usuario.getBiografia(), usuario.getLinkUsuario(), usuario.getClave(), usuario.getNickname(),
                usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getFechaNacimiento(), usuario.getImagen());
    }

    //CREAR UN ESPECTADOR CON UN DTO
    private Espectador crearEspectadorConDTO(UsuarioDTO usuario) {
        return new Espectador(usuario.getClave(), usuario.getNickname(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(),
                usuario.getFechaNacimiento(), usuario.getImagen());
    }
    //===================== CREAR USUARIO A PARTIR DE UN DTO =================//

    //========================= MODIFICAR USUARIO CON DTO =====================//
    @Override
    public void modificarUsuarioDTO(UsuarioDTO usuario) { //MODIFICAR EL USUARIO CON UN DTO
       usuarioServicio.modificarUsuarioDTO(usuario);
    }
    //========================= MODIFICAR USUARIO CON DTO =====================//

    //============================= GET USUARIO DTO ==========================//
    @Override
    public UsuarioDTO getUsuarioDTOPorId(Long id) {
        try {
            return usuarioServicio.getUsuarioDTOPorId(id);
        } catch (BaseDeDatosException e) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", e.getMessage()));
        }
    }
    //============================= GET USUARIO DTO ==========================//
}
