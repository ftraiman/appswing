package edu.innova.logica.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Paquete {

    private Long id;
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal descuento;
    private List<Espectaculo> espectaculos;

    public Paquete(String nombre, String descripcion, Date fechaInicio, Date fechaFin, BigDecimal descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descuento = descuento;
    }

    public Paquete(Long id, String nombre, String descripcion, Date fechaInicio, Date fechaFin, BigDecimal descuento, List<Espectaculo> espectaculos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descuento = descuento;
        this.espectaculos = espectaculos;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public List<Espectaculo> getEspectaculos() {
        return espectaculos;
    }

    public void setEspectaculos(List<Espectaculo> espectaculos) {
        this.espectaculos = espectaculos;
    }
    
    

}
