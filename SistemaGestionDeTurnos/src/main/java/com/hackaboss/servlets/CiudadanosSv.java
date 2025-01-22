
package com.hackaboss.servlets;

import com.hackaboss.logica.ControladoraLogica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CiudadanosSv", urlPatterns = {"/CiudadanosSv"})
public class CiudadanosSv extends HttpServlet {
    
    ControladoraLogica control = new ControladoraLogica();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String telefono = request.getParameter("telefono");
    String email = request.getParameter("email");
    
    control.crearCiudadano(nombre,apellido,telefono,email);
    
    response.sendRedirect("index.jsp");
         
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
