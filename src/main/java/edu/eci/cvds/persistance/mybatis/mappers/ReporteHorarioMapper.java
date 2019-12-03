/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistance.mybatis.mappers;

import edu.eci.cvds.samples.entities.ReporteHorario;
import java.util.List;

/**
 *
 * @author AlejandroB
 */
public interface ReporteHorarioMapper {
    public List<ReporteHorario> consultarHorarioMas();
    
    public List<ReporteHorario> consultarHorarioMenos();
}
