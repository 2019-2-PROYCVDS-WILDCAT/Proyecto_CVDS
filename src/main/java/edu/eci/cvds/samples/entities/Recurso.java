package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Recurso implements Serializable{

    private int id;
    private String estado;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;
    private Time horaInicio;
    private Time horaFin;

    public Recurso(int id, String estado, String nombre, String ubicacion, String tipo, int capacidad,Time horaInicio,Time horaFin) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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
    
    @Override
    public String toString() {
        return "Element { id: " + id + ", nombre: " + nombre + ", ubicacion: " + ubicacion + ", tipo: " + tipo + ", capacidad: " + capacidad + ", estado: " + estado + "}";
    }
    
    
}
