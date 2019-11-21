/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistance;
import edu.eci.cvds.samples.entities.Usuario;

/**
 *
 * @author 2152805
 */
public interface UserDAO {
     
    public Usuario load(String email) throws PersistenceException;      
}



