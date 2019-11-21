package edu.eci.cvds.samples.entities;

import java.sql.Time;

public class Horario {
    private Time horaInicio;
    private Time horaFin;

    
    /**
     * El constructor de Horario toma la franja (con hora inicial y final) en forma de String y la 
     * convierte a hora tipo Date.
     * @param horaInicio 
     * @param horaFin 
     */
    public Horario(Time horaInicio,Time horaFin) {         

        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }    

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    






}
    
