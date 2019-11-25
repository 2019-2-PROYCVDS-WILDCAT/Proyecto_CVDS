package edu.eci.cvds.persistance;

import edu.eci.cvds.samples.entities.Reserva;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LEVIATAN
 */
public interface ReservaDAO {
    public void addReserva(Reserva reserva);
    public List<Reserva> loadReservas();
    public ArrayList<Reserva> loadReservaById(int id);
    public void addReservaRecursiva(Reserva reserva, String periodoReserva);
    public boolean ReservasDisponbiles (Reserva reserva);
    
    
    
}
