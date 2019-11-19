package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.persistance.ReservaDAO;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.entities.TipoUsuario;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.shiro.authc.UsernamePasswordToken;
import edu.eci.cvds.security.ApacheShiroLogger;
import edu.eci.cvds.security.IniciarSesion;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;


@SuppressWarnings("deprecation")
@ManagedBean(name = "registrosBean")
@SessionScoped
public class RegistrosBean extends BasePageBean{
    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;    
    private String horaInicioReserva;
    private String horaFinReserva;
    private String tipoReserva;
    private Recurso selectedRec;
    private String estado;
    private List<Recurso> recursos;    
    ArrayList<String> reservas = new ArrayList<String>() {
        {
            add("1 Hora");
            add("2 Horas");
            add("3 Horas");
            add("4 Horas");
            add("5 Horas");

        }
    };
    private ArrayList<String> horarios = new ArrayList<String>() {
        {
            add("7:00-8:30");
            add("8:30-10:00");
            add("10:00-11:30");
            add("11:30-13:00");
            add("13:00-14:30");
            add("14:30-16:00");
            add("16:00-17:30");
            add("17:30-19:00");
        }
    };
    private ArrayList<String> tiposReserva = new ArrayList<String>() {
        {
            add("Comun");
            add("Recurrente");            
        }
    };    
    
    public List<Recurso> getRecursos() {

        try {
            return serviciosBiblioteca.consultarRecursos();
        } catch (PersistenceException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<String> getTiposReserva() {
        return tiposReserva;
    }

    public void setTiposReserva(ArrayList<String> tiposReserva) {
        this.tiposReserva = tiposReserva;
    }
    
    
    
    public void registrarReserva(Usuario usuario){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            long aux1 = formato.parse(horaInicioReserva).getTime();
            long aux2 = formato.parse(horaFinReserva).getTime();
                    
            Timestamp horaInicioR = new Timestamp(aux1);
            Timestamp horaFinR = new Timestamp(aux2);
            Reserva newReserva= new Reserva(0,usuario.getCorreo(),this.selectedRec.getId(),horaInicioR,horaFinR, null, this.tipoReserva);
            serviciosBiblioteca.addReserva(newReserva);
        } catch (ParseException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Recurso getSelectedRec() {
        return selectedRec;
    }

    public void setSelectedRec(Recurso selectedRec) {
        this.selectedRec = selectedRec;
    }    
    
    public String getHoraInicioReserva() {
        return horaInicioReserva;
    }

    public void setHoraInicioReserva(String horaInicioReserva) {
        this.horaInicioReserva = horaInicioReserva;
    }

    public String getHoraFinReserva() {
        return horaFinReserva;
    }

    public void setHoraFinReserva(String horaFinReserva) {
        this.horaFinReserva = horaFinReserva;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }    
    

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios;
    }    
    
    public ArrayList<String> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<String> reservas) {
        this.reservas = reservas;
    }
    
    public ServiciosBiblioteca getServiciosBiblioteca() {
        return serviciosBiblioteca;
    }

    public void setServiciosBiblioteca(ServiciosBiblioteca serviciosBiblioteca) {
        this.serviciosBiblioteca = serviciosBiblioteca;
    }    
    public ArrayList<Reserva> consultarReservasPorId(int id){
        return serviciosBiblioteca.consultarReservasPorId(id);
        
    }
    
}
