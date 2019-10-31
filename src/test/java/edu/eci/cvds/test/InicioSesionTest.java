/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.test;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author Usuario
 */
public class InicioSesionTest {
    @Inject
    private SqlSession sqlSession;
    ServiciosBiblioteca serviciosBiblioteca;
    
    public InicioSesionTest(){
        serviciosBiblioteca=ServiciosBibliotecaFactory.getServiciosBiblioteca();
    }

    @Before
    public void setUp() {
    }

    
    @Test
    public void consultarNombresConEmail() throws PersistenceException {
        System.out.println(serviciosBiblioteca.consultarUsuario("hawaii50@mail.com"));
        Assert.assertEquals(serviciosBiblioteca.consultarUsuario("hawaii50@mail.com"),"Mohammed");
    }
    
}
