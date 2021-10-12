package edu.innova.logica.dtos;

import edu.innova.logica.entidades.Artista;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FuncionDTO {

    //============================ ATRIBUTOS =================================//
    private Long id;
    private String nombre;
    private Long idEspectaculo;
    private Date fechaInicio;
    private Date fechaRegistro;
    private List<Artista> artistasInvitados;
    private String imagen;
    //============================ ATRIBUTOS =================================//

    //============================ CONSTRUCTURES =============================//
    public FuncionDTO() {
    }

    public FuncionDTO(Long id, String nombre, Long idEspectaculo, Date fechaInicio, Date fechaRegistro, List<Artista> artistasInvitados, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.idEspectaculo = idEspectaculo;
        this.fechaInicio = fechaInicio;
        this.fechaRegistro = fechaRegistro;
        this.artistasInvitados = artistasInvitados;
        this.imagen = imagen;
    }
    
    public FuncionDTO(String nombre, Long idEspectaculo, Date fechaInicio, Date fechaRegistro, List<Artista> artistasInvitados, String imagen) {
        this.nombre = nombre;
        this.idEspectaculo = idEspectaculo;
        this.fechaInicio = fechaInicio;
        this.fechaRegistro = fechaRegistro;
        this.artistasInvitados = artistasInvitados;
        this.imagen = imagen;
    }
    //============================ CONSTRUCTURES =============================//

    //======================== GETTER & SETTER ===============================//
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    //======================== GETTER & SETTER ===============================//

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
        final FuncionDTO other = (FuncionDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
