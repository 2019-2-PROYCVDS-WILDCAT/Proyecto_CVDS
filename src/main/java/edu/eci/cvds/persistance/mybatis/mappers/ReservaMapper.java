package edu.eci.cvds.persistance.mybatis.mappers;

import edu.eci.cvds.samples.entities.Reserva;
import java.sql.Timestamp;
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
    
    public Integer reservaDisponibleEnFecha(@Param("idRecurso") int id, @Param("fechaInicio") Timestamp fechaInicio, @Param("fechaFin") Timestamp fechaFin);

    public ArrayList<Reserva> consultarReservasActivasPorId(@Param("idRecurso")int id);

    public void cancelarReserva(@Param("idReserva")int idReserva,@Param("idUsuarioQueCancela") String idUsuarioQueCancela);

    public ArrayList<Reserva> consultarReservasActivasPorUsuario(@Param("idUsuario")String usuario);

    public ArrayList<Reserva> consultarReservasActivasPorUsuarioEIdReserva(@Param("idUsuario")String usuario,@Param("idRecurso") int idRecurso);

    public void eliminarUltimaReservaTest();
    
    public int maxSerial();

    public List<Reserva> consultarReservasRecurrentes();
    
}
