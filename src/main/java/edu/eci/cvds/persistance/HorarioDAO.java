
package edu.eci.cvds.persistance;

import edu.eci.cvds.samples.entities.Horario;
import java.util.List;

public interface HorarioDAO {
    public void addHorario(Horario horario) throws PersistenceException;
    public List<Horario> loadHorarios() throws PersistenceException;
    public Horario loadHorario(int id) throws PersistenceException;
}
