/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author AlejandroB
 */
public class ReporteHorario {
    private String franja;
    private long cantidad;

    public ReporteHorario(String franja, long cantidad) {
        this.franja = franja;
        this.cantidad = cantidad;
    }
    
    public String getFranja() {
        return franja;
    }

    public void setFranja(String franja) {
        this.franja = franja;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
