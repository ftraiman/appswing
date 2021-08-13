package edu.innova.logica.entidades;

import java.util.Date;

public class Artista extends Usuario {

    private String descripcion;
    private String biografia;
    private String linkUsuario;

    public Artista() {
    }

    public Artista(String descripcion, String biografia, String linkUsuario, Long id, String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(id, nickname, nombre, apellido, email, fechaNacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.linkUsuario = linkUsuario;
    }

    public Artista(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String descripcion, String biografia, String linkUsuario) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.linkUsuario = linkUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getLinkUsuario() {
        return linkUsuario;
    }

    public void setLinkUsuario(String linkArtista) {
        this.linkUsuario = linkArtista;
    }

    @Override
    public String toString() {
        return super.toString() + " Artista{" + "descripcion=" + descripcion + ", biografia=" + biografia + ", linkUsuario=" + linkUsuario + '}';
    }

}
