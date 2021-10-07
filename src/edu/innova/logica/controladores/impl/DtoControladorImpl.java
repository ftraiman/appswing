package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.controladores.DtoControlador;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.servicios.DtoServicio;
import edu.innova.logica.servicios.impl.DtoServicioImpl;


public class DtoControladorImpl implements DtoControlador{
    
     private static DtoControladorImpl instance;

    public DtoControladorImpl() {}//Constructor por defecto

    //Obtener la instancia
    public DtoControladorImpl getInstance() {
        if (null == instance) {
            instance = new DtoControladorImpl();
        }
        return instance;
    }

    //Obtener instancia de servicio usuario
    private DtoServicio DtoServicio = new DtoServicioImpl().getInstance();
    
    
    @Override
    public UsuarioDTO getUsuarioDto(String nickname,String email,String clave) {
        try {
            return DtoServicio.getUsuarioDto(nickname, email, clave);
        } catch (BaseDeDatosException ex) {
            throw new InnovaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }
    
    
}
