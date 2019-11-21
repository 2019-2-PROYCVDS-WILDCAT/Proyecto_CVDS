package edu.eci.cvds.persistance.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.HorarioDAO;
import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.persistance.mybatis.mappers.HorarioMapper;
import edu.eci.cvds.samples.entities.Horario;
import java.util.List;

public class MyBatisHorarioDAO implements HorarioDAO{
    @Inject
    private HorarioMapper horarioMapper;

    @Override
    public void addHorario(Horario horario) throws PersistenceException {
        try{
            horarioMapper.addHorario(horario);
        }
        catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw e;
        }
    }
    

    @Override
    public List<Horario> loadHorarios() throws PersistenceException {
        try{
            return horarioMapper.consultarHorarios();
        }
        catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw e;
        }
    }

    @Override
    public Horario loadHorario(int id) throws PersistenceException {
        try{
            return horarioMapper.consultarHorario(id);
        }
        catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw e;
        }
    }

    
    
            
}
