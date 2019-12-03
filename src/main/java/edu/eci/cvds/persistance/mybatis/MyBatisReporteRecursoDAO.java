/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistance.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.ReporteRecursoDAO;
import edu.eci.cvds.persistance.mybatis.mappers.ReporteRecursoMapper;
import edu.eci.cvds.samples.entities.ReporteRecurso;
import java.util.List;

/**
 *
 * @author AlejandroB
 */
public class MyBatisReporteRecursoDAO implements ReporteRecursoDAO{
    @Inject
    private ReporteRecursoMapper reporteRecursoMapper;
    @Override
    public List<ReporteRecurso> loadRecursosMasUsados() {
        return reporteRecursoMapper.consultarRecursosMasUsados();
    }

    @Override
    public List<ReporteRecurso> loadRecursosMenosUsados() {
        return reporteRecursoMapper.consultarRecursosMenosUsados();
    }
    
}
