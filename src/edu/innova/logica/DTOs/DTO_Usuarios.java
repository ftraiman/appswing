package edu.innova.logica.DTOs;

import java.util.Date;

public class DTO_Usuarios {

    private Long id;
    private String tipo;
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;

    private String descripcion;
    private String biografia;
    private String linkUsuario;

   
    public DTO_Usuarios() {  
    }
    
    public DTO_Usuarios(String tipo, String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String descripcion, String biografia, String linkUsuario) {
        this.tipo = tipo;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.linkUsuario = linkUsuario;
    }

    public DTO_Usuarios(String tipo, String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        this.tipo = tipo;
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

    
}
