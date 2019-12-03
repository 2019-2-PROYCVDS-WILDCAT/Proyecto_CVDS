package edu.eci.cvds.samples.services;

import edu.eci.cvds.persistance.PersistenceException;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.ReporteHorario;
import edu.eci.cvds.samples.entities.ReporteRecurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.exceptions.ExcepcionServiciosBiblioteca;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public interface ServiciosBiblioteca {
    
    
    /**
     * Consulta un usuario basado en su email
     * @param email email del usuario a buscar
     * @return objeto tipo Usuario
     * @throws PersistenceException 
     */
    public Usuario consultarUsuario(String email) throws PersistenceException;
    
    /**
     * Consulta un Recurso basado en su numero de identificacion
     * @param id Numero con el que se identifica el recurso
     * @return Objeto de tipo Recurso
     * @throws PersistenceException 
     */    
    
    public Recurso consultarRecurso (int id) throws PersistenceException;
    
    /**
     * Consulta todos los recursos que estan registrados en la base de datos     
     * @return Lista de todos los recursos que estan registrados en la base de datos     
     * @throws PersistenceException 
     */    
    
    public List<Recurso> consultarRecursos() throws PersistenceException;
    
    /**
     * Añade un recurso nuevo
     * @param recurso Objeto del recurso que se añadira
     * @throws PersistenceException 
     */
    
    public void addRecurso(Recurso recurso) throws PersistenceException;
    
    /**
     * Cambia el estado de un recurso
     * @param id Numero de identificacion del recurso al que se le va a cambiar el estado
     * @param estado String con el nuevo estado del recurso este puede ser "Dañado" o "Disponible"
     * @throws PersistenceException 
     */
    
    public void cambiarEstadoRecurso(int id, String estado) throws PersistenceException;    
    
    public void addHorario(Horario horario)throws PersistenceException;
    
    public List<Horario> consultarHorarios()throws PersistenceException;
    
    public Horario consultarHorario(int id)throws PersistenceException;

    /**
     * 
     * @param id 
     */
    public void actualizarRecursoBaja(int id);

    /**
     * Añade una nueva reserva a la base de datos
     * @param newReserva Objeto tipo reserva
     * @throws ExcepcionServiciosBiblioteca 
     */
    
    public void addReserva(Reserva newReserva)throws ExcepcionServiciosBiblioteca;
    
    /**
     * Añade una reserva recursiva, es decir añade una reserva un determinado numero de veces en un rango de tiempo (fechaInicio, fechaFin)
     * La reserva Diaria se hace todos los dias en un intervalo de tiempo
     * La reserva Semanal se hace una vez a la semana todas las semanas en un intervalo de tiempo apartir del primer dia de reserva (fechaInicio)
     * La reserva Mensual se hace una vez a al mes, todas los meses en un intervalo de tiempo apartir del primer dia de reserva (fechaInicio)
     * @param newReserva Objeto tipo reserva
     * @param periodoReserva String con el tipo de reserva que sera usado, puede ser "Diario", "Semanal" o "Mensual".
     * @throws ExcepcionServiciosBiblioteca 
     */
    
    public void addReservaRecursiva(Reserva newReserva, String periodoReserva) throws ExcepcionServiciosBiblioteca;

    /**
     * Consulta todas las reservas registradas en la base de datos
     * @return Lista con objetos de tipo Reserva
     */
    
    public List<Reserva> consultarReservas();

    /**
     * Consulta las reservas de un recurso especifico
     * @param id Numero de identificacion del recurso a buscar
     * @return Lista con las reservas que contienen el recurso a buscar
     */
    
    public ArrayList<Reserva> consultarReservasPorId(int id);
    
    /**
     * Lista con todos los recursos disponibles, es decir los recursos que no estan dañados
     * @return Lista de recursos
     * @throws PersistenceException 
     */

    public List<Recurso> consultarRecursosDisponibles() throws PersistenceException;
    
    /**
     * Retorna true o false en caso de que una reserva de un recurso este o no este disponible a la fecha
     * @param reserva
     * @return true si esta disponible a la fecha, false de lo contrario
     * @throws PersistenceException 
     */
    
    public boolean reservaDisponibleEnFecha(Reserva reserva) throws PersistenceException;    

    /**
     * Consulta reservas que se encuentren activas, una reserva activa es una reserva aun vigente hasta la fecha (no cancelada o terminada)
     * @param id Numero de identificacion del recurso de la reserva
     * @return Lista de objetos tipo Reserva
     */
    
    public ArrayList<Reserva> consultarReservasPorIdActivo(Integer id);
    
    /**
     * Cancela una reserva que se encuentre activa
     * @param idReserva Numero de identificacion de la reserva a cancelar
     * @param idUsuarioQueCancela String con el correo del usuario que quiere cancelar la reserva
     */
    
    public void cancelarReserva(int idReserva,String idUsuarioQueCancela);
        
    
    public void cancelarReservaRecursiva(Reserva reserva,String idUsuarioQueCancela);
    
    /**
     * Consulta todas las reservas hechas por un usuario en particular
     * @param usuario String con el correo electronico del usuario del cual se quieren saber las reservas
     * @return lista de objetos tipo Reserva
     */

    public ArrayList<Reserva> consultarReservasPorUsuario(String usuario);
    
    /**
     * Consulta las reservas activas de un usuario particular de un recurso particular
     * @param usuario String con el email del usuario
     * @param idReserva Numero de identificacion del recurso particular del usuario
     * @return Lista de objetos tipo Reserva
     */

    public ArrayList<Reserva> consultarReservasPorUsuario(String usuario, int idReserva);
    
    /**
     * METODO UNICAMENTE UTILIZADO EN PRUEBAS - Elimina la ultima reserva añadida a la base de datos
     * 
     */
    
    public void eliminarUltimaReservaTest();
    
    /**
     * METODO UNICAMENTE UTILIZADO EN PRUEBAS - Elimina el ultimo recurso añadido a la base de datos
     * 
     */    
    
    public void eliminarUltimoRecursoTest();
    
    /**
     * Consultar los recursos que son menos usados en la biblioteca
     * @return 
     */
    
    public List<ReporteRecurso> consultarRecursosMenosUsados();
    
    /**
     * Consulta los recursos que son mas usados en la biblioteca
     * @return 
     */
    
    public List<ReporteRecurso> consultarRecursosMasUsados();
    
    /**
     * Consulta los horarios en los que mas se reservan recursos
     * @return 
     */
    
    public List<ReporteHorario> consultarHorariosMas();
    
    /**
     * Consulta los horarios en los que se menos se reserva recursos
     * @return 
     */
    
    public List<ReporteHorario> consultarHorariosMenos();
   
    
    public List<Reserva> consultarReservasRecurrentes();

    public List<Reserva> reservasCanceladas();
}