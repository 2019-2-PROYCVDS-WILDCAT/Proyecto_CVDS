package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Recurso{

    private int id;
    private String estado;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;

    public Recurso(int id, String estado, String nombre, String ubicacion, String tipo, int capacidad) {
        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
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

    @Override
    public String toString() {
        return "Element { id: " + id + ", nombre: " + nombre + ", ubicacion: " + ubicacion + ", tipo: " + tipo + ", capacidad: " + capacidad + ", estado: " + estado + "}";
    }
    
    
}
