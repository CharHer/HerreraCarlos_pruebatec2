
<%@page import="com.hackaboss.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>


<%@include file="components/bodyinicio.jsp"%>

<h1>Edición de turnos</h1>
<p>En este apartado para actualizar un turno</p>

<%    
    Turno turn = (Turno) request.getSession().getAttribute("turnEditar");
%>

<form class="user" action="EditarTurnosSv" method="POST">

    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="numero_turno" name="numero_turno"
               placeholder="Numero de turno (T-01)" value="<%= turn.getNumeroTurno()%>">
    </div>
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="descripción_tamite" name="descripción_tamite"
               placeholder="Descripción de trámite (Queja, reporte, consulta,etc.)" value="<%= turn.getDescripcionTramite()%>">
    </div>
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="fecha" name="fecha"
               placeholder="Fecha(aaaa-mm-dd)" value="<%= turn.getFechaAgendada()%>">
    </div>
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="estado" name="estado"
               placeholder="Estado (Espera/Atendido)" value=" <%=turn.getEstado()%> ">
    </div>


    <button class="btn btn-primary btn-user btn-block" type="submit"> 
        Guardar cambios
    </button>

</form>

<%@include file="components/bodyfinal.jsp"%>
