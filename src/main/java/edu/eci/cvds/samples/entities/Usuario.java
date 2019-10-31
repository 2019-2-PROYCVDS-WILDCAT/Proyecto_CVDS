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
public class Usuario {
    private String correo;
    private String nombre;
    private String apellido;

    
    public Usuario(String correo,String nombre, String apellido){
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
    }
   

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }


    

    
}