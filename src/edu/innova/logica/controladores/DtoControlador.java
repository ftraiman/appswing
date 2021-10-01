package edu.innova.logica.controladores;

import edu.innova.logica.dtos.UsuarioDTO;

public interface DtoControlador {
    public UsuarioDTO getUsuarioDto(String nickname,String email,String clave);
}
