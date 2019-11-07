package edu.eci.cvds.persistance.mybatis.mappers;

import edu.eci.cvds.samples.entities.Horario;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface HorarioMapper {
    public void addHorario(@Param ("HorarioObj")Horario horario);
    
    public List<Horario> consultarHorarios();
    
    public Horario consultarHorario(@Param("idHorario") int id);
}
