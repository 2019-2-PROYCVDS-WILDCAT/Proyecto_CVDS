/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistance.mybatis.mappers;

import edu.eci.cvds.samples.entities.Recurso;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2152805
 */
public interface RecursoMapper {
     public Recurso consultarRecurso(@Param("id") int id);
    
    public List<Recurso> consultarRecursos();
    
    public void addRecurso(@Param("rec") Recurso recurso);
    
}
