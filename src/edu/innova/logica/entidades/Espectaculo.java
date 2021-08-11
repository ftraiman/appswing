package edu.innova.logica.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Espectaculo {

    private Long id;
    private Artista artista;
    private String nombre;
    private String plataforma;
    private String descripcion;
    private Integer duracion;
    private Integer espectadoredMinimos;
    private String url;
    private BigDecimal costo;
    private Date fechaRegistro;
    private List<Funcion> funciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getEspectadoredMinimos() {
        return espectadoredMinimos;
    }

    public void setEspectadoredMinimos(Integer espectadoredMinimos) {
        this.espectadoredMinimos = espectadoredMinimos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(List<Funcion> funciones) {
        this.funciones = funciones;
    }

}
