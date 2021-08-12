package edu.innova.logica.entidades;

import java.util.Date;
import java.util.List;

public class Funcion {

    private Long id;
    private Long idEspectaculo;
    private Date fechaInicio;
    private Date fechaRegistro;
    private List<Artista> artistasInvitados;

    public Funcion() {
    }

    public Funcion(Long id, Long idEspectaculo, Date fechaInicio, Date fechaRegistro, List<Artista> artistasInvitados) {
        this.id = id;
        this.idEspectaculo = idEspectaculo;
        this.fechaInicio = fechaInicio;
        this.fechaRegistro = fechaRegistro;
        this.artistasInvitados = artistasInvitados;
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

    @Override
    public String toString() {
        return "Funcion{" + "id=" + id + ", idEspectaculo=" + idEspectaculo + ", fechaInicio=" + fechaInicio + ", fechaRegistro=" + fechaRegistro + ", artistasInvitados=" + artistasInvitados + '}';
    }

}
