package edu.eci.cvds.samples.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Horario {
    private int id;
    private Date franja;

    public Horario(int id, String franja) throws ParseException {
        this.id = id;
        DateFormat sdf = new SimpleDateFormat("hh:mm");        
        this.franja = sdf.parse(franja);
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFranja() {
        return franja;
    }

    public void setFranja(Date franja) {
        this.franja = franja;
    }

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", franja=" + franja + '}';
    }

}
    
