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

    //Obtener instancia de servicio usuario
    private UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();

    //=========================== Alta de usuario ============================//
    @Override
    public void altaUsuario(Usuario usuario) {
        try {
            if (usuario instanceof Espectador) { //Si el Usuario es un Espectador
                
                Espectador espectador = (Espectador) usuario;
                validarParametrosEspectador(espectador); //Verificar que los datos no esten vacios o nulos
                
                int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Espectador??", "Confirmar Usuario Espectador", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) { //Si confirma el alta
                    usuarioServicio.altaUsuario(usuario); //Llama a servicio y muetsra
                    JOptionPane.showMessageDialog(null, "El Espectador fue ingresado correctamente");
                } 
                else { //Si no agrega muestra
                    JOptionPane.showMessageDialog(null, "No se Agrego el Usuario Espectador");
                }
            } 
            else if (usuario instanceof Artista) { //Si el Usuario es un Artista
                
                Artista artista = (Artista) usuario;
                validarParametrosArtista(artista); //Verificar que los datos no esten vacios o nulos
                
                int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Artista??", "Confirmar Usuario Artista", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    usuarioServicio.altaUsuario(usuario);
                    JOptionPane.showMessageDialog(null, "El Artista fue ingresado correctamente");
                } 
                else {
                    JOptionPane.showMessageDialog(null, "No se Agrego el Usuario Artista");
                }
            }
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(ex.getMessage(), ex.getCause());
        }
    }
    //=========================== Alta de usuario ============================//

    @Override
    public void modificarUsuario(Usuario usuario) {
        try {
            if (usuario instanceof Espectador) {
               
                Espectador espectador = (Espectador) usuario;
                validarParametrosModificarEspectador(espectador);
                
                int i = JOptionPane.showConfirmDialog(null, "Desea Modificar este Espectador??", "Confirmar Cambios Espectador", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) { //Si confirma el alta
                    usuarioServicio.modificarUsuario(espectador);
                    JOptionPane.showMessageDialog(null, "El Espectador fue modificado correctamente");
                } 
                else { //Si no agrega muestra
                    JOptionPane.showMessageDialog(null, "No se Modifico el Usuario Espectador");
                }

            } else if (usuario instanceof Artista) {
                
                Artista artista = (Artista) usuario;
                validarParametrosModificarArtista(artista);
                
                
                int i = JOptionPane.showConfirmDialog(null, "Desea Modificar este Artista??", "Confirmar Cambios Artista", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) { //Si confirma el alta
                    usuarioServicio.modificarUsuario(artista);
                    JOptionPane.showMessageDialog(null, "El Artista fue modificado correctamente");
                } 
                else { //Si no agrega muestra
                    JOptionPane.showMessageDialog(null, "No se Modifico el Usuario Artista");
                }
                
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
    }

      private void validarParametrosModificarArtista(Artista artista) {
        HelperStrings.stringNoVacio(artista.getNombre(), "nombre");
        HelperStrings.stringNoVacio(artista.getApellido(), "apellido");
        HelperFecha.validarFechaAnteriorALaActual(artista.getFechaNacimiento());
        
        HelperStrings.stringNoVacio(artista.getDescripcion(), "descripcion");
        HelperStrings.stringNoVacio(artista.getBiografia(), "biografia");
        HelperStrings.stringNoVacio(artista.getLinkUsuario(), "link");
        HelperStrings.urlValidator(artista.getLinkUsuario());
    }
    
    private void validarParametrosEspectador(Espectador espectador) {
        HelperStrings.stringNoVacio(espectador.getNombre(), "nombre");
        HelperStrings.stringNoVacio(espectador.getApellido(), "apellido");
        HelperStrings.stringNoVacio(espectador.getNickname(), "nickname");
        HelperStrings.stringNoVacio(espectador.getEmail(), "email");
        HelperStrings.ValidarEmail(espectador.getEmail());
        HelperFecha.validarFechaAnteriorALaActual(espectador.getFechaNacimiento());
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
    }
    //=========================== Validar Datos ==============================//
}
