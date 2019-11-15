/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.TipoUsuario;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.shiro.authc.UsernamePasswordToken;
import edu.eci.cvds.security.ApacheShiroLogger;
import edu.eci.cvds.security.IniciarSesion;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

/**
 *
 * @author 2146516
 */
@SuppressWarnings("deprecation")
@ManagedBean(name="recursosBean")
@SessionScoped

public class AdminBean extends BasePageBean{
    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;
    private Recurso selectedRec;
    private List<Recurso> recursos;
    private List<Horario> horarios;
    private List<String> horariosSeleccionados;
    private String nombre,ubicacion,tipo,estado;
    private int capacidad;
    private int idActual;
    ArrayList<String> tipos = new ArrayList<String>() { 
            {
                add("Tipo");
                add("Dispositivo multimedia"); 
                add("Libro"); 
                add("Sala de estudio"); 
            } 
        }; 
    ArrayList<String> estados = new ArrayList<String>() { 
            {
                add("Disponible");
                add("Dañado"); 
                
            } 
        }; 

    public ServiciosBiblioteca getServiciosBiblioteca() {
        return serviciosBiblioteca;
    }

    public void setServiciosBiblioteca(ServiciosBiblioteca serviciosBiblioteca) {
        this.serviciosBiblioteca = serviciosBiblioteca;
    }

    public List<Recurso> getRecursos() {
        
        try {
            return serviciosBiblioteca.consultarRecursos();
        } catch (PersistenceException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public Recurso getSelectedRec() {
        return selectedRec;
    }

    public void setSelectedRec(Recurso selectedRec) {
        this.selectedRec = selectedRec;
    }
    public void registrarRecurso() throws PersistenceException{
        
        Recurso newRec = new Recurso(0,"Disponible",this.nombre,this.ubicacion,this.tipo,this.capacidad);
        serviciosBiblioteca.addRecurso(newRec,horariosSeleccionados);        
        this.clear();
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

    private void clear() {
        this.capacidad =0;
        this.nombre = "";
        this.tipo ="";
        this.ubicacion ="";
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
    }

    public List<Horario> getHorarios() {
        
        try {
            return serviciosBiblioteca.consultarHorarios();
        } catch (PersistenceException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }

    public int getIdActual() {
        return idActual;
    }

    public void setIdActual(int idActual) {
        this.idActual = idActual;
    }
    
    
    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
    public void actualizarRecursoBaja(int id){
        serviciosBiblioteca.actualizarRecursoBaja(id);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }
    
    
    
}