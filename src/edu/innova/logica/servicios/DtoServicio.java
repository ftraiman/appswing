package edu.innova.logica.servicios;

import edu.innova.logica.dtos.UsuarioDTO;


public interface DtoServicio {
    public UsuarioDTO getUsuarioDto(String nickname,String email,String clave);
}
