
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>


<%@include file="components/bodyinicio.jsp"%>

<h1>Formulario de alta</h1>
<p>En este apartado se puede registrar a un nuevo ciudadano</p>

<form class="user" class="user" action="CiudadanosSv" method="POST">

    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
               placeholder="Nombre">
    </div>
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
               placeholder="Apellido">
    </div>
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
               placeholder="Teléfono">
    </div>
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="email" name="email"
               placeholder="Email de contacto">
    </div>

    <button class="btn btn-primary btn-user btn-block" type="submit"> 
        Registrar
    </button>

</form>

<%@include file="components/bodyfinal.jsp"%>