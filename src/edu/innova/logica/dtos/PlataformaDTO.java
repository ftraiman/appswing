package edu.innova.logica.dtos;

import edu.innova.logica.entidades.Plataforma;

public class PlataformaDTO extends Plataforma {

    public PlataformaDTO() {
    }

    public PlataformaDTO(String nombre, String descripcion, String url) {
        super(nombre, descripcion, url);
    }
    
    public PlataformaDTO(Long id, String nombre, String descripcion, String url) {
        super(id, nombre, descripcion, url);
    }
}
