package edu.eci.cvds.persistance.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Usuario;

/**
 *
 * @author 2106913
 */
public interface UserMapper {
    
    public Usuario consultarUsuario(@Param("correo") String email); 
}
