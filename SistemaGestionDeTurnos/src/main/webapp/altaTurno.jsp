
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>


<%@include file="components/bodyinicio.jsp"%>

<h1>Formulario de alta</h1>
<p>En este apartado se puede crear un turno para poder recibir la atención</p>

<form class="user" action="TurnosSv" method="POST">

    <!-- Campo para número de turno -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="numero_turno" name="numero_turno"
               placeholder="Numero de turno (T-01)" required>
    </div>

    <!-- Campo para descripción del trámite -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="descripcion_tramite" name="descripcion_tramite"
               placeholder="Descripción de trámite (Queja, reporte, consulta, etc.)" required>
    </div>

    <!-- Campo para fecha -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="fecha" name="fecha"
               placeholder="Fecha (aaaa-mm-dd)" required>
    </div>

    <!-- Campo para estado -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="estado" name="estado"
               placeholder="Estado (Espera/Atendido)" required>
    </div>


    

    <!-- Botón para enviar el formulario -->
    <button class="btn btn-primary btn-user btn-block" type="submit"> 
        Crear Turno
    </button>

</form>

<%@include file="components/bodyfinal.jsp"%>
