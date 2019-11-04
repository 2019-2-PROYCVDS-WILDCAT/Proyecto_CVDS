package edu.eci.cvds.samples.entities;

public class Usuario {
    private String correo;
    private String nombre;
    private String apellido;  
    private TipoUsuario tipo;
    
    public Usuario(String correo,String nombre, String apellido, TipoUsuario tipo){
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
     
    }
    
    public Usuario (String correo, String nombre, String apellido){
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
    
    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", nombre=" + nombre + ", apellido=" + apellido+'}';
    }    
    
}