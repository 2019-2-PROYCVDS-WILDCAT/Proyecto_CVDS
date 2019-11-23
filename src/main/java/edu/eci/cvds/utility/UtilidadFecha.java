/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.utility;

import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.joda.time.DateTime;
import org.joda.time.Interval;

/**
 *
 * @author LEVIATAN
 */
public class UtilidadFecha {

    private final ServiciosBiblioteca serviciosBiblioteca = ServiciosBibliotecaFactory.getServiciosBiblioteca();

    public UtilidadFecha() {
    }

    public Timestamp incrementarFecha(Timestamp fecha, int numeroDias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, numeroDias);
        Date fechaAux = cal.getTime();
        Timestamp fechaDefinitiva = new Timestamp(fechaAux.getTime());
        return fechaDefinitiva;
    }

    public Timestamp incrementarMes(Timestamp fecha, int numeroMeses) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.MONTH, numeroMeses);
        Date fechaAux = cal.getTime();
        Timestamp fechaDefinitiva = new Timestamp(fechaAux.getTime());
        return fechaDefinitiva;
    }

    public int intervaloEnDias(Date fechaInicial, Date fechaFin) {

        int numeroDeDias = (int) ChronoUnit.DAYS.between(fechaInicial.toInstant(), fechaFin.toInstant());
        return numeroDeDias;
    }

    public int intervaloEnHoras(Date horaInicial, Date horaFin) {
        return 1;
    }

    public SimpleDateFormat getFormato() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    public Timestamp intercambiarHoras(String primerFecha, String segundaFecha) throws ParseException {
        String[] lista1 = primerFecha.split(" ");
        String[] lista2 = segundaFecha.split(" ");
        Timestamp fechaIntercambiada = new Timestamp(getFormato().parse(lista1[0] + " " + lista2[1]).getTime());
        return fechaIntercambiada;
    }

    public boolean isOverlapping(int idReserva, DateTime fechaInicio, DateTime fechaFin) throws ExcepcionServiciosBiblioteca {
        try {
            Interval intervaloInicio = new Interval(fechaInicio, fechaFin);
            for (Reserva reserva : serviciosBiblioteca.consultarReservasPorId(idReserva)) {
                Interval intervaloFinal = new Interval(reserva.getFechaInicioReserva().getTime(), reserva.getFechaFinReserva().getTime());
                if (intervaloInicio.overlaps(intervaloFinal)) {
                    return true;
                }

            }
            return false;
        } catch (java.lang.IllegalArgumentException ex) {
            throw new ExcepcionServiciosBiblioteca("La fecha de reserva debe ser mayor.");
            
        }

    }
}
