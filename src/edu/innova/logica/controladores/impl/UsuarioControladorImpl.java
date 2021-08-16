package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.Fabrica;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import edu.innova.logica.servicios.ArtistaServicio;
import edu.innova.logica.servicios.EspectadorServicio;
import edu.innova.logica.servicios.impl.ArtistaServicioImpl;
import edu.innova.logica.servicios.impl.EspectadorServicioImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    private ArtistaServicio artistaServicio = new ArtistaServicioImpl().getInstance();
    private EspectadorServicio espectadorServicio = new EspectadorServicioImpl().getInstance();

    //=========================== Alta de usuario ============================//
    @Override
    public void altaUsuario(Usuario usuario) {
        Fabrica fabrica = new Fabrica();
        if (usuario instanceof Espectador) {
            try {
                int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Espectador??", "Confirmar Usuario Espectador", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    fabrica.getEspectadorServicioImpl().altaUsuario(usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "No se Agrego el Usuario Espectador");
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControladorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (usuario instanceof Artista) {
            try {
                int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Artista??", "Confirmar Usuario Artista", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    fabrica.getArtistaServicioImpl().altaUsuario(usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "No se Agrego el Usuario Artista");
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControladorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
//=========================== Alta de usuario ============================//
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        try {
            if (usuario instanceof Espectador) {
                Espectador espectador = (Espectador) usuario;
                validarParametrosModificarEspectador(espectador);
                espectadorServicio.modificarUsuario(espectador);
            } else if (usuario instanceof Artista) {
                Artista artista = (Artista) usuario;
                validarParametrosModificarArtista(artista);
                espectadorServicio.modificarUsuario(artista);
            }
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Espectador> getTodosLosEspectadores() {
        try {
            return espectadorServicio.getTodosLosEspectadores();
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Artista> getTodosLosArtistas() {
        try {
            return artistaServicio.getTodosLosArtistas();
        } catch (SQLException ex) {
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
