/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author 2146516
 */
@SuppressWarnings("deprecation")
@ManagedBean(name="LoginBean")
@SessionScoped

public class LoginBean extends BasePageBean{
    private String email;
    private String contraseña;
    private boolean recordarUsuario = true;
    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;
    @Inject
    private IniciarSesion log;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isRecordarusuario() {
        return recordarUsuario;
    }

    public void setRecordarusuario(boolean recordarUsuario) {
        this.recordarUsuario = recordarUsuario;
    }
    
    public void iniciarSesion() throws PersistenceException{
        try {
            
            log.login(this.email, this.contraseña, this.recordarUsuario);
            Usuario user = serviciosBiblioteca.consultarUsuario(this.email);
            int tipo = user.getTipo();
            
            switch (tipo){
                case 2:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/secure/Administrador.xhtml"); 
                    break;
                case 1:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/secure/Comunidad.xhtml"); 
                    break;
            }
                   
                    
        } catch (ExcepcionServiciosBiblioteca ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void cerrarSesion(){        
        try {
            log.logout();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/login.xhtml");
            System.out.println("Ya cerre");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}