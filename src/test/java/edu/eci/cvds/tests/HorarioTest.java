package edu.eci.cvds.tests;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class HorarioTest {
    ServiciosBiblioteca serviciosBiblioteca;

    public HorarioTest(){

        serviciosBiblioteca = ServiciosBibliotecaFactory.getServiciosBiblioteca();

    }

    @Before
    public void setUp() {
    }
    
    
    
}
