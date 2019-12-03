/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.ReporteHorario;
import edu.eci.cvds.samples.entities.ReporteRecurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AlejandroB
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "adminBean")
@SessionScoped

public class AdminBean extends BasePageBean{
    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;
    private List<ReporteRecurso> recursosMasUsados;
    private List<ReporteRecurso> recursosMenosUsados;
    private List<ReporteHorario> horariosMas;
    private List<ReporteHorario> horariosMenos;
    private List<Reserva> reservasRecurrentes;

    
    public ServiciosBiblioteca getServiciosBiblioteca() {
        return serviciosBiblioteca;
    }

    public void setServiciosBiblioteca(ServiciosBiblioteca serviciosBiblioteca) {
        this.serviciosBiblioteca = serviciosBiblioteca;
    }

    public List<ReporteRecurso> getRecursosMasUsados() {
        return serviciosBiblioteca.consultarRecursosMasUsados();
    }

    public void setRecursosMasUsados(List<ReporteRecurso> recursosMasUsados) {
        this.recursosMasUsados = recursosMasUsados;
    }

    public List<ReporteRecurso> getRecursosMenosUsados() {
        return serviciosBiblioteca.consultarRecursosMenosUsados();
    }

    public void setRecursosMenosUsados(List<ReporteRecurso> recursosMenosUsados) {
        this.recursosMenosUsados = recursosMenosUsados;
    }

    public List<ReporteHorario> getHorariosMas() {
        return serviciosBiblioteca.consultarHorariosMas();
    }

    public void setHorariosMas(List<ReporteHorario> horariosMas) {
        this.horariosMas = horariosMas;
    }

    public List<ReporteHorario> getHorariosMenos() {
        return serviciosBiblioteca.consultarHorariosMenos();
    }

    public void setHorariosMenos(List<ReporteHorario> horariosMenos) {
        this.horariosMenos = horariosMenos;
    }

    public List<Reserva> getReservasRecurrentes() {
        return serviciosBiblioteca.consultarReservasRecurrentes();
    }

    public void setReservasRecurrentes(List<Reserva> reservasRecurrentes) {
        this.reservasRecurrentes = reservasRecurrentes;
    }
    
    
    
}
