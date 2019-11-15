package edu.eci.cvds.samples.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Horario {
    private int id;
    private String franja;
    private Date horaInicioFranja;
    private Date horaFinFranja;

    
    /**
     * El constructor de Horario toma la franja (con hora inicial y final) en forma de String y la 
     * convierte a hora tipo Date.
     * @param id identificador del horario
     * @param franja Horario de la franja que incluye fin y comienzo de la franja en forma de string
     */
    public Horario(int id, String franja) {
        this.id = id;
        String[] franjaLista = franja.split("-");        
        DateFormat sdf = new SimpleDateFormat("hh:mm");        
        try{
            this.horaInicioFranja = sdf.parse(franjaLista[0]);
            this.horaFinFranja = sdf.parse(franjaLista[1]);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFranja() {
        return franja;
    }

    public void setFranja(String franja) {
        this.franja = franja;
    }

    public Date getHoraInicioFranja() {
        return horaInicioFranja;
    }

    public void setHoraInicioFranja(Date horaInicioFranja) {
        this.horaInicioFranja = horaInicioFranja;
    }

    public Date getHoraFinFranja() {
        return horaFinFranja;
    }

    public void setHoraFinFranja(Date horaFinFranja) {
        this.horaFinFranja = horaFinFranja;
    }





    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", franja=" + franja + '}';
    }

}
    
