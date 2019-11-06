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

public class RegistrarRecursoTest {
    
    ServiciosBiblioteca serviciosBiblioteca;
    
    public RegistrarRecursoTest(){

        serviciosBiblioteca = ServiciosBibliotecaFactory.getServiciosBiblioteca();

    }

    @Before
    public void setUp() {
    }    
    
    public void deberiaConsultarUnRecursoParticular(){
        try {
            Assert.assertEquals(serviciosBiblioteca.consultarRecurso(3).getNombre(), "The Lusty Argonian Maid");
        } catch (PersistenceException ex) {
            Logger.getLogger(InicioSesionTest.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    public void noDeberiaConsultarUnRecursoInexistente(){
        boolean flag = false;
        try {            
            
            serviciosBiblioteca.consultarRecurso(-1);
            
        } catch (PersistenceException ex) {
            flag=true;
            Assert.assertTrue(flag);
        }                        
    } 
    
    public void noDeberiaPermitirAgregarUnRecursoYaExistente(){
        boolean flag = false;
        try {            
            Recurso recurso = new Recurso(4,"disponible","Guia complementaria para quemar el agua", "Taured","Libro",0);
            serviciosBiblioteca.addRecurso(recurso);
           
        } catch (PersistenceException ex) {
            flag=true;
            Assert.assertTrue(flag);
        }
    }        
    
    
}
