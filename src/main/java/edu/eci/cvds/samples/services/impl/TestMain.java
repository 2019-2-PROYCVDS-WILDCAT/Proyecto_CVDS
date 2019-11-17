/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import edu.eci.cvds.view.AdminBean;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class TestMain {

    public static void main(String[] args) throws ParseException{
        try {
            String horaInicio="07:00";
                String horaFin="19:00";
                SimpleDateFormat formato= new SimpleDateFormat("hh:mm");
                long aux1 = formato.parse(horaInicio).getTime();
                long aux2 = formato.parse(horaFin).getTime();
                Time horaIni = new Time(aux1);
                Time horaFi=new Time(aux2);
            ServiciosBiblioteca sb = ServiciosBibliotecaFactory.getServiciosBiblioteca();
            
            System.out.println(sb);
            System.out.println(sb.consultarRecurso(2));
            System.out.println(sb.consultarRecursos());
            Recurso recurso = new Recurso(4,"disponible","Guia complementaria para quemar el agua", "Taured","Libro",0,horaIni,horaFi);
            //sb.addRecurso(recurso);
            
            System.out.println(sb.consultarRecurso(4));
            
 
            
            sb.cambiarEstadoRecurso(3, "Disponible");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

            try {
                aux1 = format.parse("2019-11-27").getTime();
                aux2 = format.parse("2019-11-29").getTime();

                Date horaInicioR = new Date(aux1);
                Date horaFinR = new Date(aux2);
                Reserva newReserva = new Reserva(0,"hawaii50@mail.com","recurrente",6,horaInicioR,horaFinR);
                sb.addReserva(newReserva);
            } catch (ParseException ex) {
                Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            
        } catch (PersistenceException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
