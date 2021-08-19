package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.logica.servicios.impl.UsuarioServicioImpl;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioControladorImpl implements UsuarioControlador {

    private static UsuarioControladorImpl instance;

    public UsuarioControladorImpl() {}//Constructor por defecto

    //Obtener la instancia
    public UsuarioControladorImpl getInstance() {
        if (null == instance) {
            instance = new UsuarioControladorImpl();
        }
        return instance;
    }

    //Obtener instancia de usuario
    private UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();

    //=========================== Alta de usuario ============================//
    @Override
    public void altaUsuario(Usuario usuario) {
        try {
            if (usuario instanceof Espectador) {

                int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Espectador??", "Confirmar Usuario Espectador", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    usuarioServicio.altaUsuario(usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "No se Agrego el Usuario Espectador");
                }
            } else if (usuario instanceof Artista) {

                int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Artista??", "Confirmar Usuario Artista", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    usuarioServicio.altaUsuario(usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "No se Agrego el Usuario Artista");
                }
            }
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(ex.getMessage(), ex.getCause());
        }
//=========================== Alta de usuario ============================//
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        try {
            if (usuario instanceof Espectador) {
                Espectador espectador = (Espectador) usuario;
                validarParametrosModificarEspectador(espectador);
                usuarioServicio.modificarUsuario(espectador);
            } else if (usuario instanceof Artista) {
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

    private void validarParametrosModificarEspectador(Espectador espectador) {
        HelperStrings.stringNoVacio(espectador.getNombre(), "nombre");
        HelperStrings.stringNoVacio(espectador.getApellido(), "apellido");
        HelperFecha.validarFechaAnteriorALaActual(espectador.getFechaNacimiento());
    }

    private void validarParametrosModificarArtista(Artista artista) {
        HelperStrings.stringNoVacio(artista.getNombre(), "nombre");
        HelperStrings.stringNoVacio(artista.getApellido(), "apellido");
        HelperFecha.validarFechaAnteriorALaActual(artista.getFechaNacimiento());
        //TODO averiguar si hay que validar la biografia o la descripcion
    }

}
