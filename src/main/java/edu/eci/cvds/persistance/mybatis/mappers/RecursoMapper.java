package edu.eci.cvds.persistance.mybatis.mappers;

import edu.eci.cvds.samples.entities.Recurso;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface RecursoMapper {
     public Recurso consultarRecurso(@Param("id") int id);
    
    public List<Recurso> consultarRecursos();
    
    public void addRecurso(@Param("rec") Recurso recurso);
    
}
