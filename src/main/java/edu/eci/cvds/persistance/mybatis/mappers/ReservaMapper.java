package edu.eci.cvds.persistance.mybatis.mappers;

import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author LEVIATAN
 */
public interface ReservaMapper {
    public void addReserva(@Param("reserva") Reserva reserva);

    public List<Reserva> consultarReservas();

    public ArrayList<Reserva> consultarReservasPorId(@Param("idRecurso")int id);
    
}
