
<%@page import="java.util.List"%>
<%@page import="com.hackaboss.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file="components/header.jsp"%>


    <%@include file="components/bodyinicio.jsp"%>

    <h2>Bienvenido</h2>

    <!-- Búsqueda por estado-->
    <div>
    <h3 class="mt-4">Búsqueda</h3>
    <form action="BuscarTurnosSv" method="GET">
        <div class="form-group">
            <label for="busquedaPorEstado" >Buscar por Estado:</label>
            <input type="text" class="form-control form-control-sm" id="busquedaEstado" name="busquedaEstado" style="max-width: 300px;" placeholder="Espera">
        </div> 
        
        <button type="submit" class="btn btn-primary btn-sm">Buscar</button>  
    </form>
</div>

    <div class="results-table mt-4">

        <h3 >Resultados</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Número de turno</th>
                    <th>Trámite</th>
                    <th>Fecha</th>
                    <th>Estado</th>
                </tr>    
            </thead>
            <tbody>
                <%                   
                    List<Turno> listaTurnos = (List) request.getSession().getAttribute("listaTurnos");
                    if (listaTurnos != null) {

                        for (Turno turn:listaTurnos) { 
                %>
                <tr>
                    <td> <%=turn.getNumeroTurno()%> </td>
                    <td> <%=turn.getDescripcionTramite()%>  </td>
                    <td> <%=turn.getFechaAgendada()%>  </td>
                    <td> <%=turn.getEstado()%>  </td>

                </tr>      
                <% } %>
            </tbody>  
            <% } %>
        </table> 
    </div>


    <!-- Scripts de Bootstrap -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  




    <%@include file="components/bodyfinal.jsp"%>
