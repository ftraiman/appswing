package edu.innova.logica.controladores;

import edu.innova.logica.controladores.impl.FuncionControladorImpl;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Funcion;

public interface FuncionControlador { //Interfaz de Funcion

    FuncionControladorImpl getInstance(); //Obtener la Instancia del Controlador

    void altaFuncion(Funcion funcion, Espectaculo espectaculo);

}
