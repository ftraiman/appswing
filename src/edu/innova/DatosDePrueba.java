package edu.innova;

import edu.innova.logica.Constantes;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Plataforma;
import edu.innova.logica.servicios.ArtistaServicio;
import edu.innova.logica.servicios.PlataformaServicio;
import edu.innova.logica.servicios.impl.PlataformaServicioImpl;
import edu.innova.logica.servicios.impl.EspectadorServicioImpl;
import java.sql.SQLException;
import java.util.Date;
import edu.innova.logica.servicios.EspectadorServicio;
import edu.innova.logica.servicios.impl.ArtistaServicioImpl;

public class DatosDePrueba {

    public static void main(String[] args) throws SQLException {
        EspectadorServicio espectadorServicio = new EspectadorServicioImpl().getInstance();
        ArtistaServicio artistaServicio = new ArtistaServicioImpl().getInstance();
        PlataformaServicio plataformaServicio = new PlataformaServicioImpl().getInstance();
        
        // Alta artistas 
        Artista jaimeRoss = new Artista("La descripcion de Jaime", "La biografia de Jaime", "www.jaime.com", Long.MIN_VALUE, "jaimeross", "Jaime", "Ross", "jaimito@gmail.com", new Date());
        Artista shakira = new Artista("La descripcion de Shakira", "La biografia de Shakira", "www.shakira.com", Long.MIN_VALUE, "shakira", "shakira", "Ni idea", "shakira@gmail.com", new Date());
        Artista enano = new Artista("La descripcion de enano de la vela", "La biografia del enano", "www.enanovela.com", Long.MIN_VALUE, "enanodelavela", "Enano", "De la vela", "enanodepresivo@gmail.com", new Date());
        Artista fredy = new Artista("La descripcion de Fredy", "La biografia de Fredy", "www.queen.com", Long.MIN_VALUE, "fredy", "Fredy", "Mercury", "fredyqueen@gmail.com", new Date());
        Artista macCarney = new Artista("La descripcion de Paul", "La biografia de los Beatles", "www.beatles.com", Long.MIN_VALUE, "paulmakarni", "Pon", "LaCarni", "paul@beatles.com", new Date());

        artistaServicio.altaUsuario(jaimeRoss);
        artistaServicio.altaUsuario(shakira);
        artistaServicio.altaUsuario(enano);
        artistaServicio.altaUsuario(fredy);
        artistaServicio.altaUsuario(macCarney);

        // // Alta espectadores
        Espectador charlyGood = new Espectador(Long.MIN_VALUE, "charlygood", "Carlos", "Desprolijo bueno", "charlygood@penadoy.com", new Date());
         Espectador chory = new Espectador(Long.MIN_VALUE, "elchory", "No me acuerdo", "Castro", "chori@naciomal.com", new Date());
        Espectador forlan = new Espectador(Long.MIN_VALUE, "cachibacha", "Diego", "Forlan", "diego@teRajaronAPatadasDelDelManya.com", new Date());
        Espectador suarez = new Espectador(Long.MIN_VALUE, "lucho", "Luis", "Suarez", "luisito@paraDeMorder.com", new Date());
        
        espectadorServicio.altaUsuario(charlyGood);
        espectadorServicio.altaUsuario(chory);
        espectadorServicio.altaUsuario(forlan);
        espectadorServicio.altaUsuario(suarez);
        
        // Alta plataformas
        Plataforma feis = new Plataforma(Long.MIN_VALUE, "Facebook", "Descripcion de Facebook", "www.Facebook.com");
        Plataforma twitter = new Plataforma(Long.MIN_VALUE, "Twitter", "Descripcion de Twitter", "www.twitter.com");
        Plataforma twitch = new Plataforma(Long.MIN_VALUE, "Twitch", "Descripcion de Twitch", "www.twitch.com");
        plataformaServicio.altaPlataforma(feis);
        plataformaServicio.altaPlataforma(twitter);
        plataformaServicio.altaPlataforma(twitch);
        
        
        

    }

    //        Alta espectador
//        Espectador espectador = new Espectador(Long.MIN_VALUE, "flash", "Barry", "Allen", "flash@dc.com", new Date(), Constantes.ESPECTADOR);
//        usuarioServicio.altaUsuario(espectador);
}
