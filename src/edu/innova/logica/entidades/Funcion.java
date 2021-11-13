package edu.innova.logica.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Funcion {

    private Long id;
    private String nombre;
    private Long idEspectaculo;
    private Date fechaInicio;
    private Date fechaRegistro;
    private List<Artista> artistasInvitados = new ArrayList<>();
    private String imagen;
    private Boolean sorteo;

    public Funcion() {
    }

    public Funcion(Long id, Long idEspectaculo, Date fechaInicio, Date fechaRegistro, List<Artista> artistasInvitados, String nombre, String imagen, Boolean sorteo) {
        this.id = id;
        this.idEspectaculo = idEspectaculo;
        this.fechaInicio = fechaInicio;
        this.fechaRegistro = fechaRegistro;
        this.artistasInvitados = artistasInvitados;
        this.nombre = nombre;
        this.imagen = imagen;
        this.sorteo = sorteo;
    }
    public Funcion(String nombre, Long idEspectaculo, Date fechaInicio, Date fechaRegistro, List<Artista> artistasInvitados, String imagen, Boolean sorteo) {
        this.nombre = nombre;
        this.idEspectaculo = idEspectaculo;
        this.fechaInicio = fechaInicio;
        this.fechaRegistro = fechaRegistro;
        this.artistasInvitados = artistasInvitados;
        this.imagen = imagen;
        this.sorteo = sorteo;
    }

    public Boolean getSorteo() {
        return sorteo;
    }

    public void setSorteo(Boolean sorteo) {
        this.sorteo = sorteo;
    }    
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEspectaculo() {
        return idEspectaculo;
    }

    public void setIdEspectaculo(Long idEspectaculo) {
        this.idEspectaculo = idEspectaculo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Artista> getArtistasInvitados() {
        return artistasInvitados;
    }

    public void setArtistasInvitados(List<Artista> artistasInvitados) {
        this.artistasInvitados = artistasInvitados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", nombre, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcion other = (Funcion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
