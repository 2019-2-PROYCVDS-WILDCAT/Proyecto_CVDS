/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
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
            Recurso recurso = new Recurso(4,"disponible","Guia complementaria para quemar el agua", "Taured","Libro",0);
            //sb.addRecurso(recurso);
            System.out.println(sb.consultarRecurso(4));
            Horario horario = new Horario(4,"11:30");
            //sb.addHorario(horario);
            System.out.println(sb.consultarHorario(1));
            System.out.println(sb.consultarHorarios());
            
        } catch (PersistenceException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
