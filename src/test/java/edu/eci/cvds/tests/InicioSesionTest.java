package edu.eci.cvds.tests;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InicioSesionTest {
    
    ServiciosBiblioteca serviciosBiblioteca;
    
    public InicioSesionTest(){
        
        serviciosBiblioteca = ServiciosBibliotecaFactory.getServiciosBiblioteca();
        
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void deberiaConsultarInformacionDeUsuarioConCorreo(){
        try {
            Assert.assertEquals(serviciosBiblioteca.consultarUsuario("hawaii50@mail.com").toString(), "Usuario{correo=hawaii50@mail.com, nombre=Mohammed, apellido=McLovin}");
        } catch (PersistenceException ex) {
            Logger.getLogger(InicioSesionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
