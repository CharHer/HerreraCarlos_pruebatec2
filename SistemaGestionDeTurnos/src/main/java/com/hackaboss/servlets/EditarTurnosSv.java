
package com.hackaboss.servlets;

import com.hackaboss.logica.ControladoraLogica;
import com.hackaboss.logica.Turno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "EditarTurnosSv", urlPatterns = {"/EditarTurnosSv"})
public class EditarTurnosSv extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long id = Long.parseLong(request.getParameter("id"));
        
        Turno turn = control.traerTurno(id);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("turnEditar", turn);
        
        response.sendRedirect("editarTurno.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String numTurno = request.getParameter("numero_turno");
        String descTramite = request.getParameter("descripción_tamite");
        String fecha = request.getParameter("fecha");
        String estado = request.getParameter("estado");
        
        Turno turn = (Turno) request.getSession().getAttribute("turnEditar");
        turn.setNumeroTurno(numTurno);
        turn.setDescripcionTramite(descTramite);
        turn.setFechaAgendada(fecha);
        turn.setEstado(estado);
        
        control.editarTurno(turn);
        
        response.sendRedirect("TurnosSv");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
