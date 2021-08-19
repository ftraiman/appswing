package edu.innova.logica.controladores;

import edu.innova.logica.controladores.impl.FuncionControladorImpl;
import edu.innova.logica.entidades.Funcion;

public interface FuncionControlador { //Interfaz de Funcion
    
    public abstract FuncionControladorImpl getInstance(); //Obtener la Instancia del Controlador
    public abstract void altaFuncion(Funcion funcion); 
    
}
