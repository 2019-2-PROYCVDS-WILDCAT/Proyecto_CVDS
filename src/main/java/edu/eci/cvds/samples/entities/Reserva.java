/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author LEVIATAN
 */
public class Reserva {
    private String idUsuario,tipo;
    private int id,idRecurso;
    Date fechaReserva;
    Timestamp fechaInicioReserva,fechaFinReserva; 
    boolean activo;
    int serial;

    public Reserva(int id,String idUsuario, int idRecurso, Timestamp fechaInicioReserva, Timestamp fechaFinReserva, Date fechaReserva, String tipo,boolean activo, int serial) {
        this.id=id;
        this.idUsuario = idUsuario;        
        this.idRecurso = idRecurso;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechaFinReserva = fechaFinReserva;
        this.fechaReserva=fechaReserva;
        this.tipo = tipo;
        this.activo=activo;
        this.serial=serial;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Timestamp getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(Timestamp fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public Timestamp getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(Timestamp fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idUsuario=" + idUsuario + ", tipo=" + tipo + ", id=" + id + ", idRecurso=" + idRecurso + ", fechaReserva=" + fechaReserva + ", fechaInicioReserva=" + fechaInicioReserva + ", fechaFinReserva=" + fechaFinReserva + ", activo=" + activo + '}';
    }

    


    
    
    
}
