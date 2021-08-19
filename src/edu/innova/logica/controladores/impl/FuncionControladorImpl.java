package edu.innova.logica.controladores.impl;

import com.mysql.jdbc.StringUtils;
import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.Fabrica;
import edu.innova.logica.controladores.FuncionControlador;
import edu.innova.logica.controladores.UsuarioControlador;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.entidades.Usuario;
import edu.innova.logica.servicios.ArtistaServicio;
import edu.innova.logica.servicios.EspectadorServicio;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.logica.servicios.impl.ArtistaServicioImpl;
import edu.innova.logica.servicios.impl.EspectadorServicioImpl;
import edu.innova.logica.servicios.impl.FuncionServicioImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
