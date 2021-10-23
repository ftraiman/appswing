package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.InnovaModelException;
import edu.innova.logica.controladores.CanjeControlador;
import edu.innova.logica.dtos.CanjeTresPorUnoDTO;
import edu.innova.logica.servicios.CanjeServicio;
import edu.innova.logica.servicios.impl.CanjeServicioImpl;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CanjeControladorImpl implements CanjeControlador {

    private final CanjeServicio canjeServicio = CanjeServicioImpl.getInstance();

    private static CanjeControladorImpl instance;

    public static CanjeControladorImpl getInstance() {
        if (null == instance) {
            instance = new CanjeControladorImpl();
        }
        return instance;
    }

    @Override
    public void altaCanjeTresPorUno(CanjeTresPorUnoDTO canje) {
        validarCanjeTresPorUno(canje);
        canjeServicio.altaCanjeTresPorUno(canje);
    }
    
    public void validarCanjeTresPorUno(CanjeTresPorUnoDTO canje) {
        Optional.ofNullable(canje.getIdUsuario()).orElseThrow(()-> new InnovaModelException("Falta idUsuario"));
        Optional.ofNullable(canje.getIdFuncionObtenida()).orElseThrow(()-> new InnovaModelException("Falta la funcion obtenida"));
        Optional.ofNullable(canje.getFuncionesCanjeadas()).orElseThrow(()-> new InnovaModelException("Faltan las funciones canjeadas"));
        if (canje.getFuncionesCanjeadas().split(",").length != 3) {
            throw new InnovaModelException("El numero de funciones a canjear no es 3");
        }
        if (Stream.of(canje.getFuncionesCanjeadas().split(","))
                .map(funcion -> Long.valueOf(funcion))
                .collect(Collectors.toList())
                .contains(canje.getIdFuncionObtenida())) {
            throw new InnovaModelException("No se puede canjear la misma funcion");
        }       
    }

    @Override
    public void altaEspectaculoPaqueteUtilizado(Long idUsuario, Long idPaquete, Long idEspectaculo) {
        canjeServicio.altaEspectaculoPaqueteUtilizado(idUsuario, idPaquete, idEspectaculo);
    }
}
