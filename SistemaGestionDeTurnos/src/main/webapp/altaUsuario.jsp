
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>

<body>
    <h1>Alta Usuarios</h1>
    <p>Este es el apartado para dar de alta a los usuarios del sistema</p>

    <form class="user" action="UsuariosSv" method="POST">

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="email" name="email"
                   placeholder="email@ejemplo.com">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña">
        </div>

        <button class="btn btn-primary btn-user btn-block" type="submit">
            Crear Usuario
        </button>

    </form>
</body>
<%@include file="components/bodyfinal.jsp"%>
