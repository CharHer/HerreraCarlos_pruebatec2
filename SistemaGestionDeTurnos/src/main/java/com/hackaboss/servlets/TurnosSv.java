
package com.hackaboss.servlets;


import com.hackaboss.logica.ControladoraLogica;
import com.hackaboss.logica.Turno;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "TurnosSv", urlPatterns = {"/TurnosSv"})
public class TurnosSv extends HttpServlet {
    
    ControladoraLogica control = new ControladoraLogica();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Turno> listaTurnos = new ArrayList<Turno>();
        
        listaTurnos = control.getTurnos();
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaTurnos", listaTurnos);
        
        response.sendRedirect("verTurnos.jsp");
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        String numTurno = request.getParameter("numero_turno");
        String descripTramite = request.getParameter("descripcion_tramite");
        String fechaAgendada = request.getParameter("fecha");
        String estado = request.getParameter("estado");

        
        
        
        // Obtener los IDs de las entidades relacionadas
        Long ciudadanoId = Long.parseLong(request.getParameter("ciudadano_id"));
        Long tramiteId = Long.parseLong(request.getParameter("tramite_id"));
        Long usuarioId = Long.parseLong(request.getParameter("usuario_id"));

        control.crearTurno(numTurno, descripTramite, fechaAgendada, estado, ciudadanoId, tramiteId, usuarioId);
        
        
        
        

        response.sendRedirect("index.jsp");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
