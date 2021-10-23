package edu.innova.logica.controladores.impl;

import edu.innova.exceptions.BaseDeDatosException;
import edu.innova.exceptions.InnovaModelException;
import edu.innova.helpers.HelperFecha;
import edu.innova.helpers.HelperStrings;
import edu.innova.logica.controladores.CanjeControlador;
import edu.innova.logica.controladores.FuncionControlador;
import edu.innova.logica.dtos.CanjeTresPorUnoDTO;
import edu.innova.logica.dtos.FuncionDTO;
import edu.innova.logica.dtos.UsuarioDTO;
import edu.innova.logica.entidades.Artista;
import edu.innova.logica.entidades.Espectaculo;
import edu.innova.logica.entidades.Espectador;
import edu.innova.logica.entidades.Funcion;
import edu.innova.logica.servicios.EspectaculoServicio;
import edu.innova.logica.servicios.FuncionServicio;
import edu.innova.logica.servicios.impl.EspectaculoServicioImpl;
import edu.innova.logica.servicios.impl.FuncionServicioImpl;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private CanjeControlador canjeControlador = CanjeControladorImpl.getInstance();

    @Override
    public void altaFuncion(Funcion funcion, Espectaculo espectaculo) {

        validarNuevaFuncion(funcion, espectaculo);

        funcionServicio.altaFuncion(espectaculo.getId(), funcion);
    }

    @Override
    public void altaEspectadorAFuncionDto(Long idFuncion, Long idUsuario, Date fechaRegistroEspectaculo, BigDecimal costo) {
        Funcion funcion = funcionServicio.getFuncionPorId(idFuncion);
        Espectador espectador = new Espectador();
        espectador.setId(idUsuario);
        altaEspectadorAFuncion(funcion, espectador, fechaRegistroEspectaculo, costo);
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
        public void canjearFunciones(CanjeTresPorUnoDTO canje) {
        canjeControlador.altaCanjeTresPorUno(canje);

        Espectador espectador = new Espectador();
        espectador.setId(canje.getIdUsuario());
        
        Funcion funcionSeleccionada = new Funcion();
        funcionSeleccionada.setId(canje.getIdFuncionObtenida());
        funcionSeleccionada.setIdEspectaculo(canje.getIdEspectaculoDeFuncion());
        
        Set<Funcion> funcionesParaCanjear
                = Stream.of(canje.getFuncionesCanjeadas().split(",")).map(idFuncion -> {
                    Funcion funcion = new Funcion();
                    funcion.setId(Long.valueOf(idFuncion));
                    return funcion;
                }).collect(Collectors.toSet());

        this.canjearFunciones(espectador, funcionSeleccionada, funcionesParaCanjear);
    }

    @Override
    public void canjearFunciones(Espectador espectador, Funcion funcionSeleccionada, Set<Funcion> funcionesParaCanjear) {
        validarCanjearFunciones(espectador, funcionSeleccionada, funcionesParaCanjear);
        funcionServicio.eliminarFuncionesDelEspectador(new ArrayList(funcionesParaCanjear), espectador);
        funcionServicio.altaEspectadorAFuncion(funcionSeleccionada, espectador, new Date(), BigDecimal.ZERO);
    }

    @Override
    public Boolean isFuncionCompleta(Long idFuncion) {
        Funcion funcion = funcionServicio.getFuncionPorId(idFuncion);
        try {
            validarMaximaCantidadDeEspectadoresAFuncion(funcion);
        } catch (InnovaModelException e) {
            return true;
        }
        return false;
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
        HelperFecha.validarFechaAnteriorALaActual(fechaRegistroEspectaculo);

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
        if (cantRegistradosAlEspectaculo >= cantMaximaDelEspectaculo) {
            throw new InnovaModelException("Se llego al maximo de espectadores para esta Funcion");
        }
    }

    //================= OBTENER FUNCIONES POR ESPECTACULO DTO ================//
    @Override
    public List<FuncionDTO> getFuncionesPorIdEspectaculoDTO(Long idEspectaculo) throws SQLException {
        if (idEspectaculo == null) {
            throw new InnovaModelException("El ESPECTACULO es INVÁLIDO!!");
        }
        try {
            return funcionServicio.getFuncionesPorIdEspectaculoDTO(idEspectaculo);
        } catch (BaseDeDatosException e) {
            throw new InnovaModelException(e.getMessage(), e.getCause());
        }
    }
    //================= OBTENER FUNCIONES POR ESPECTACULO DTO ================//

    //==================== AlTA DE FUNCION DTO=======================//
    @Override
    public void altaFuncionDTO(FuncionDTO funcion) {
        Espectaculo espectaculo = new Espectaculo();
        espectaculo.setId(funcion.getIdEspectaculo());
        List<Artista> artistasInvitados = funcion.getArtistasInvitados().stream().map(usuarioDto -> {
            Artista artista = new Artista();
            artista.setId(usuarioDto.getId());
            return artista;
        }).collect(Collectors.toList());
        Funcion nuevaFuncion = new Funcion(funcion.getNombre(), funcion.getIdEspectaculo(), funcion.getFechaInicio(), funcion.getFechaRegistro(),
                artistasInvitados, funcion.getImagen());
        this.altaFuncion(nuevaFuncion, espectaculo);
    }
    //==================== AlTA DE FUNCION DTO=======================//

    //==================== CONSULTA DE FUNCION DTO=======================//
    @Override
    public FuncionDTO getFuncionDTOPorId(Long idFuncion) {
        return funcionServicio.getFuncionDTOPorId(idFuncion);
    }
    //==================== CONSULTA DE FUNCION DTO=======================//

    @Override
    public List<UsuarioDTO> getArtistasInvitadosAFuncionDTO(Long idFuncion) throws SQLException {
        return funcionServicio.getArtistasInvitadosAFuncionDTO(idFuncion);
    }

    @Override
    public Boolean getUsuarioRegistradoEnFuncion(Long idFuncion, Long idUsuario) {
        return funcionServicio.getUsuarioRegistradoEnFuncion(idFuncion, idUsuario);
    }

    @Override
    public List<FuncionDTO> getFuncionesDeUsuarioParaCanjear(Long idUsuario) {
        return funcionServicio.getFuncionesDeUsuarioParaCanjear(idUsuario);
    }
}
