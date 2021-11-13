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
    private String estado;
    private Long idCategoria;
    private String imagen;
    private String descripcionPremios;
    private Integer cantidadPremios;

    public Espectaculo() {
    }

    public Espectaculo(Long id, Artista artista, String nombre, Plataforma plataforma, String descripcion, Integer duracion, Integer espectadoredMinimos, Integer espectadoresMaximos, String url, BigDecimal costo, Date fechaRegistro, List<Funcion> funciones, Long idCategoria, String estado, String imagen, String descripcionPremios, Integer cantidadPremios) {
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
        this.idCategoria = idCategoria;
        this.estado = estado;
        this.imagen = imagen;
        this.descripcionPremios = descripcionPremios;
        this.cantidadPremios = cantidadPremios;
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

    //Alta de Espectaculo
    public Espectaculo(String nombre, String descripcion, Integer duracion, Integer espectadoredMinimos, Integer espectadoresMaximos, String url, BigDecimal costo, Date fechaRegistro, Long idCategoria, String estado, String imagen, String descripcionPremios, Integer cantidadPremios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.espectadoresMinimos = espectadoredMinimos;
        this.espectadoresMaximos = espectadoresMaximos;
        this.url = url;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.idCategoria = idCategoria;
        this.estado = estado;
        this.imagen = imagen;
        this.descripcionPremios = descripcionPremios;
        this.cantidadPremios = cantidadPremios;
    }

    public String getDescripcionPremios() {
        return descripcionPremios;
    }

    public void setDescripcionPremios(String descripcionPremios) {
        this.descripcionPremios = descripcionPremios;
    }

    public Integer getCantidadPremios() {
        return cantidadPremios;
    }

    public void setCantidadPremios(Integer cantidadPremios) {
        this.cantidadPremios = cantidadPremios;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
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
