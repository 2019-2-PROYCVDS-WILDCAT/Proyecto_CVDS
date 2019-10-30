/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 *
 * @author 2146516
 */
@SuppressWarnings("deprecation")
@ManagedBean(name="LoginBean")
@SessionScoped

public class LoginBean extends BasePageBean{
    private UsernamePasswordToken token;
    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;
    
    public void iniciarSesion(String email, String contraseña){
        
    }
    public void cerrarSesion(){
        
    }
}