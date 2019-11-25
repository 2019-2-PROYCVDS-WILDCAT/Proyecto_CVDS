package edu.eci.cvds.samples.services;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.entities.Usuario;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public interface ServiciosBiblioteca {
    
    public Usuario consultarUsuario(String email) throws PersistenceException;
    public Recurso consultarRecurso (int id) throws PersistenceException;
    public List<Recurso> consultarRecursos() throws PersistenceException;
    public void addRecurso(Recurso recurso) throws PersistenceException;
    public void cambiarEstadoRecurso(int id, String estado) throws PersistenceException;
    public void addHorario(Horario horario)throws PersistenceException;
    public List<Horario> consultarHorarios()throws PersistenceException;
    public Horario consultarHorario(int id)throws PersistenceException;

    public void actualizarRecursoBaja(int id);

    public void addReserva(Reserva newReserva);
    public void addReservaRecursiva(Reserva newReserva, String periodoReserva);
    public List<Reserva> consultarReservas();

    public ArrayList<Reserva> consultarReservasPorId(int id);

    public List<Recurso> consultarRecursosDisponibles() throws PersistenceException;
    
    public boolean reservaDisponibleEnFecha(Reserva reserva) throws PersistenceException;    
    
}