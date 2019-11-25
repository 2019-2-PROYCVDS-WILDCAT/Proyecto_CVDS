package edu.eci.cvds.persistance.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.ReservaDAO;
import edu.eci.cvds.persistance.mybatis.mappers.ReservaMapper;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.utility.UtilidadFecha;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;


/**
 *
 * @author LEVIATAN
 */
public class MyBatisReservaDAO implements ReservaDAO{
    private UtilidadFecha utilidadFecha = new UtilidadFecha();
    @Inject
    private ReservaMapper reservaMapper;
    @Override
    public void addReserva(Reserva reserva) {
        reservaMapper.addReserva(reserva);   
    }
    @Override
    public List<Reserva> loadReservas(){
        return reservaMapper.consultarReservas();
    }

    @Override
    public ArrayList<Reserva> loadReservaById(int id) {
        return reservaMapper.consultarReservasPorId(id);
    }
    
    @Override
    public boolean ReservasDisponbiles(Reserva reserva) {
        Integer cantidadReservas=reservaMapper.reservaDisponibleEnFecha(reserva.getIdRecurso(),reserva.getFechaInicioReserva(),reserva.getFechaFinReserva());        
        if (cantidadReservas==0){
            return true;
        }
        else{
            return false;
        }        
        
    }    

    @Override
    public void addReservaRecursiva(Reserva reserva, String periodoReserva) {
        Timestamp fechaInicio = reserva.getFechaInicioReserva();
        Timestamp fechaFin = reserva.getFechaFinReserva();
        try {        
            reserva.setFechaFinReserva(utilidadFecha.intercambiarHoras(fechaInicio.toString(), fechaFin.toString()));
        } catch (ParseException ex) {
            Logger.getLogger(MyBatisReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int intervaloEnDias = utilidadFecha.intervaloEnDias(fechaInicio, fechaFin);  
        switch (periodoReserva){
            case "Diario":
                for (int i=0;i<intervaloEnDias+1;i++){                                                            
                    addReserva(reserva); 
                    Timestamp nuevaFechaInicio =  utilidadFecha.incrementarFecha(reserva.getFechaInicioReserva(),1);
                    reserva.setFechaInicioReserva(nuevaFechaInicio);
                    try {
                        reserva.setFechaFinReserva(utilidadFecha.intercambiarHoras(nuevaFechaInicio.toString(), fechaFin.toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(MyBatisReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                                           
                }
                break;   
            case "Semanal":
               for (int i=0;i<(intervaloEnDias+1)/7;i++){
                    
                    addReserva(reserva); 
                    Timestamp nuevaFechaInicio =  utilidadFecha.incrementarFecha(reserva.getFechaInicioReserva(),7);
                    reserva.setFechaInicioReserva(nuevaFechaInicio);
                    try {
                        reserva.setFechaFinReserva(utilidadFecha.intercambiarHoras(nuevaFechaInicio.toString(), fechaFin.toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(MyBatisReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                                           
                }
                break;                
            case "Mensual":
               for (int i=0;i<(intervaloEnDias+1)/30;i++){                                                            
                    addReserva(reserva); 
                    Timestamp nuevaFechaInicio =  utilidadFecha.incrementarMes(reserva.getFechaInicioReserva(),1);
                    reserva.setFechaInicioReserva(nuevaFechaInicio);
                    try {
                        reserva.setFechaFinReserva(utilidadFecha.intercambiarHoras(nuevaFechaInicio.toString(), fechaFin.toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(MyBatisReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                                           
                }
                break;                 
                
        }
        
        
        
                
        
        
    }


    
    
    
    
}
