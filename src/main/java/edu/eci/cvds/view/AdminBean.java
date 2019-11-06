/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
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
import javax.faces.context.FacesContext;

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
    private List<String> estados;
    private List<Recurso> recursos;
    private List<Recurso> filteredRec;

    public List<String> getEstados() {
        estados = new ArrayList<String>();
        estados.add("Prestado");
        estados.add("Disponible");
        estados.add("Dañado");
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

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

    public List<Recurso> getFilteredRec() {
        return filteredRec;
    }

    public void setFilteredRec(List<Recurso> filteredRec) {
        this.filteredRec = filteredRec;
    }

    
    
   
    

}