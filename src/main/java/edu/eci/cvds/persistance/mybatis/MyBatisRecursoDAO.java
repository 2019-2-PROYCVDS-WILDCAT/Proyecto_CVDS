/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistance.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.persistance.RecursoDAO;
import edu.eci.cvds.persistance.mybatis.mappers.RecursoMapper;
import edu.eci.cvds.samples.entities.Recurso;
import java.util.List;

/**
 *
 * @author 2152805
 */

public class MyBatisRecursoDAO implements RecursoDAO{    

    @Inject
    private RecursoMapper recursoMapper;
    @Override
    public void addRecurso(Recurso recurso) throws PersistenceException {
        try{
            recursoMapper.addRecurso(recurso);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw e;
        }
    }

    @Override
    public List<Recurso> loadRecursos() throws PersistenceException {
        try{
            return recursoMapper.consultarRecursos();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){            
            throw e;
        }
    }

    @Override
    public Recurso loadRecurso(int id) throws PersistenceException {
        try{
            return recursoMapper.consultarRecurso(id);
            
        }        
        catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw e;
        }
    }
       
}