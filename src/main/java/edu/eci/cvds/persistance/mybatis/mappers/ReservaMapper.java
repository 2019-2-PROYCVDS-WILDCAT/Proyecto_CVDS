/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistance.mybatis.mappers;

import edu.eci.cvds.samples.entities.Reserva;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author LEVIATAN
 */
public interface ReservaMapper {
    public void addReserva(@Param("reserva") Reserva reserva);
    
}
