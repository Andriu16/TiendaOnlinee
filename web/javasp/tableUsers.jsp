<%-- 
    Document   : tableUsers
    Created on : 25/06/2022, 07:27:42 PM
    Author     : user
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
<%@page import="matodosDAO.ClienteDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<html>
    <body class="text-center " style="background: url('https://fondosmil.com/fondo/90466.jpg') no-repeat;background-size: calc;">
        <header  class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-2 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-5 fs-6" style="color:cyan" href="#">ADMINISTRADOR</a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
             <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3" href="http://localhost:8080/PaginaWebtienda/javasp/vistaAdmin.jsp?" style="color:white">Inicio</a>
                </div>
            </div>
            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3" href="http://localhost:8080/PaginaWebtienda/index.html?" style="color:white">Salir</a>
                </div>
            </div>
        </header>
        
        <div class="container-fluid" >
            <caption>
    
                <h2 style="text-align:center;color: #ffc107" > LISTA DE USUARIOS REGISTRADOS</h2>
                                </caption>
            
                    
                        <div class="table-responsive">
                            
                            <table class="table table-sm" align='center'>
                                
                                <thead>
                                    <tr align='center'>
                                        <th height='20px' width='20px' style="color: white">#</th>
                                        <th height='20px' width='20px' style="color: white" >IDuser</th>
                                        <th height='20px' width='20px' style="color: white">Nombre</th>
                                        <th height='20px' width='20px' style="color: white">Apellidos</th>
                                        <th height='20px' width='20px' style="color: white">Direccion</th>
                                        <th height='20px' width='20px' style="color: white">Correo</th>
                                        <th height='20px' width='20px' style="color: white">FechaNac</th>
                                        <th height='20px' width='20px' style="color: white">Identificacion</th>
                                        <th height='20px' width='20px' style="color: white">Contraseña</th>
                                        <th height='20px' width='20px' style="color: white">IDCargo</th> 
                                        <th height='20px' width='20px' style="color: white">NombreCargo</th> 
                                        <th height='20px' width='20px' style="color: white">Estado</th> 
                                      



                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        ClienteDao dao = new ClienteDao();
                                        List<Cliente> list = dao.getPersonas();
                                        Iterator<Cliente> iter = list.iterator();
                                        Cliente per = null;
                                        while (iter.hasNext()) {
                                            per = iter.next();


                                    %>

                                    <tr>
                                        <td> </td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getIDuser()%></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getNombre()%></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getApellidos()%></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getDireccion()%></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getCorreo()%></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getFechaNac()%></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getIdentificacion()%></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getContrasena()%></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getCargo().getCodigo()%></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getCargo().getNombreCargo() %></td>
                                        <td height='20px' width='20px' style="color: white"><%= per.getCargo().isEstado() %></td>
                                        
                                    </tr>

                                    <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                
           
        </div>
    </body>
</html>