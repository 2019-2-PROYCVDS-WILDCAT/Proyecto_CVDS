/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.security;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
/**
 *
 * @author 2152805
 */
public class ApacheShiroLogger implements IniciarSesion{
    
 @Override
    public void login(String email,String contraseña,boolean rememberMe) throws ExcepcionServiciosBiblioteca {
        try{
            Subject usuario = SecurityUtils.getSubject();
            Session sesion = usuario.getSession();
            sesion.setAttribute("email",email);
            if ( !usuario.isAuthenticated() ) {
                UsernamePasswordToken token = new UsernamePasswordToken(email, contraseña);
                token.setRememberMe(true);
                usuario.login(token);                
            }            
            
            
            
        } catch ( IncorrectCredentialsException a ) {
            throw new ExcepcionServiciosBiblioteca("Contraseña incorrecta",a);
        }catch ( UnknownAccountException a ) {
            throw new ExcepcionServiciosBiblioteca("El usuario no está registrado",a);
        } 
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }
}