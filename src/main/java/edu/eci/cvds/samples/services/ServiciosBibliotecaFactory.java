package edu.eci.cvds.samples.services;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;

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
