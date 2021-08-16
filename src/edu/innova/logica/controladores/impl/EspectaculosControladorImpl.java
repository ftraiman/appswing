package edu.innova.logica.controladores.impl;

import edu.innova.logica.Fabrica;
import edu.innova.logica.controladores.EspectaculosControlador;
import edu.innova.logica.entidades.Espectaculo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class EspectaculosControladorImpl implements EspectaculosControlador {

    @Override
    public void altaEspectaculo(Long idArtista, Long idPlataforma,Espectaculo espectaculo) {
         Fabrica fabrica = new Fabrica();
         
         try {
                int i = JOptionPane.showConfirmDialog(null, "Desea Registrar este Espectaculo??", "Confirmar Alta Espectaculo", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    fabrica.getEspectaculoServicioImpl().altaEspectaculo(idArtista,idPlataforma,espectaculo);
                } else {
                    JOptionPane.showMessageDialog(null, "No se Agrego el Espectaculo");
                }
            } catch (Exception ex) {
                Logger.getLogger(EspectaculosControladorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
         
    }
    
}
