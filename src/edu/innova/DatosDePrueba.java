package edu.innova;

import edu.innova.logica.Constantes;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.logica.servicios.UsuarioServicio;
import edu.innova.logica.servicios.impl.PlataformaServicioImpl;
import edu.innova.logica.servicios.impl.UsuarioServicioImpl;
import java.sql.SQLException;
import java.util.Date;

public class DatosDePrueba {

    public static void main(String[] args) throws SQLException {
        UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();
        PlataformaServicio plataformaServicio = new PlataformaServicioImpl().getInstance();
        
        // Alta artistas 
        Artista jaimeRoss = new Artista("La descripcion de Jaime", "La biografia de Jaime", "www.jaime.com", Long.MIN_VALUE, "jaimeross", "Jaime", "Ross", "jaimito@gmail.com", new Date(), Constantes.ARTISTA);
        Artista shakira = new Artista("La descripcion de Shakira", "La biografia de Shakira", "www.shakira.com", Long.MIN_VALUE, "shakira", "shakira", "Ni idea", "shakira@gmail.com", new Date(), Constantes.ARTISTA);
        Artista enano = new Artista("La descripcion de enano de la vela", "La biografia del enano", "www.enanovela.com", Long.MIN_VALUE, "enanodelavela", "Enano", "De la vela", "enanodepresivo@gmail.com", new Date(), Constantes.ARTISTA);
        Artista fredy = new Artista("La descripcion de Fredy", "La biografia de Fredy", "www.queen.com", Long.MIN_VALUE, "fredy", "Fredy", "Mercury", "fredyqueen@gmail.com", new Date(), Constantes.ARTISTA);
        Artista macCarney = new Artista("La descripcion de Paul", "La biografia de los Beatles", "www.beatles.com", Long.MIN_VALUE, "paulmakarni", "Pon", "LaCarni", "paul@beatles.com", new Date(), Constantes.ARTISTA);

        usuarioServicio.altaUsuario(jaimeRoss);
        usuarioServicio.altaUsuario(shakira);
        usuarioServicio.altaUsuario(enano);
        usuarioServicio.altaUsuario(fredy);
        usuarioServicio.altaUsuario(macCarney);

        // Alta espectadores
        Espectador charlyGood = new Espectador(Long.MIN_VALUE, "charlygood", "Carlos", "Desprolijo bueno", "charlygood@penadoy.com", new Date(), Constantes.ESPECTADOR);
        Espectador chory = new Espectador(Long.MIN_VALUE, "elchory", "No me acuerdo", "Castro", "chori@naciomal.com", new Date(), Constantes.ESPECTADOR);
        Espectador forlan = new Espectador(Long.MIN_VALUE, "cachibacha", "Diego", "Forlan", "diego@teRajaronAPatadasDelDelManya.com", new Date(), Constantes.ESPECTADOR);
        Espectador suarez = new Espectador(Long.MIN_VALUE, "lucho", "Luis", "Suarez", "luisito@paraDeMorder.com", new Date(), Constantes.ESPECTADOR);
        usuarioServicio.altaUsuario(charlyGood);
        usuarioServicio.altaUsuario(chory);
        usuarioServicio.altaUsuario(forlan);
        usuarioServicio.altaUsuario(suarez);
        
        // Alta plataformas
        Plataforma feis = new Plataforma(Long.MIN_VALUE, "Facebook", "Descripcion de Facebook", "www.Facebook.com");
        Plataforma twitter = new Plataforma(Long.MIN_VALUE, "Twitter", "Descripcion de Twitter", "www.twitter.com");
        Plataforma twitch = new Plataforma(Long.MIN_VALUE, "Twitch", "Descripcion de Twitch", "www.twitch.com");
        plataformaServicio.altaPlataforma(feis);
        plataformaServicio.altaPlataforma(twitch);
        plataformaServicio.altaPlataforma(twitch);
        
        
        

    }

    //        Alta espectador
//        Espectador espectador = new Espectador(Long.MIN_VALUE, "flash", "Barry", "Allen", "flash@dc.com", new Date(), Constantes.ESPECTADOR);
//        usuarioServicio.altaUsuario(espectador);
}
