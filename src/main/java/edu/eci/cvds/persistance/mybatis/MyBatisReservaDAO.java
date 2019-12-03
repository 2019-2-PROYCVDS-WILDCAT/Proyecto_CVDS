package edu.eci.cvds.persistance.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.ReservaDAO;
import edu.eci.cvds.persistance.mybatis.mappers.ReservaMapper;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.utility.UtilidadFecha;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author LEVIATAN
 */
public class MyBatisReservaDAO implements ReservaDAO{
    private UtilidadFecha utilidadFecha = new UtilidadFecha();
    @Inject
    private ReservaMapper reservaMapper;
    @Override
    public void addReserva(Reserva reserva) throws ExcepcionServiciosBiblioteca{
        if (reserva.getFechaInicioReserva().before(reserva.getFechaFinReserva())){
            reservaMapper.addReserva(reserva);   
        }
        else{
            throw new ExcepcionServiciosBiblioteca("Se introdujo una fecha invalida");
        }
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
    public void addReservaRecursiva(Reserva reserva, String periodoReserva) throws ExcepcionServiciosBiblioteca{
        Timestamp fechaInicio = reserva.getFechaInicioReserva();
        Timestamp fechaFin = reserva.getFechaFinReserva();
        reserva.setTipo("Recurrente");
        try {        
            reserva.setFechaFinReserva(utilidadFecha.intercambiarHoras(fechaInicio.toString(), fechaFin.toString()));
        } catch (ParseException ex) {
            Logger.getLogger(MyBatisReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int intervaloEnDias = utilidadFecha.intervaloEnDias(fechaInicio, fechaFin);
        if(fechaInicio.before(fechaFin)){
            int serial = reservaMapper.maxSerial();
            reserva.setSerial(serial);
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
                        addReserva(reserva); 
                        for (int i=0;i<(intervaloEnDias)/7;i++){

                             
                             Timestamp nuevaFechaInicio =  utilidadFecha.incrementarFecha(reserva.getFechaInicioReserva(),7);
                             reserva.setFechaInicioReserva(nuevaFechaInicio);
                             try {
                                 reserva.setFechaFinReserva(utilidadFecha.intercambiarHoras(nuevaFechaInicio.toString(), fechaFin.toString()));
                                 addReserva(reserva);
                             } catch (ParseException ex) {
                                 Logger.getLogger(MyBatisReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                             }

                        }


                    break;                
                case "Mensual":
                   addReserva(reserva); 
                   for (int i=0;i<(intervaloEnDias)/30;i++){                                                            
                        
                        Timestamp nuevaFechaInicio =  utilidadFecha.incrementarMes(reserva.getFechaInicioReserva(),1);
                        reserva.setFechaInicioReserva(nuevaFechaInicio);
                        try {
                            reserva.setFechaFinReserva(utilidadFecha.intercambiarHoras(nuevaFechaInicio.toString(), fechaFin.toString()));
                            addReserva(reserva);
                        } catch (ParseException ex) {
                            Logger.getLogger(MyBatisReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                   if (intervaloEnDias+1<30 && intervaloEnDias>0){
                       addReserva(reserva);
                   }               
                    break;                 

            }
        }
        else{
            throw new ExcepcionServiciosBiblioteca("Se introdujo una fecha invalida");
        }
        
        
        
                
        
        
    }

    @Override
    public ArrayList<Reserva> loadReservaByActiveId(Integer id) {
        return reservaMapper.consultarReservasActivasPorId(id);
    }


    @Override
    public void cancelReserva(int idReserva, String idUsuarioQueCancela) {
        reservaMapper.cancelarReserva(idReserva,idUsuarioQueCancela);
    }
    
    @Override
    public void cancelReservaRecursiva(Reserva reserva, String idUsuarioQueCancela) {
        Timestamp fechaInicio = reserva.getFechaInicioReserva();
        Timestamp fechaFin = reserva.getFechaFinReserva();
        int intervaloEnDias = utilidadFecha.intervaloEnDias(fechaInicio, fechaFin);
        for (int i=0;i<intervaloEnDias;i++){
            cancelReserva(reserva.getId()+i, idUsuarioQueCancela);
        }
    }

    @Override
    public ArrayList<Reserva> loadReservaByUser(String usuario) {
        return reservaMapper.consultarReservasActivasPorUsuario(usuario);
    }


    @Override
    public ArrayList<Reserva> loadReservaByUserAndIdReserva(String usuario, int idReserva) {
        return reservaMapper.consultarReservasActivasPorUsuarioEIdReserva(usuario,idReserva);
    }

    @Override
    public void deleteUltimaReservaTest() {
        reservaMapper.eliminarUltimaReservaTest();
    }

    @Override
    public List<Reserva> loadReservasRecurrentes() {
        return reservaMapper.consultarReservasRecurrentes(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reserva> loadReservasCanceladas() {
        return reservaMapper.consultarReservasCanceladas(); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
    
}
