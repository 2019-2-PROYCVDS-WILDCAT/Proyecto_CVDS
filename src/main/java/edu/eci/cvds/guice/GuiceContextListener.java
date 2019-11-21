package edu.eci.cvds.guice;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistance.*;
import edu.eci.cvds.persistance.mybatis.*;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.impl.ServiciosBibliotecaImpl;
import edu.eci.cvds.security.ApacheShiroLogger;
import edu.eci.cvds.security.IniciarSesion;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // TODO Add service class associated to Stub implementation

               bind(UserDAO.class).to(MyBatisUserDAO.class);
               bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
               bind(ReservaDAO.class).to(MyBatisReservaDAO.class);
               bind(HorarioDAO.class).to(MyBatisHorarioDAO.class);
               bind(IniciarSesion.class).to(ApacheShiroLogger.class);
               bind(ServiciosBiblioteca.class).to(ServiciosBibliotecaImpl.class);
              
               

            }
        });  

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}