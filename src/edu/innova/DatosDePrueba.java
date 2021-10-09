package edu.innova;

import edu.innova.logica.Constantes;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.controladores.impl.UsuarioControladorImpl;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.logica.servicios.impl.PlataformaServicioImpl;
import java.sql.SQLException;
import java.util.Date;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.logica.servicios.impl.EspectaculoServicioImpl;

import edu.innova.logica.servicios.impl.UsuarioServicioImpl;
import java.math.BigDecimal;

public class DatosDePrueba {

    public static void main(String[] args) throws SQLException {

        UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();
        PlataformaServicio plataformaServicio = new PlataformaServicioImpl().getInstance();
        EspectaculoServicio espectaculoServicio = new EspectaculoServicioImpl().getInstance();
        UsuarioControlador usuarioControlador = new UsuarioControladorImpl().getInstance();

//
//        // Alta artistas 
//        Artista jaimeRoss = new Artista("La descripcion de Jaime", "La biografia de Jaime", "www.jaime.com", "", "jaimeross", "Jaime", "Ross", "jaimito@gmail.com", new Date(), "jaimeross.jpg");
//        usuarioServicio.altaUsuario(jaimeRoss);
//        Artista shakira = new Artista("La descripcion de Shakira", "La biografia de Shakira", "www.shakira.com", "", "shakira", "shakira", "Ni idea", "shakira@gmail.com", new Date(), "shakira.jpg");
//        usuarioServicio.altaUsuario(shakira);
//        Artista enano = new Artista("La descripcion de enano de la vela", "La biografia del enano", "www.enanovela.com", "", "enanodelavela", "Enano", "De la vela", "enanodepresivo@gmail.com", new Date(), "enanodelavela.jpg");
//        usuarioServicio.altaUsuario(enano);
//        Artista fredy = new Artista("La descripcion de Fredy", "La biografia de Fredy", "www.queen.com", "", "fredy", "Fredy", "Mercury", "fredyqueen@gmail.com", new Date(), "fredy.jpg");
//        usuarioServicio.altaUsuario(fredy);
//        Artista macCarney = new Artista("La descripcion de Paul", "La biografia de los Beatles", "www.beatles.com", "", "paulmakarni", "Pon", "LaCarni", "paul@beatles.com", new Date(), "paulmakarni.jpg");
//        usuarioServicio.altaUsuario(macCarney);
//
//        // Alta espectadores
//        Espectador charlyGood = new Espectador("", "charlygood", "Carlos", "Desprolijo bueno", "charlygood@penadoy.com", new Date(), "charlygood.jpg");
//        usuarioServicio.altaUsuario(charlyGood);
//        Espectador chory = new Espectador("", "elchory", "No me acuerdo", "Castro", "chori@naciomal.com", new Date(), "elchory.jpg");
//        usuarioServicio.altaUsuario(chory);
//        Espectador forlan = new Espectador("", "cachibacha", "Diego", "Forlan", "diego@teRajaronAPatadasDelDelManya.com", new Date(), "cachibacha.jpg");
//        usuarioServicio.altaUsuario(forlan);
//        Espectador suarez = new Espectador("", "lucho", "Luis", "Suarez", "luisito@paraDeMorder.com", new Date(), "lucho.jpg");
//        usuarioServicio.altaUsuario(suarez);
//
//        Artista jaimeParaModificar = (Artista) usuarioServicio.getUsuarioPorNickName("jaimeross");
//        jaimeParaModificar.setDescripcion("La nueva descripcion de Jaime");
//        usuarioServicio.modificarUsuario(jaimeParaModificar);
//
//        Espectador forlanParaModificar = (Espectador) usuarioServicio.getUsuarioPorNickName("cachibacha");
//        forlanParaModificar.setNombre("Diego10");
//        usuarioServicio.modificarUsuario(forlanParaModificar);
//        
//        // Alta categoria
//        espectaculoServicio.altaCategoria("Arte");
//
//        // Alta plataformas
//        Plataforma feis = new Plataforma(Long.MIN_VALUE, "Facebook", "Descripcion de Facebook", "www.Facebook.com");
//        plataformaServicio.altaPlataforma(feis);
//        Plataforma twitter = new Plataforma(Long.MIN_VALUE, "Twitter", "Descripcion de Twitter", "www.twitter.com");
//        plataformaServicio.altaPlataforma(twitter);
//        Plataforma twitch = new Plataforma(Long.MIN_VALUE, "Twitch", "Descripcion de Twitch", "www.twitch.com");
//        plataformaServicio.altaPlataforma(twitch);
//        
//        
//        Espectaculo espectaculoJaime = new Espectaculo("Jaime Ross online", "Jaime Ross nuevo disco", 90, 100, 1000, "www.superjaime.com", BigDecimal.valueOf(1000), new Date());
//        espectaculoJaime.setIdCategoria(Long.valueOf(1)) ;
//        Plataforma facebook = plataformaServicio.getPlataformaPorNombre("Facebook");
//        espectaculoServicio.altaEspectaculo(jaimeParaModificar.getId(), facebook.getId(), espectaculoJaime);
//        
//        Plataforma twitch2 = plataformaServicio.getPlataformaPorNombre("twitch");
//        Artista shakiraYPique = (Artista) usuarioServicio.getUsuarioPorNickName("shakira");
//        Espectaculo espectaculoShakira = new Espectaculo("Shakira en twitch", "Shakira y Pique", 60, 120, 2000, "www.superpique.com", BigDecimal.valueOf(1001), new Date());
//        espectaculoShakira.setIdCategoria(Long.valueOf(1));
//        espectaculoServicio.altaEspectaculo(shakiraYPique.getId(), twitch2.getId(), espectaculoShakira);
//        
//        UsuarioDTO espectadorWeb = new UsuarioDTO(null, Constantes.ESPECTADOR, "mario", "Mario", "Balotelli", "marito@hagocagadas.com", new Date(), null, null, null, "clave", "mario.jpg");
//        UsuarioDTO artistaWeb    = new UsuarioDTO(null, Constantes.ARTISTA, "elvis", "Elvis", "Presley", "elvis@fenomeno.com", new Date(), "El rey del rock", "Una gran biografia", "https://es.wikipedia.org/wiki/Elvis_Presley", "clave", "elvis.jpg");
//        usuarioControlador.crearUsuarioDTO(espectadorWeb);
//        usuarioControlador.crearUsuarioDTO(artistaWeb);
//            usuarioControlador.seguirUsuario(Long.valueOf(1), Long.valueOf(2));
//        usuarioControlador.seguirUsuario(Long.valueOf(1), Long.valueOf(2));
//        System.err.print(usuarioControlador.usuariosQueSigue(Long.valueOf(1)));
//        System.err.print(usuarioControlador.usuariosQueLoSiguen(Long.valueOf(2)));
//        usuarioControlador.dejarDeSeguir(Long.valueOf(1), Long.valueOf(2));
//        System.err.print(usuarioControlador.usuariosQueSigue(Long.valueOf(1)));

    }

}
