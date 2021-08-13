package edu.innova.helpers;

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
            throw new IllegalArgumentException("Numeros de fecha inválida");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Fecha invalida");
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
            throw new IllegalArgumentException("Numeros de fecha inválida");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Fecha invalida");
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
