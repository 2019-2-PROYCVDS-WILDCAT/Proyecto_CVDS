package edu.eci.cvds.samples.services;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.persistance.UserDAO;
import edu.eci.cvds.samples.entities.Usuario;


public interface ServiciosBiblioteca {
    
    public Usuario consultarUsuario(String email) throws PersistenceException;
}