/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class TestMain {

    public static void main(String[] args){
        try {
            ServiciosBiblioteca sb = ServiciosBibliotecaFactory.getServiciosBiblioteca();
            System.out.println(sb);
            System.out.println(sb.consultarRecurso(2));
            System.out.println(sb.consultarRecursos());
            
        } catch (PersistenceException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
