package edu.innova.logica.controladores.impl;

import edu.innova.logica.Fabrica;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.entidades.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

 //=========================== Alta de usuario ============================//
    @Override
    public void altaUsuario(Usuario usuario) {
        Fabrica fabrica = new Fabrica();
        try {  
            int i=JOptionPane.showConfirmDialog(null,"Desea Registrar este Usuario??", "Confirmar Usuario", JOptionPane.YES_NO_OPTION);
            if(i== JOptionPane.YES_OPTION){
            fabrica.getUsuarioServicioImpl().altaUsuario(usuario);
            }else{
            JOptionPane.showMessageDialog(null, "No se Agrego el Usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControladorImpl.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
//=========================== Alta de usuario ============================//
}
