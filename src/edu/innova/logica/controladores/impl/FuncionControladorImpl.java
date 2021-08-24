package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.controladores.FuncionControlador;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.logica.servicios.impl.FuncionServicioImpl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

    @Override
    public void altaEspectadorAFuncion(Funcion funcion, Espectador espectador, Date fechaRegistroEspectaculo, BigDecimal costo) {
        validarAltaEspectadorAFuncion(funcion, espectador, fechaRegistroEspectaculo, costo);
        funcionServicio.altaEspectadorAFuncion(funcion, espectador, fechaRegistroEspectaculo, costo);
    }

    @Override
    public List<Funcion> getFuncionesPorIdEspectador(Espectador espectador) {
        if (espectador == null || espectador.getId() == null) {
            throw new InnovaModelException("El Espectador es inválido");
        }
        try {
            return funcionServicio.getFuncionesPorIdEspectador(espectador);
        } catch (BaseDeDatosException e) {
            throw new InnovaModelException(e.getMessage(), e.getCause());
        }
    }

    private void validarNuevaFuncion(Funcion funcion, Espectaculo espectaculo) {
        HelperStrings.stringNoVacio(funcion.getNombre(), "nombre");
        HelperFecha.validarFechaPosteriorALaActual(funcion.getFechaInicio(), "fecha de la funcion");
        if (funcion.getArtistasInvitados().contains(espectaculo.getArtista())) {
            throw new InnovaModelException("El artista organizador no puede ser artista invitado");
        }
    }

    private void validarAltaEspectadorAFuncion(Funcion funcion, Espectador espectador, Date fechaRegistroEspectaculo, BigDecimal costo) {
        if (funcion == null) {
            throw new InnovaModelException("La Función es nula");
        }
        if (funcion.getId() == null) {
            throw new InnovaModelException("La Función no tiene ID");
        }
        if (espectador == null) {
            throw new InnovaModelException("La Espectador es nulo");
        }
        if (espectador.getId() == null) {
            throw new InnovaModelException("La Espectador no tiene ID");
        }
        if (fechaRegistroEspectaculo == null) {
            throw new InnovaModelException("La Fecha de registro no puede ser nula");
        }
        if (costo == null) {
            throw new InnovaModelException("El costo no puede ser nulo");
        }
        if (costo.compareTo(BigDecimal.ZERO) < 0) {
            throw new InnovaModelException("El costo no puede ser negativo");
        }
        HelperFecha.validarFechaPosteriorALaActual(fechaRegistroEspectaculo, "Fecha de la función");
    }

}
