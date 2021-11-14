package edu.innova.logica.dtos;

import java.util.Date;

public class CanjeTresPorUnoDTO {
    
    private Long id;
    private Long idUsuario;
    private Long idFuncionObtenida;
    private Long idEspectaculoDeFuncion;
    private String funcionesCanjeadas;
    private Date fechaRegistro;
    private String funciones;

    public CanjeTresPorUnoDTO() {
    }

    public CanjeTresPorUnoDTO(Long idUsuario, Long idFuncionObtenida, String funcionesCanjeadas, Long idEspectaculoDeFuncion) {
        this.idUsuario = idUsuario;
        this.idFuncionObtenida = idFuncionObtenida;
        this.funcionesCanjeadas = funcionesCanjeadas;
        this.idEspectaculoDeFuncion = idEspectaculoDeFuncion;
    }

    public CanjeTresPorUnoDTO(Long id, Long idUsuario, Long idFuncionObtenida, String funcionesCanjeadas, Date fechaRegistro, Long idEspectaculoDeFuncion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idFuncionObtenida = idFuncionObtenida;
        this.funcionesCanjeadas = funcionesCanjeadas;
        this.fechaRegistro = fechaRegistro;
        this.idEspectaculoDeFuncion = idEspectaculoDeFuncion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdFuncionObtenida() {
        return idFuncionObtenida;
    }

    public void setIdFuncionObtenida(Long idFuncionObtenida) {
        this.idFuncionObtenida = idFuncionObtenida;
    }

    public Long getIdEspectaculoDeFuncion() {
        return idEspectaculoDeFuncion;
    }

    public void setIdEspectaculoDeFuncion(Long idEspectaculoDeFuncion) {
        this.idEspectaculoDeFuncion = idEspectaculoDeFuncion;
    }

    public String getFuncionesCanjeadas() {
        return funcionesCanjeadas;
    }

    public void setFuncionesCanjeadas(String funcionesCanjeadas) {
        this.funcionesCanjeadas = funcionesCanjeadas;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    
    
}
