/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.exceptions;

/**
 *
 * @author 2152805
 */
public class ExcepcionServiciosBiblioteca extends Exception {
    public ExcepcionServiciosBiblioteca(String message) {
        super(message);
    }
    public ExcepcionServiciosBiblioteca(String message,Throwable w) {
        super(message);
    }
    
}
