package edu.eci.cvds.persistance;

import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LEVIATAN
 */
public interface ReservaDAO {
    public void addReserva(Reserva reserva)throws ExcepcionServiciosBiblioteca;
    public List<Reserva> loadReservas();
    public ArrayList<Reserva> loadReservaById(int id);
    public void addReservaRecursiva(Reserva reserva, String periodoReserva) throws ExcepcionServiciosBiblioteca;
    public boolean ReservasDisponbiles (Reserva reserva);

    public ArrayList<Reserva> loadReservaByActiveId(Integer id);

    public void cancelReserva(int idReserva);
    
    
    
}
