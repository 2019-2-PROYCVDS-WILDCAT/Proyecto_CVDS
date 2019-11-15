package edu.eci.cvds.samples.services;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.List;


public interface ServiciosBiblioteca {
    
    public Usuario consultarUsuario(String email) throws PersistenceException;
    public Recurso consultarRecurso (int id) throws PersistenceException;
    public List<Recurso> consultarRecursos() throws PersistenceException;
    public void addRecurso(Recurso recurso,List<String> horariosSeleccionados) throws PersistenceException;
    public void cambiarEstadoRecurso(int id, String estado) throws PersistenceException;
    public void addHorario(Horario horario)throws PersistenceException;
    public List<Horario> consultarHorarios()throws PersistenceException;
    public Horario consultarHorario(int id)throws PersistenceException;

    public void actualizarRecursoBaja(int id);

    
    
}