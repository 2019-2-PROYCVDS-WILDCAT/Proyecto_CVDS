/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistance.mybatis;
import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.persistance.UserDAO;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 2152805
 */
public class MyBatisUserDAO implements UserDAO {
    @Inject
    private Usuario UserMapper;
    @Override
    public Usuario load(String email) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
      
}
