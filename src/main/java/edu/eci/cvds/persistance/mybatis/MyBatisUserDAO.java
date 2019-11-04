package edu.eci.cvds.persistance.mybatis;
import com.google.inject.Inject;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.persistance.UserDAO;
import edu.eci.cvds.persistance.mybatis.mappers.UserMapper;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 2152805
 */
public class MyBatisUserDAO implements UserDAO {
    @Inject
    private UserMapper userMapper;
    @Override
    public Usuario load(String email) throws PersistenceException {
        try{
            return userMapper.consultarUsuario(email);
            
        }        
        catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw e;
        }
    }
     
      
}
