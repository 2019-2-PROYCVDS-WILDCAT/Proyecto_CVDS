package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
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
@ManagedBean(name = "recursosBean")
@SessionScoped

public class RecursosBean extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;
    private Recurso selectedRec;
    private List<Recurso> recursos;
    private List<Recurso> recursosDisponibles;
    private String nombre, ubicacion, tipo, estado,reserva;
    private int capacidad;
    private String horaInicio;
    private String horaFin;
   
    ArrayList<String> tipos = new ArrayList<String>() {
        {
            add("Tipo");
            add("Dispositivo multimedia");
            add("Libro");
            add("Sala de estudio");
        }
    };
    ArrayList<String> estados = new ArrayList<String>() {
        {
            add("Disponible");
            add("Dañado");

        }
    };


    public ServiciosBiblioteca getServiciosBiblioteca() {
        return serviciosBiblioteca;
    }

    public void setServiciosBiblioteca(ServiciosBiblioteca serviciosBiblioteca) {
        this.serviciosBiblioteca = serviciosBiblioteca;
    }

    public List<Recurso> getRecursos() {

        try {
            return serviciosBiblioteca.consultarRecursos();
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public Recurso getSelectedRec() {
        return selectedRec;
    }

    public void setSelectedRec(Recurso selectedRec) {
        this.selectedRec = selectedRec;
    }

    public void registrarRecurso() throws PersistenceException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm");
        long aux1 = formato.parse(horaInicio).getTime();
        long aux2 = formato.parse(horaFin).getTime();
        Time horaInicioC = new Time(aux1);
        Time horaFinC = new Time(aux2);
        Recurso newRec = new Recurso(0, "Disponible", this.nombre, this.ubicacion, this.tipo, this.capacidad, horaInicioC, horaFinC);
        serviciosBiblioteca.addRecurso(newRec);
        
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    private void clear() {
        this.capacidad = 0;
        this.nombre = "";
        this.tipo = "";
        this.ubicacion = "";
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public void modificarEstado(int id) throws PersistenceException {

        serviciosBiblioteca.cambiarEstadoRecurso(id, this.estado);

    }

    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Cambiado", "Estado cambiado a: " + estado));

    }



    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }





    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public List<Recurso> getRecursosDisponibles() {
        
        try {
            return serviciosBiblioteca.consultarRecursosDisponibles();
        } catch (PersistenceException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void setRecursosDisponibles(List<Recurso> recursosDisponibles) {
        this.recursosDisponibles = recursosDisponibles;
    }
    

    
    
}
