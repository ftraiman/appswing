package edu.innova.logica.controladores;

import edu.innova.logica.controladores.impl.FuncionControladorImpl;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Funcion;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface FuncionControlador { //Interfaz de Funcion

    FuncionControladorImpl getInstance(); //Obtener la Instancia del Controlador

    void altaFuncion(Funcion funcion, Espectaculo espectaculo);

    void altaEspectadorAFuncion(Funcion funcion, Espectador espectador, Date fechaRegistroEspectaculo, BigDecimal costo);

    List<Funcion> getFuncionesPorIdEspectador(Espectador espectador);

    void canjearFunciones(Espectador espectadorSeleccionado, Funcion funcionSeleccionada, Set<Funcion> funcionesParaCanjear);

}
