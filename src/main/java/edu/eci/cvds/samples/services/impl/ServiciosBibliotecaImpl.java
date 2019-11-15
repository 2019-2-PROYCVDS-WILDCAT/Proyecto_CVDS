package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.HorarioDAO;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.persistance.RecursoDAO;
import edu.eci.cvds.persistance.UserDAO;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ServiciosBibliotecaImpl implements ServiciosBiblioteca{
    @Inject
    private UserDAO usuarioDAO;
    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private HorarioDAO horarioDAO;
    
    @Override
    public Usuario consultarUsuario(String email) throws PersistenceException {
        try{
            return usuarioDAO.load(email);
        }        
         catch (PersistenceException ex) {
            throw ex;
        }        
    }
    @Override
    public Recurso consultarRecurso (int id) throws PersistenceException{
        try{
            return recursoDAO.loadRecurso(id);
        }        
         catch (PersistenceException ex) {
            throw ex;
        }
    }
    
    @Override
    public List<Recurso> consultarRecursos() throws PersistenceException{
        try{
            return recursoDAO.loadRecursos();
        }        
         catch (PersistenceException ex) {
            throw ex;
        }        
    }
    
    @Override
    public void addRecurso(Recurso recurso,List<String> horariosSeleccionados) throws PersistenceException{
        try{
            recursoDAO.addRecurso(recurso);
            for (String hora:horariosSeleccionados){
                String[] horas=hora.split("-");
                String horaInicio=horas[0];
                String horaFin=horas[1];
                SimpleDateFormat formato= new SimpleDateFormat("hh:mm");
                long aux1 = formato.parse(horaInicio).getTime();
                long aux2 = formato.parse(horaFin).getTime();
                System.out.println("COÑOOOO");
                Time horaIni = new Time(aux1);
                Time horaFi=new Time(aux2);
                System.out.println(horaIni);
                System.out.println(horaFi);
                horarioDAO.addHorario(new Horario(horaIni,horaFi));
            }
        }
        catch(PersistenceException ex){
            throw ex;
        } catch (ParseException ex) {
            Logger.getLogger(ServiciosBibliotecaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addHorario(Horario horario) throws PersistenceException {
        try{
            horarioDAO.addHorario(horario);
            
        }
        catch(PersistenceException ex){
            throw ex;
        }
    }

    @Override
    public List<Horario> consultarHorarios() throws PersistenceException {
        try{
            return horarioDAO.loadHorarios();
        }
        catch (PersistenceException ex){
            throw ex;
        }
    }

    @Override
    public Horario consultarHorario(int id) throws PersistenceException {
        try{
            return horarioDAO.loadHorario(id);
        }
        catch (PersistenceException ex){
            throw ex;
        }
    }

    @Override
    public void cambiarEstadoRecurso(int id, String estado) throws PersistenceException {
        try{
            recursoDAO.updateEstadoRecurso(id, estado);
        }
        catch(PersistenceException ex){
            throw ex;
        }
    }

    @Override
    public void actualizarRecursoBaja(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
    
