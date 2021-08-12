package edu.innova.test;

import edu.innova.logica.Constantes;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Usuario;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.logica.servicios.impl.UsuarioServicioImpl;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UsuarioServicioTest {

    public static void main(String[] args) throws SQLException {
        UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();
        
//        Alta espectador
//        Espectador espectador = new Espectador(Long.MIN_VALUE, "flash", "Barry", "Allen", "flash@dc.com", new Date(), Constantes.ESPECTADOR);
//        usuarioServicio.altaUsuario(espectador);
        
//        // Alta artista
//        Artista artista = new Artista("descripcion",  "biografia",  "linkUsuario", Long.MIN_VALUE, "batman", "Bruce", "Wayne", "batman@dc.com", new Date(), Constantes.ARTISTA);
//        usuarioServicio.altaUsuario(artista);

//        // Obtener usuario por id
//        System.err.println(usuarioServicio.getUsuarioPorId(new Long(20)));
        
//        // Obtener usuario por nickName
//        System.err.println(usuarioServicio.getUsuarioPorNickName("batman"));

//        // Obtener todos los espectadores
//        List<Espectador> usuarios = usuarioServicio.getTodosLosEspectadores();
//        usuarios.forEach(e -> System.err.println(e));
        
        
//        // Obtener todos los artistas
//        List<Artista> artistas = usuarioServicio.getTodosLosArtistas();
//        artistas.forEach(a -> System.err.println(a));

////         Actualizar usuario
//        Espectador espectadorParaActualizar = (Espectador) usuarioServicio.getUsuarioPorId(new Long(20));
//        espectadorParaActualizar.setNombre("Martita");
//        usuarioServicio.modificarUsuario(espectadorParaActualizar);

    }

}
