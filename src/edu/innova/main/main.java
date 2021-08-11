/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.innova.main;

import edu.innova.logica.Constantes;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.controladores.impl.UsuarioControladorImpl;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.logica.servicios.impl.UsuarioServicioImpl;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author federico
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        UsuarioServicio usuarioControlador = new UsuarioServicioImpl().getInstance();

//        Usuario usuario = usuarioControlador.getUsuarioPorId(new Long(1));
////        System.err.println(usuario);
//
//       List<Espectador> usuarios = usuarioControlador.getTodosLosEspectadores();
//
        Espectador espectador = new Espectador(Long.MIN_VALUE, "flash", "Barry", "Allen", "flash@dc.com", new Date(), Constantes.ESPECTADOR);
        usuarioControlador.altaUsuario(espectador);
//        usuarios.forEach(e -> System.err.println(e));
//        String descripcion,  biografia,  linkUsuario;
//        
////        Artista artista = new Artista("descripcion",  "biografia",  "linkUsuario", Long.MIN_VALUE, "batman", "Bruce", "Wayne", "batman@dc.com", new Date(), Constantes.ARTISTA);
////        usuarioControlador.altaUsuario(artista);
//        List<Artista> artistas = usuarioControlador.getTodosLosArtistas();
//        artistas.forEach(a -> System.err.println(a));
//        
//        System.err.println(usuarioControlador.getUsuarioPorNickName("batman"));
//        System.err.println(usuarioControlador.getUsuarioPorId(Long.valueOf(2)));
        
    }

}
