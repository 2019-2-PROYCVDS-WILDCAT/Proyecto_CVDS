package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.utility.UtilidadFecha;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;

@SuppressWarnings("deprecation")
@ManagedBean(name = "registrosBean")
@SessionScoped
public class RegistrosBean extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;
    private int idReserva;
    private String tipoRecurso, horaInicioReserva, horaFinReserva, tipoReserva, tipoApartado;
    private String hDisponibleInicio, hDisponibleFin, fechaInicio, fechaFin, nombreRecurso;
    private UtilidadFecha utilidadFecha = new UtilidadFecha();
    private Recurso selectedRec;
    private String estado;
    private List<Recurso> recursos;
    private String usuario,tipoUsuario;

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
            add("Diario");
            add("Semanal");
            add("Mensual");
        }
    };

    public List<Recurso> getRecursos() {

        try {
            return serviciosBiblioteca.consultarRecursosDisponibles();
        } catch (PersistenceException ex) {
            Logger.getLogger(RecursosBean.class.getName()).log(Level.SEVERE, null, ex);
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

    public String getUsuario() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            String user = session.getAttribute("email").toString();
            return user;
        } catch (java.lang.NullPointerException e) {
            return "";
        }

    }

    public void crearFechas() {

        fechaInicio = fechaInicio.replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$1-$2") + " " + horaInicioReserva + ":00";
        fechaFin = fechaFin.replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$1-$2") + " " + horaFinReserva + ":00";
    }

    public void registrarReservaNormal() throws ParseException {
        if (!tipoRecurso.equals("Libro")) {
            fechaFin = fechaInicio;
        }Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        //Unir fechas con horas
        crearFechas();
        //Castear a timeStamp
        Timestamp tsFechaInicio = Timestamp.valueOf(fechaInicio);
        Timestamp tsFechaFin = Timestamp.valueOf(fechaFin);
        try {
            if (!utilidadFecha.isOverlapping(idReserva, new DateTime(tsFechaInicio.getTime()), new DateTime(tsFechaFin.getTime()))) {
                //Insertar reserva
                Reserva reservaInsert = new Reserva(0, usuario, idReserva, tsFechaInicio, tsFechaFin, date, "Normal");
                try {
                    serviciosBiblioteca.addReserva(reservaInsert);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva realizada correctamente.", ""));
                    
                } catch (org.apache.ibatis.exceptions.PersistenceException e) {
                    
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tiempo m\u00e1ximo de reserva: 2horas",""));
                                            }
            }else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La reserva se cruza con una existente.", ""));
            }
        } catch (ExcepcionServiciosBiblioteca ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
        }

    }

    public void registrarReservaRecurrente() throws ParseException {

        try {
            Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            
            crearFechas();
            Timestamp tsFechaInicio = Timestamp.valueOf(fechaInicio);
            Timestamp tsFechaFin = Timestamp.valueOf(fechaFin);
            Reserva reservaInsert = new Reserva(0, usuario, idReserva, tsFechaInicio, tsFechaFin, date, "Recurrente");
            if (!utilidadFecha.isOverlapping(idReserva, new DateTime(tsFechaInicio.getTime()), new DateTime(tsFechaFin.getTime()))) {
                try {
                    serviciosBiblioteca.addReservaRecursiva(reservaInsert, this.tipoApartado);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reserva realizada correctamente.", ""));
                } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tiempo m\u00e1ximo de reserva: 2 horas.",""));
                    
                }
            } else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La reserva se cruza con una existente.", ""));
            }
        } catch (ExcepcionServiciosBiblioteca ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
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

    public void goToCalendar(int idReserva, String tipo, String horaInicio, String horaFin, String nombreRecurso) throws IOException {
        setTipoU();
        this.usuario = getUsuario();
        this.idReserva = idReserva;
        this.tipoRecurso = tipo;
        this.hDisponibleInicio = horaInicio;
        this.hDisponibleFin = horaFin;
        this.nombreRecurso = nombreRecurso;
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Calendar/calendar.xhtml");
    }

    public String getTipoApartado() {
        return tipoApartado;
    }
    public void setTipoU(){
        try{
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            if (currentUser.hasRole("comunidad")){
                setTipoUsuario("comunidad");
            }else if(currentUser.hasRole("administrador")){
                setTipoUsuario("administrador");
            }else{
              setTipoUsuario("none"); 
            }
        }catch(java.lang.NullPointerException ex){
            setTipoUsuario("none");
        }
    }
    
    

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }
    public void volver() throws IOException{
        
        try{
            Subject currentUser = SecurityUtils.getSubject();
            Session session = currentUser.getSession();
            if (currentUser.hasRole("comunidad")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/secure/Comunidad.xhtml");
            }else if(currentUser.hasRole("administrador")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/secure/Administrador.xhtml");
            }else{
              FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/public.xhtml");  
            }
        }catch(java.lang.NullPointerException ex){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/public.xhtml");
        }
    }

}
