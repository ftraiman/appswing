package edu.innova.logica.controladores.impl;

import edu.innova.logica.Fabrica;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import java.sql.SQLException;
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
}
