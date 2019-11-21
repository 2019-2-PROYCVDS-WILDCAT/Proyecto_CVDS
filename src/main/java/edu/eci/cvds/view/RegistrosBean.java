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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

@SuppressWarnings("deprecation")
@ManagedBean(name = "registrosBean")
@SessionScoped
public class RegistrosBean extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;
    private int idReserva;
    private String tipoRecurso, horaInicioReserva, horaFinReserva, tipoReserva, tipoApartado;
    private String hDisponibleInicio, hDisponibleFin, fechaInicio, fechaFin;

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
    private ArrayList<String> tiposApartado = new ArrayList<String>() {
        {
            add("Diaria");
            add("Semanal");
            add("Mensual");
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

    public ArrayList<String> getTiposApartado() {
        return tiposApartado;
    }

    public void setTiposReserva(ArrayList<String> tiposApartado) {
        this.tiposApartado = tiposApartado;
    }

    public void registrarReservaNormal() throws ParseException {
        //Sacar Usuario
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        String usuario = session.getAttribute("email").toString();
        if (!tipoRecurso.equals("Libro")) {
            fechaInicio = fechaFin;
        }
        //Unir fechas con horas
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String fechaInicioString = fechaInicio.replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$1-$2") + " " + horaInicioReserva +":00";
        String fechaFinString = fechaFin.replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$1-$2") + " " + horaFinReserva+":00";
        //Castear a timeStamp
        Timestamp tsFechaInicio = Timestamp.valueOf(fechaInicioString);
        Timestamp tsFechaFin = Timestamp.valueOf(fechaFinString);
        //Insertar reserva
        Reserva reservaInsert = new Reserva(0,usuario,idReserva,tsFechaInicio,tsFechaFin,date, "Normal");
        serviciosBiblioteca.addReserva(reservaInsert);
        
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

    public ArrayList<Reserva> consultarReservasPorId(int id) {
        return serviciosBiblioteca.consultarReservasPorId(id);

    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String gethDisponibleInicio() {
        return hDisponibleInicio;
    }

    public void sethDisponibleInicio(String hDisponibleInicio) {
        this.hDisponibleInicio = hDisponibleInicio;
    }

    public String gethDisponibleFin() {
        return hDisponibleFin;
    }

    public void sethDisponibleFin(String hDisponibleFin) {
        this.hDisponibleFin = hDisponibleFin;
    }

    public void goToCalendar(int idReserva, String tipo, String horaInicio, String horaFin) throws IOException {
        this.idReserva = idReserva;
        this.tipoRecurso = tipo;
        this.hDisponibleInicio = horaInicio;
        this.hDisponibleFin = horaFin;
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/secure/Calendar/calendar.xhtml");
    }

    public String getTipoApartado() {
        return tipoApartado;
    }

    public void setTipoApartado(String tipoApartado) {
        this.tipoApartado = tipoApartado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

}
