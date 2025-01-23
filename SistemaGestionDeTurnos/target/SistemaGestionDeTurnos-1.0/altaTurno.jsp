
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>


<%@include file="components/bodyinicio.jsp"%>

<h1>Formulario de alta</h1>
<p>En este apartado se puede crear un turno para poder recibir la atención</p>

<form class="user" action="TurnosSv" method="POST">

    <!-- Campo de Número de Turno -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="numero_turno" name="numero_turno"
               placeholder="Número de turno (t01)" required />
    </div>

    <!-- Campo de Descripción del Trámite -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="descripcion_tramite" name="descripcion_tramite"
               placeholder="Descripción de trámite (Queja, Pago, Consulta, Reporte)" required />
    </div>

    <!-- Campo de Fecha Agendada -->
    <div class="col-sm-6 mb-3">
        <input type="date" class="form-control form-control-user" id="fecha" name="fecha"
               placeholder="Fecha (aaaa-mm-dd)" required />
    </div>

    <!-- Campo de Estado -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="estado" name="estado"
               placeholder="Estado (Espera/Atendido)" required />
    </div>

    <!-- Campo de ID del Ciudadano -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="ciudadano_id" name="ciudadano_id"
               placeholder="ID del Ciudadano" required />
    </div>

    <!-- Campo de ID del Trámite -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="tramite_id" name="tramite_id"
               placeholder="ID del Trámite" required />
    </div>

    <!-- Campo de ID del Usuario -->
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="usuario_id" name="usuario_id"
               placeholder="ID del Usuario" required />
    </div>

    <!-- Botón de Enviar -->
    <button class="btn btn-primary btn-user btn-block" type="submit"> 
        Crear Turno
    </button>

    <%@include file="components/bodyfinal.jsp"%>
