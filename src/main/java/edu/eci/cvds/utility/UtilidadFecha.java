/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author LEVIATAN
 */
public class UtilidadFecha {
    
    public static Timestamp incrementarFecha(Timestamp fecha, int numeroDias){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, numeroDias);
        Date fechaAux=cal.getTime();        
        Timestamp fechaDefinitiva = new Timestamp (fechaAux.getTime());        
        return fechaDefinitiva;        
    }
    
    public static Timestamp incrementarMes(Timestamp fecha,int numeroMeses){
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.MONTH, numeroMeses);
        Date fechaAux=cal.getTime();        
        Timestamp fechaDefinitiva = new Timestamp (fechaAux.getTime());        
        return fechaDefinitiva; 
    }
    
    public static int intervaloEnDias(Date fechaInicial, Date fechaFin){        
        
        int numeroDeDias = (int)ChronoUnit.DAYS.between(fechaInicial.toInstant(), fechaFin.toInstant());
        return numeroDeDias;
    }
    
    public static int intervaloEnHoras(Date horaInicial, Date horaFin){
        return 1;
    }
    
    public static Timestamp intercambiarHoras(String primerFecha, String segundaFecha) throws ParseException{
        String[] lista1=primerFecha.split(" ");
        String[] lista2=segundaFecha.split(" ");
        Timestamp fechaIntercambiada = new Timestamp (getFormato().parse(lista1[0]+" "+lista2[1]).getTime());
        return fechaIntercambiada;                
    }
    
    public static SimpleDateFormat getFormato(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }
}
