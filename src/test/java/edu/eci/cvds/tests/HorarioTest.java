package edu.eci.cvds.tests;
import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import java.util.ArrayList;
import java.util.List;
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
    //@Test
    public void deberiaInsertarDisponibilidad() throws PersistenceException{
        ArrayList<String> tipos = new ArrayList<String>() { 
            {
                add("07:00-08:30");
                add("08:30-10:00");
            }};
        //serviciosBiblioteca.addRecurso(new Recurso(0,"Disponible","Prueba definitiva XD","F-204","Libro",22,"07:00","07:00"), tipos);
    }
    
    
    
}
