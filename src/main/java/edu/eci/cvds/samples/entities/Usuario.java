package edu.eci.cvds.samples.entities;

import java.io.Serializable;

/**
 * Usuario registrado en la plataforma de la biblioteca, el usuario puede pertenecer a la comunidad o puede ser un administrador de la
 * plataforma. Un usuario de la comunidad puede ver los recursos de la biblioteca y reservarlos si esta registrado mientras que un
 * Administrador de la plataforma puede añadir recursos, cambiar el estado de los recursos y consultar reportes acerca del comportamiento
 * de las reservas
 * @param correo String con el correo electronico de la persona registrada. El correo electronico identifica a un usuario
 * @param nombre String con nombre de la persona registrada en la plataforma de la biblioteca
 * @param apellido String con el apellido de la persona registrada en la plataforma de la biblioteca
 * @param tipo Tipo de usuario de la plataforma este puede ser 1 para Comunidad o 2 para Admisitrador
 * @author AlejandroB
 */
public class Usuario implements Serializable{
    private String correo;
    private String nombre;
    private String apellido;
    private int tipo;
    
    public Usuario(String correo,String nombre, String apellido,int tipo){
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo=" + tipo + '}';
    }
    

    
}