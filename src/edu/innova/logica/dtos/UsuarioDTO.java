package edu.innova.logica.dtos;

import java.util.Date;
import java.util.Objects;

public class UsuarioDTO {

    private Long id;
    private String clave;
    private String tipo;
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;
    //TODO Agregar el campo nombre de foto
    private String imagen;

    private String descripcion;
    private String biografia;
    private String linkUsuario;

   
    public UsuarioDTO() {  
    }
    
    public UsuarioDTO(String tipo, String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String descripcion, String biografia, String linkUsuario, String clave) {
        this.tipo = tipo;
        this.clave = clave;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.linkUsuario = linkUsuario;
    }

    public UsuarioDTO(String tipo, String nickname, String nombre, String apellido, String email, Date fechaNacimiento,String clave) {
        this.tipo = tipo;
        this.clave = clave;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }
    

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getLinkUsuario() {
        return linkUsuario;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s %s %s", tipo, nombre, apellido, nickname, email, fechaNacimiento, linkUsuario, biografia, descripcion);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final UsuarioDTO other = (UsuarioDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
