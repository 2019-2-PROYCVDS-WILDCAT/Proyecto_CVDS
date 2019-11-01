/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;

/**
 *
 * @author Usuario
 */
public class TestMain {

    public static void main(String[] args) throws PersistenceException{
        ServiciosBiblioteca sb = ServiciosBibliotecaFactory.getServiciosBiblioteca();
        System.out.println(sb.consultarUsuario("hawaii50@mail.com"));
    }
    
}
