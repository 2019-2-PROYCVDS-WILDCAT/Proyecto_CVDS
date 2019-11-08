package edu.eci.cvds.tests;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author LEVIATAN
 */
public class RecursosTest {
    
    ServiciosBiblioteca serviciosBiblioteca;
    
    public RecursosTest(){

        serviciosBiblioteca = ServiciosBibliotecaFactory.getServiciosBiblioteca();

    }

    @Before
    public void setUp() {
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                                    
//╔════════════════════════════════╦═══════════════════════════════════════════╦═════════════════════════════════╗//
//║ Clases de equivalencia         ║ Limite Inferior   TEST |2|                ║ Limite Superior   TEST |1|      ║//
//╠════════════════════════════════╬═══════════════════════════════════════════╬═════════════════════════════════╣//
//║ Prueba sobre la consulta de un ║ Consultar un recurso inexistente          ║ Consultar un recurso existente. ║//
//║ recurso especifico.            ║ Deberia arrojar un error de persistencia. ║ Deberia consultar el libro      ║//
//║                                ║                                           ║ "The Lusty Argonian Maid"       ║//
//╚════════════════════════════════╩═══════════════════════════════════════════╩═════════════════════════════════╝//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    @Test
    // TEST |2|
    public void deberiaConsultarUnRecursoParticular(){
        try {
            Assert.assertEquals(serviciosBiblioteca.consultarRecurso(3).getNombre(), "The Lusty Argonian Maid");
        } catch (PersistenceException ex) {
            Logger.getLogger(InicioSesionTest.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    // TEST |1|
    @Test
    public void noDeberiaConsultarUnRecursoInexistente(){
        boolean flag = false;
        try {            
            
            serviciosBiblioteca.consultarRecurso(-1);
            
        } catch (PersistenceException ex) {
            flag=true;
            Assert.assertTrue(flag);
        }                        
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    @Test
    public void deberiaPermitirCambiarElEstadoDelRecurso(){
        try {
            String estadoInicial=serviciosBiblioteca.consultarRecurso(3).getEstado();
            if (!estadoInicial.equals("Dañado")){
                serviciosBiblioteca.cambiarEstadoRecurso(3, "Dañado");
            }
            serviciosBiblioteca.cambiarEstadoRecurso(3, "Disponible");
            Assert.assertEquals(serviciosBiblioteca.consultarRecurso(3).getEstado(), "Disponible");
            
        } catch (PersistenceException ex) {
            Logger.getLogger(InicioSesionTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//╔══════════════════════════════╦════════════════════════════════════╦═════════════════════════════════════╦══════════════════════════════════════════════════╗//
//║ Clases de equivalencia       ║ Limite Inferior   TEST |1|         ║ Limite Medio   TEST |2|             ║ Limite Superior   TEST |3|                       ║//
//╠══════════════════════════════╬════════════════════════════════════╬═════════════════════════════════════╬══════════════════════════════════════════════════╣//
//║ Prueba sobre la modificacion ║ Modificar un recurso que no existe ║ Modificar un recurso que no existe  ║ Modificar un Recurso con un estado que no existe ║//
//║ del estado de un recurso     ║ con un estado que no existe        ║                                     ║                                                  ║//
//╚══════════════════════════════╩════════════════════════════════════╩═════════════════════════════════════╩══════════════════════════════════════════════════╝//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    //TEST |1|
    @Test
    public void noDeberiaPermitirEstablecerUnEstadoNoExistente(){
        boolean flag = false;
        try {                
            serviciosBiblioteca.cambiarEstadoRecurso(3, "Estado que no existe");            
            
        } catch (Exception ex) {
            flag = true;
        }        
        Assert.assertTrue(flag);
    }
    
    //TEST |2|
    @Test
    public void noDeberiaPermitirCambiarElEstadoDeUnRecursoNoExistente(){
        boolean flag = false;
        try {                
            serviciosBiblioteca.cambiarEstadoRecurso(-1, "Disponible");
            serviciosBiblioteca.consultarRecurso(-1).getEstado();
            
        } catch (Exception ex) {
            flag = true;
        }        
        Assert.assertTrue(flag);
    }  
    
    //TEST |3|
    @Test
    public void noDeberiaPermitirEstablecerUnEstadoNoExistenteAUnRecursoNoExistente(){
        boolean flag = false;
        try {                
            serviciosBiblioteca.cambiarEstadoRecurso(-1, "Estado que no existe");
            serviciosBiblioteca.consultarRecurso(-1).getEstado();
            
            
        } catch (Exception ex) {
            flag = true;
        }        
        Assert.assertTrue(flag);
    }    
  
}
