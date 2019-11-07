package edu.eci.cvds.samples.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Horario {
    private int id;
    private String franja;
    private Date horaFranja;

    public Horario(int id, String franja) {
        this.id = id;
        this.franja = franja;
        DateFormat sdf = new SimpleDateFormat("hh:mm");        
        try{
            this.horaFranja = sdf.parse(franja);
        }
        catch (Exception e){
            System.out.println(e.getMessage()+"FUNEEEEEEEE MESSAGE ");
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

    public Date getHoraFranja() {
        return horaFranja;
    }

    public void setHoraFranja(Date horaFranja) {
        this.horaFranja = horaFranja;
    }



    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", franja=" + franja + '}';
    }

}
    
