package edu.innova.logica.entidades;

import java.util.Date;

public class Artista extends Usuario {

    private String descripcion;
    private String biografia;
    private String linkUsuario;

    public Artista() {
    }

    public Artista(String descripcion, String biografia, String linkUsuario, Long id, String clave, String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(id, clave, nickname, nombre, apellido, email, fechaNacimiento);
        this.tipo = "artista";
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.linkUsuario = linkUsuario;
    }

    public Artista(String descripcion, String biografia, String linkUsuario, String clave, String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(clave, nickname, nombre, apellido, email, fechaNacimiento);
        this.tipo = "artista";
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.linkUsuario = linkUsuario;
    }

   

    public Artista(String descripcion, String biografia, String linkUsuario, Long id, String nombre, String apellido, Date fechaNacimiento) {
        super(id, nombre, apellido, fechaNacimiento);
        this.tipo = "artista";
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.linkUsuario = linkUsuario;
    }
    
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
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
        return super.toString();
    }

}
