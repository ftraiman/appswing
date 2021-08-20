package edu.innova.logica.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Espectaculo {

    private Long id;
    private Artista artista;
    private String nombre;
    private Plataforma plataforma;
    private String descripcion;
    private Integer duracion;
    private Integer espectadoresMinimos;
    private Integer espectadoresMaximos;
    private String url;
    private BigDecimal costo;
    private Date fechaRegistro;
    private List<Funcion> funciones;

    public Espectaculo() {
    }

    public Espectaculo(Long id, Artista artista, String nombre, Plataforma plataforma, String descripcion, Integer duracion, Integer espectadoredMinimos, Integer espectadoresMaximos, String url, BigDecimal costo, Date fechaRegistro, List<Funcion> funciones) {
        this.id = id;
        this.artista = artista;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.espectadoresMinimos = espectadoredMinimos;
        this.espectadoresMaximos = espectadoresMaximos;
        this.url = url;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.funciones = funciones;
    }

    public Espectaculo(String nombre, String descripcion, Integer duracion, Integer espectadoredMinimos, Integer espectadoresMaximos, String url, BigDecimal costo, Date fechaRegistro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.espectadoresMinimos = espectadoredMinimos;
        this.espectadoresMaximos = espectadoresMaximos;
        this.url = url;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
    }

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

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
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

    public Integer getEspectadoresMinimos() {
        return espectadoresMinimos;
    }

    public void setEspectadoresMinimos(Integer espectadoresMinimos) {
        this.espectadoresMinimos = espectadoresMinimos;
    }

    public Integer getEspectadoresMaximos() {
        return espectadoresMaximos;
    }

    public void setEspectadoresMaximos(Integer espectadoresMaximos) {
        this.espectadoresMaximos = espectadoresMaximos;
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

    @Override
    public String toString() {
        return String.format("%s", nombre);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Espectaculo other = (Espectaculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
