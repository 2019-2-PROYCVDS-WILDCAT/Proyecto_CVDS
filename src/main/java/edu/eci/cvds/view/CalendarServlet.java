/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.persistance.ReservaDAO;
import edu.eci.cvds.samples.entities.Reserva;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.http.HttpServlet;

@WebServlet(
        urlPatterns = "/jsonGetEvents"
)

public class CalendarServlet extends HttpServlet{

    private final ServiciosBiblioteca sb = ServiciosBibliotecaFactory.getServiciosBiblioteca();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<String> optName = Optional.ofNullable(request.getParameter("id"));
        String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
        Integer id = Integer.parseInt(name);
        
       
        ArrayList<Reserva> events = sb.consultarReservasPorIdActivo(id);
        
        String json = new Gson().toJson(events);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        
    }
    
    

}
