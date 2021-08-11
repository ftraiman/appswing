package edu.innova.logica.entidades;

import java.util.Date;

public class Espectador extends Usuario {

    public Espectador(Long id, String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String tipo) {
        super(id, nickname, nombre, apellido, email, fechaNacimiento, tipo);
    }
}
