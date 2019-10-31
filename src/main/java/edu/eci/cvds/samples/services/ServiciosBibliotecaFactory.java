/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import com.google.inject.Injector;

import org.mybatis.guice.XMLMyBatisModule;
import static com.google.inject.Guice.createInjector;
import edu.eci.cvds.persistance.UserDAO;
import edu.eci.cvds.persistance.mybatis.MyBatisUserDAO;
import edu.eci.cvds.samples.services.impl.ServiciosBibliotecaImpl;
import org.mybatis.guice.datasource.helper.JdbcHelper;


public class ServiciosBibliotecaFactory {
    private static ServiciosBibliotecaFactory instance = new ServiciosBibliotecaFactory();
    private static Injector inyector;
    
    private ServiciosBibliotecaFactory(){
        inyector = createInjector(new XMLMyBatisModule(){
        @Override
        protected void initialize(){
            install(JdbcHelper.PostgreSQL);                                    
            setClassPathResource("mybatis-config.xml");
            bind(UserDAO.class).to(MyBatisUserDAO.class);
            bind(ServiciosBiblioteca.class).to(ServiciosBibliotecaImpl.class);
        }
            
        });
    }
    
    public static ServiciosBiblioteca getServiciosBiblioteca(){
        return inyector.getInstance(ServiciosBiblioteca.class);
    }
    
    public static ServiciosBibliotecaFactory getInstance(){
        return instance;
    }
}
