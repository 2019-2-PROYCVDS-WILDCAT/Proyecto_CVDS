package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import edu.eci.cvds.view.AdminBean;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.eci.cvds.utility.UtilidadFecha;

public class TestMain {

    public static void main(String[] args) throws ParseException{
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        ServiciosBiblioteca sb = ServiciosBibliotecaFactory.getServiciosBiblioteca();
        System.out.println(7/8);
        
            try {
                long aux1 = formato.parse("2019-11-20 22:22:01").getTime();
                long aux2 = formato.parse("2019-11-29 23:23:01").getTime();

                Timestamp horaInicioR = new Timestamp(aux1);
                Timestamp horaFinR = new Timestamp(aux2);
                Reserva newReserva = new Reserva(0,"perrocanchoso@mail.com", 56,horaInicioR,horaFinR, null,"recurrente");                
                sb.addReservaRecursiva(newReserva, "Diario");
                                
            } catch (ParseException ex) {
                Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
            }        

//        try {
//                SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                long aux1 = formato.parse("2019-11-27 22:22:01").getTime();
//                long aux2 = formato.parse("2019-11-29 23:23:01").getTime();
//                
//                Timestamp horaInicioR = new Timestamp(aux1);
//                Timestamp horaFinR = new Timestamp(aux2);  
//                UtilidadFecha.incrementarFecha(horaInicioR, 1);
//                
//                System.out.println("JAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//                System.out.println(horaInicioR.toString());
//                System.out.println(horaFinR);              
//                System.out.println("---------------------------------");
//                
//                
//                
//                
//                for (int i=0;i<3;i++){                                                       
//                    System.out.println("FECHA INICIAL 1 DIA MAS "+i);
//                    Timestamp nuevaFechaInicio =  UtilidadFecha.incrementarFecha(horaInicioR,i);
//                    System.out.println(nuevaFechaInicio);
//                    
//                    try {
//                        System.out.println("FECHA FINAL INTERCAMBIO");
//                        System.out.println(UtilidadFecha.intercambiarHoras(nuevaFechaInicio.toString(),horaFinR.toString()));
//                    } catch (ParseException ex) {
//                        
//                    }
//                    
//                }
//                
//                                                                                                               
//                System.out.println(horaFinR.getHours());
//                for (int i=0;i<3;i++){
//                    System.out.println(UtilidadFecha.incrementarFecha(horaInicioR, i));
//                }
//        }
//        
//        
//        catch (Exception e){
//            
//        }
        
//        try {
//            String horaInicio="07:00";
//                String horaFin="19:00";
//                SimpleDateFormat formato= new SimpleDateFormat("hh:mm");
//                long aux1 = formato.parse(horaInicio).getTime();
//                long aux2 = formato.parse(horaFin).getTime();
//                Time horaIni = new Time(aux1);
//                Time horaFi=new Time(aux2);
//            ServiciosBiblioteca sb = ServiciosBibliotecaFactory.getServiciosBiblioteca();
//            
//            System.out.println(sb);
//            System.out.println(sb.consultarRecurso(2));
//            System.out.println(sb.consultarRecursos());
//            Recurso recurso = new Recurso(4,"disponible","Guia complementaria para quemar el agua", "Taured","Libro",0,horaIni,horaFi);
//            //sb.addRecurso(recurso);
//            
//            System.out.println(sb.consultarRecurso(4));
//            
//            
//            System.out.println(sb.consultarReservas());
//            
//            //sb.cambiarEstadoRecurso(3, "Disponible");
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
//
//            try {
//                aux1 = format.parse("2019-11-27").getTime();
//                aux2 = format.parse("2019-11-29").getTime();
//
//                Timestamp horaInicioR = new Timestamp(aux1);
//                Timestamp horaFinR = new Timestamp(aux2);
//                Reserva newReserva = new Reserva(0,"perrocanchoso@mail.com", 56,horaInicioR,horaFinR, null,"recurrente");
//                sb.addReserva(newReserva);
//                ArrayList<Reserva> reservas=sb.consultarReservasPorId(1);
//                for(Reserva k : reservas){
//                    System.out.println(k.getFechaInicioReserva());
//                }   
//            } catch (ParseException ex) {
//                Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           
//            
//            
//        } catch (PersistenceException ex) {
//            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    
}
