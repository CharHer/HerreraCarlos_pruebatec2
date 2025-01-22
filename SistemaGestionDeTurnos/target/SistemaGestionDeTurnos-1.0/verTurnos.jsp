
<%@page import="java.util.List"%>
<%@page import="com.hackaboss.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>


<%@include file="components/bodyinicio.jsp"%>


               <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver turnos</h1>
                    <p class="mb-4">A continuación se muestra la lista completa de turnos</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Turnos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Numero de turno</th>
                                            <th>Descripción de trámite</th>
                                            <th>Fecha agendada</th>
                                            <th>Estado</th>
                                            <th style="width:210px">Acción</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Numero de turno</th>
                                            <th>Descripción de trámite</th>
                                            <th>Fecha agendada</th>
                                            <th>Estado</th>
                                            <th style="width:210px">Acción</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                        List<Turno> listaTurnos = (List)request.getSession().getAttribute("listaTurnos");
                                    %>
                                    
                                    <tbody>
                                        <%
                                            for(Turno turn : listaTurnos) {
                                        %>
                                        <tr>
                                            <td><%= turn.getNumeroTurno() %></td>
                                            <td><%= turn.getDescripcionTramite() %></td>
                                            <td><%= turn.getFechaAgendada() %></td>
                                            <td><%= turn.getEstado() %></td>
                                            
                                            <td style="display: flex; width: 230px">
                                                <form name="eliminar" action="EliminarTurnosSv" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block"; style="background-color:red; margin-right: 5px;">
                                                        <i class="fas fa-thrash-alt"></i>Eliminar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%= turn.getId() %>">
                                                </form>
                                                <form name="editar" action="EditarTurnosSv" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-right: 5px;">
                                                        <i class="fas fa-pencil-alt"></i>Editar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%= turn.getId() %>">
                                                </form>
                                            </td>
                                            
                                        </tr>
                                        
                                        <%
                                            }
                                        %>
                                    </tbody>
                                    
                                    
                                    
                                    
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
            


<%@include file="components/bodyfinal.jsp"%>

