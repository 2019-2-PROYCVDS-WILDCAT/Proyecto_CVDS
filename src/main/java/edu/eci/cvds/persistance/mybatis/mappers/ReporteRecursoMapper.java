package edu.eci.cvds.persistance.mybatis.mappers;

import edu.eci.cvds.samples.entities.ReporteRecurso;
import java.util.List;



public interface ReporteRecursoMapper {
    
    public List<ReporteRecurso> consultarRecursosMasUsados();
    
    public List<ReporteRecurso> consultarRecursosMenosUsados();

    
}
