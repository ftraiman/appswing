package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.controladores.FuncionControlador;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.logica.servicios.impl.FuncionServicioImpl;

public class FuncionControladorImpl implements FuncionControlador {

    private static FuncionControladorImpl instance;

    public FuncionControladorImpl() {
    }

    @Override
    public FuncionControladorImpl getInstance() {
        if (null == instance) {
            instance = new FuncionControladorImpl();
        }
        return instance;
    }

    private FuncionServicio funcionServicio = new FuncionServicioImpl().getInstance();

    @Override
    public void altaFuncion(Funcion funcion, Espectaculo espectaculo) {

        validarNuevaFuncion(funcion, espectaculo);

        funcionServicio.altaFuncion(espectaculo.getId(), funcion);
    }

    private void validarNuevaFuncion(Funcion funcion, Espectaculo espectaculo) {
        HelperStrings.stringNoVacio(funcion.getNombre(), "nombre");
        HelperFecha.validarFechaPosteriorALaActual(funcion.getFechaInicio(), "fecha de la funcion");
        if (funcion.getArtistasInvitados().contains(espectaculo.getArtista())) {
            throw new InnovaModelException("El artista organizador no puede ser artista invitado");
        }
    }

}
