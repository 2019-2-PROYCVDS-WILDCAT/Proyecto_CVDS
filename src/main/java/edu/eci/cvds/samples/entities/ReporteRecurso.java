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
public class ReporteRecurso {
    private int id;
    private String nombre;
    private long numeroUsos;

    public ReporteRecurso(int id, String nombre, long numeroUsos) {
        this.id = id;
        this.nombre = nombre;
        this.numeroUsos = numeroUsos;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNumeroUsos() {
        return numeroUsos;
    }

    public void setNumeroUsos(long numeroUsos) {
        this.numeroUsos = numeroUsos;
    }

    @Override
    public String toString() {
        return "ReporteRecurso{" + "id=" + id + ", nombre=" + nombre + ", numeroUsos=" + numeroUsos + '}';
    }
    
    
}
