package edu.eci.cvds.samples.services.impl;

import javax.inject.Inject;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.persistance.UserDAO;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ServiciosBibliotecaImpl implements ServiciosBiblioteca{
    @Inject
    private UserDAO usuarioDAO;
    @Override
    public Usuario consultarUsuario(String email) throws PersistenceException {
        try{
            return usuarioDAO.load(email);
        }        
         catch (PersistenceException ex) {
            throw new PersistenceException("Error al consultar al usuario con email "+email);
        }
    }
}
    
