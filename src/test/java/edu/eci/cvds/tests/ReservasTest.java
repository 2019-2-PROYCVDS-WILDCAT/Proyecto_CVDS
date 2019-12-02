package edu.eci.cvds.tests;

import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.view.RecursosBean;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author LEVIATAN
 */
public class ReservasTest {
    ServiciosBiblioteca serviciosBiblioteca;
    Reserva reservaTest;
    
    public ReservasTest(){
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   
        serviciosBiblioteca = ServiciosBibliotecaFactory.getServiciosBiblioteca();
            try {
                long aux1 = formato.parse("2019-11-29 16:22:01").getTime();
                long aux2 = formato.parse("2019-11-29 18:23:01").getTime();

                Timestamp horaInicioR = new Timestamp(aux1);
                Timestamp horaFinR = new Timestamp(aux2);
                reservaTest = new Reserva(0,"perrocanchoso@mail.com", 59,horaInicioR,horaFinR, null,"normal",true,0);
                                
            } catch (ParseException ex) {
                Logger.getLogger(RecursosBean.class.getName()).log(Level.SEVERE, null, ex);
            }        

    }

    @Before
    public void setUp() {
    }    
    
//╔═════════════════════════════════╦════════════════════════════════════╦═════════════════════════════════════╦════════════════════════════════════╗
//║ Clases de equivalencia          ║ Limite Inferior   TEST |1|         ║ Limite Medio   TEST |2|             ║ Limite Superior TEST |3|           ║
//╠═════════════════════════════════╬════════════════════════════════════╬═════════════════════════════════════╬════════════════════════════════════╣
//║ Prueba sobre una reserva        ║ FechaInicioReserva<FechaFinReserva ║ FechaInicioReserva==FechaFinReserva ║ FechaInicioReserva>FechaFinReserva ║
//║ con diferentes fechas de inicio ║                                    ║                                     ║                                    ║
//║ de reserva                      ║                                    ║                                     ║                                    ║
//╚═════════════════════════════════╩════════════════════════════════════╩═════════════════════════════════════╩════════════════════════════════════╝
    @Test
    //TEST /1/
    public void deberiaAgregarReservaConFechaInicioMenorAFechaFin(){
        boolean flag = true;
        cambiarFechaReservaTest("2019-11-28 14:22:01","2019-11-29 16:22:01");
        try{
            serviciosBiblioteca.addReserva(reservaTest);
        }
        catch(ExcepcionServiciosBiblioteca e){
            flag = false;            
        }
        Assert.assertTrue(flag);        
        serviciosBiblioteca.eliminarUltimaReservaTest();
    }
    
    @Test
    //TEST /2/
    public void noDeberiaAgregarReservaConFechaInicioIgualAFechaFinal(){
        boolean flag = false;
        cambiarFechaReservaTest("2019-11-28 17:22:01","2019-11-28 17:22:01");
        try{
            serviciosBiblioteca.addReserva(reservaTest);
        }
        catch(ExcepcionServiciosBiblioteca e){
            flag = true;            
        }
        Assert.assertTrue(flag);        
            
    }
    
    @Test
    //TEST /3/
    public void noDeberiaAgregarReservaConFechaInicioMayorAFechaFinal(){
        boolean flag = false;
        cambiarFechaReservaTest("2019-11-30 13:22:01","2019-11-28 11:22:01");
        try{
            serviciosBiblioteca.addReserva(reservaTest);
        }
        catch(ExcepcionServiciosBiblioteca e){
            flag = true;            
        }
        Assert.assertTrue(flag);                    
    }
    
    
//╔═════════════════════════════════════╦════════════════════════════════════╦═════════════════════════════════════╦════════════════════════════════════╗
//║ Clases de equivalencia              ║ Limite Inferior   TEST |1|         ║ Limite Medio   TEST |2|             ║ Limite Superior TEST |3|           ║
//╠═════════════════════════════════════╬════════════════════════════════════╬═════════════════════════════════════╬════════════════════════════════════╣
//║ Prueba sobre una reserva recurrente ║ FechaFinReserva<FechaInicioReserva ║ FechaFinReserva==FechaInicioReserva ║ FechaFinReserva>FechaInicioReserva ║
//║ con diferentes fechas de final      ║                                    ║                                     ║                                    ║
//║ de reserva                          ║                                    ║                                     ║                                    ║
//╚═════════════════════════════════════╩════════════════════════════════════╩═════════════════════════════════════╩════════════════════════════════════╝
    
    @Test
    //TEST /1/
    public void noDeberiaAgregarReservaRecurrenteConFechaInicioMayorAFechaFinal(){
        boolean flag = false;
        cambiarFechaReservaTest("2019-11-28 15:22:01","2019-11-29 12:22:01");
        try{
            serviciosBiblioteca.addReservaRecursiva(reservaTest,"Diario");
        }
        catch(ExcepcionServiciosBiblioteca e){
            flag = true;            
        }
        Assert.assertTrue(flag);                    
    }
    
    @Test
    //TEST /2/
    public void noDeberiaAgregarReservaRecurrenteConFechaInicioIgualAFechaFinal(){
        boolean flag = false;
        cambiarFechaReservaTest("2019-11-28 11:22:01","2019-11-28 11:22:01");
        try{
            serviciosBiblioteca.addReservaRecursiva(reservaTest,"Diario");
        }
        catch(ExcepcionServiciosBiblioteca e){
            flag = true;            
        }
        Assert.assertTrue(flag);                    
    }    
    
    @Test
    //TEST /3/
    public void deberiaAgregarReservaRecurrenteConFechaInicioMenorAFechaFinal(){
        boolean flag = true;
        cambiarFechaReservaTest("2019-11-27 11:22:01","2019-11-28 11:42:01");
        try{
            serviciosBiblioteca.addReservaRecursiva(reservaTest,"Diario");
        }
        catch(ExcepcionServiciosBiblioteca e){
            flag = false;                
        }
        Assert.assertTrue(flag);                    
        serviciosBiblioteca.eliminarUltimaReservaTest();
        serviciosBiblioteca.eliminarUltimaReservaTest();
    }    
    
    

    private void cambiarFechaReservaTest(String fechaInicioReserva, String fechaFinReserva){
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
            Timestamp fechaInicial = new Timestamp(formato.parse(fechaInicioReserva).getTime());
            Timestamp fechaFinal = new Timestamp(formato.parse(fechaFinReserva).getTime());
            reservaTest.setFechaInicioReserva(fechaInicial);
            reservaTest.setFechaFinReserva(fechaFinal);
        }
        catch(ParseException ex){
            Logger.getLogger(RecursosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
}
