/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistance.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.ReporteHorarioDAO;
import edu.eci.cvds.persistance.mybatis.mappers.ReporteHorarioMapper;
import edu.eci.cvds.samples.entities.ReporteHorario;
import edu.eci.cvds.samples.entities.ReporteRecurso;
import java.util.List;

/**
 *
 * @author AlejandroB
 */
public class MyBatisReporteHorarioDAO implements ReporteHorarioDAO{
    @Inject
    private ReporteHorarioMapper reporteHorarioMapper;
    
    @Override
    public List<ReporteHorario> loadHorariosMas() {
        return reporteHorarioMapper.consultarHorarioMas();
    }

    @Override
    public List<ReporteHorario> loadHorariosMenos() {
        return reporteHorarioMapper.consultarHorarioMenos();
    }
    
}
