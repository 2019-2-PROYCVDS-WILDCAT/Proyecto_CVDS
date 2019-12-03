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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.joda.time.DateTime;
import org.joda.time.Interval;

/**
 * Clase con varios metodos estaticos que sirven para manipular fechas tipo Timestamp
 * @author LEVIATAN
 */
public class UtilidadFecha {

    private final ServiciosBiblioteca serviciosBiblioteca = ServiciosBibliotecaFactory.getServiciosBiblioteca();

    public UtilidadFecha() {
    }

    /**
     * Incrementa una fecha un n numero de dias.
     * @param fecha Fecha que se va a elevar un n numero de dias
     * @param numeroDias Numero de dias que corresponde a n.
     * @return Objeto tipo Timestamp al cual ya se le ha hecho el incremento
     */
    public Timestamp incrementarFecha(Timestamp fecha, int numeroDias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, numeroDias);
        Date fechaAux = cal.getTime();
        Timestamp fechaDefinitiva = new Timestamp(fechaAux.getTime());
        return fechaDefinitiva;
    }
    
    /**
     * Incrementa una fecha un n numero de meses
     * @param fecha Fecha que se va a elevar un n numero de dias
     * @param numeroDias Numero de meses que corresponde a n.
     * @return Objeto tipo Timestamp al cual ya se le ha hecho el incremento en meses
     */

    public Timestamp incrementarMes(Timestamp fecha, int numeroMeses) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.MONTH, numeroMeses);
        Date fechaAux = cal.getTime();
        Timestamp fechaDefinitiva = new Timestamp(fechaAux.getTime());
        return fechaDefinitiva;
    }
    
    /**
     * Calcula el numero de dias que hay entre dos fechas
     * @param fechaInicial Fecha inicial para hacer el calculo
     * @param fechaFin Fecha final para hacer el calculo
     * @return Numero entero de dias entre dos fechas
     */

    public int intervaloEnDias(Date fechaInicial, Date fechaFin) {

        int numeroDeDias = (int) ChronoUnit.DAYS.between(fechaInicial.toInstant(), fechaFin.toInstant());
        return numeroDeDias;
    }

    /**
     * Calcula el numero de horas que hay entre dos fechas
     * @param fechaInicial Fecha inicial para hacer el calculo
     * @param fechaFin Fecha final para hacer el calculo
     * @return Numero de horas entre dos fechas
     */
    
    public int intervaloEnHoras(Date horaInicial, Date horaFin) {
        return 1;
    }

    /**
     * Funcion para tomar el formato de horas usado por la plataforma de la biblioteca
     * @return 
     */
    public SimpleDateFormat getFormato() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    /**
     * Intercambia las horas entre dos fechas proporcionadas
     * @param primerFecha 
     * @param segundaFecha
     * @return Timestamp con la primer fecha pero con la hora de la segunda fecha
     * @throws ParseException 
     */
    
    public Timestamp intercambiarHoras(String primerFecha, String segundaFecha) throws ParseException {
        String[] lista1 = primerFecha.split(" ");
        String[] lista2 = segundaFecha.split(" ");
        Timestamp fechaIntercambiada = new Timestamp(getFormato().parse(lista1[0] + " " + lista2[1]).getTime());
        return fechaIntercambiada;
    }
    
    /**
     * Identifica si dos fechas de una reserva se sobrelapan
     * @param idReserva Numero de identificacion de la reserva que se va a comprobar
     * @param fechaInicio 
     * @param fechaFin
     * @return
     * @throws ExcepcionServiciosBiblioteca 
     */

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

    public boolean outOfBoundsDate(String fecha) {
        String fechaString = "2019-12-12 00:00:00";
        Timestamp fechaMax = Timestamp.valueOf(fechaString);
        
        Timestamp tsFecha = Timestamp.valueOf(fecha);
        return !tsFecha.before(fechaMax);
    }

    public boolean oldDate(String fecha) {
        
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Timestamp tsFecha = Timestamp.valueOf(fecha);
        return tsFecha.before(date);
        
        
    }

    
}
