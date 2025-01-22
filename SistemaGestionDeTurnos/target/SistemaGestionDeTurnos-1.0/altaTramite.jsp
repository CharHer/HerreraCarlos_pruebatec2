
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>


<%@include file="components/bodyinicio.jsp"%>

<h1>Formulario de alta</h1>
<p>En este apartado se puede crear un nuevo tipo de trámite</p>

<form class="user" class="user" action="TramitesSv" method="POST">

    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="tipo_tramite" name="tipo_tramite"
               placeholder="Tipo de tramite">
    </div>

    <button class="btn btn-primary btn-user btn-block" type="submit"> 
        Crear Tramite
    </button>

</form>

<%@include file="components/bodyfinal.jsp"%>