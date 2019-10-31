/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.security;

import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;

/**
 *
 * @author 2152805
 */
public interface IniciarSesion {
    public void login(String email,String contraseña,boolean rememberMe) throws ExcepcionServiciosBiblioteca;
    public boolean isLogged();
}
