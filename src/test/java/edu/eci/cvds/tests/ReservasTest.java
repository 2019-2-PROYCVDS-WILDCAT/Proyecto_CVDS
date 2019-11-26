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
public class ReservasTest {
    ServiciosBiblioteca serviciosBiblioteca;
    
    public ReservasTest(){

        serviciosBiblioteca = ServiciosBibliotecaFactory.getServiciosBiblioteca();

    }

    @Before
    public void setUp() {
    }    
    
    
}
