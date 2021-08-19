package edu.innova.logica.controladores.impl;

import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.Fabrica;
import edu.innova.logica.controladores.FuncionControlador;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.logica.servicios.impl.FuncionServicioImpl;

public class FuncionControladorImpl implements FuncionControlador {

    private static FuncionControladorImpl instance;

    public FuncionControladorImpl() {
    }

    //Obtener la instancia
    public FuncionControladorImpl getInstance() {
        if (null == instance) {
            instance = new FuncionControladorImpl();
        }
        return instance;
    }

    private FuncionServicio artistaServicio = new FuncionServicioImpl().getInstance();


    public void altaFuncion(Funcion funcion) {

        validarNuevaFuncion(funcion);

        Fabrica fabrica = new Fabrica();

    }

    private void validarNuevaFuncion(Funcion funcion) {
         HelperStrings.stringNoVacio(funcion.getNombre(), "nombre");
        HelperFecha.validarFechaPosteriorALaActual(funcion.getFechaInicio(), "fecha de la funcion");
    }

}
