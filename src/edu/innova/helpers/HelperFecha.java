package edu.innova.helpers;

import edu.innova.exceptions.InnovaModelException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HelperFecha {

    public static Date parsearFecha(String dia, String mes, String anio) {

        try {
            Integer diaInt = Integer.parseInt(dia);
            Integer mesInt = Integer.parseInt(mes) - 1;
            Integer anioInt = Integer.parseInt(anio);

            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setLenient(false);
            calendar.set(anioInt, mesInt, diaInt, 0, 0, 0);
            return calendar.getTime();

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Numeros de fecha inválida", e.getCause());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Fecha invalida", e.getCause());
        }
    }

    public static Date parsearFecha(String dia, String mes, String anio, String hora, String minuto) {

        try {
            Integer diaInt = Integer.parseInt(dia);
            Integer mesInt = Integer.parseInt(mes) - 1;
            Integer anioInt = Integer.parseInt(anio);
            Integer horaInt = Integer.parseInt(hora);
            Integer minutoInt = Integer.parseInt(minuto);

            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setLenient(false);

            calendar.set(anioInt, mesInt, diaInt, horaInt, minutoInt, 0);
            return calendar.getTime();

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Numeros de fecha inválida", e.getCause());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Fecha invalida");
        }
    }
    
    public static void validarFechaAnteriorALaActual(Date fecha) {
        if(fecha.compareTo(new Date()) > 0) {
            throw new InnovaModelException("La fecha ingresada es posterior a la fecha actual");
        }   
    }
    
    public static void validarFechaPosteriorALaActual(Date fecha, String nombreParametro) {
        if(fecha.compareTo(new Date()) < 0) {
            throw new InnovaModelException(String.format("La fecha ingresada [%s] es anterior a la fecha actual", nombreParametro));
        }   
    }
    
    public static Date validarFecha(String fecha, String formato) {
        //"dd/MM/yyyy"
        try {
            return new SimpleDateFormat(formato).parse(fecha);
        } catch (Exception e) {
            throw new IllegalArgumentException("Fecha invalida", e.getCause());
        }
    } 

    public static void main(String[] args) {
        String dia = "30";
        String mes = "04";
        String anio = "1980";
        String hora = "00";
        String minuto = "00";

        Date date = parsearFecha(dia, mes, anio, "23", "0");
        System.err.println(date);

    }

}
