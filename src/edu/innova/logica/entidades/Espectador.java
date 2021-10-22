package edu.innova.logica.entidades;

import java.util.Date;

public class Espectador extends Usuario {

    public Espectador(Long id, String clave, String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String imagen) {
        super(id, clave, nickname, nombre, apellido, email, fechaNacimiento, imagen);
        this.tipo = "espectador";
    }

    public Espectador(String clave, String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String imagen) {
        super(clave, nickname, nombre, apellido, email, fechaNacimiento, imagen);
        this.tipo = "espectador";
    }

    public Espectador(Long id, String nombre, String apellido, Date fechaNacimiento) {
        super(id, nombre, apellido, fechaNacimiento);
        this.tipo = "espectador";
    }

    public Espectador() {
    }

}
