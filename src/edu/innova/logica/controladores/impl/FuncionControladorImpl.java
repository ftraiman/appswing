package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.controladores.FuncionControlador;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.logica.servicios.impl.EspectaculoServicioImpl;
import edu.innova.logica.servicios.impl.FuncionServicioImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    
    private EspectaculoServicio espectaculoServicio = new EspectaculoServicioImpl().getInstance();
    

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

    @Override
    public void canjearFunciones(Espectador espectador, Funcion funcionSeleccionada, Set<Funcion> funcionesParaCanjear) {
        validarCanjearFunciones(espectador, funcionSeleccionada, funcionesParaCanjear);
        
        funcionServicio.eliminarFuncionesDelEspectador(new ArrayList(funcionesParaCanjear), espectador);
        funcionServicio.altaEspectadorAFuncion(funcionSeleccionada, espectador, new Date(), BigDecimal.ZERO);

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
        
        validarMaximaCantidadDeEspectadoresAFuncion(funcion);
    }

    private void validarCanjearFunciones(Espectador espectador, Funcion funcionSeleccionada, Set<Funcion> funcionesParaCanjear) {
        if (espectador == null) {
            throw new InnovaModelException("La Espectador no es válido");
        }
        if (funcionSeleccionada == null) {
            throw new InnovaModelException("La Función a canjear es nula");
        }
        if (funcionesParaCanjear == null || funcionesParaCanjear.isEmpty()) {
            throw new InnovaModelException("No hay funciones canjeables");
        }
        if (funcionesParaCanjear.size() < 3) {
            throw new InnovaModelException("Se necesitan al menos 3 funciones para canjear por otra");
        }
        if (funcionesParaCanjear.contains(funcionSeleccionada)) {
            throw new InnovaModelException("La función que intentas adquirir no puede estar en la lista que quieres canjear");
        }
        validarMaximaCantidadDeEspectadoresAFuncion(funcionSeleccionada);
    }
    
    private void validarMaximaCantidadDeEspectadoresAFuncion(Funcion funcion) {
        //Cantidad de espectadores a la funcion
        Espectaculo espectaculo = espectaculoServicio.getEspectaculoPorId(funcion.getIdEspectaculo());
        Integer cantMaximaDelEspectaculo = espectaculo.getEspectadoresMaximos();
        //Cantidad maxima de espectadores de la funcion
        Integer cantRegistradosAlEspectaculo = funcionServicio.getCantidadRegistrados(funcion.getId());
        if(cantRegistradosAlEspectaculo >= cantMaximaDelEspectaculo) {
            throw new InnovaModelException("Se llego al maximo de espectadores para esta Funcion");
        }
    }

}
