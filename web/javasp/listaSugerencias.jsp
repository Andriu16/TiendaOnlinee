<%-- 
    Document   : listaSugerencias
    Created on : 17/07/2022, 11:28:03 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body style="background: url('https://media.istockphoto.com/photos/white-and-grey-smooth-stripes-abstract-minimal-geometric-motion-picture-id1307805809?b=1&k=20&m=1307805809&s=170667a&w=0&h=QdoOpqYEnhtU5N-y6sCTKpR5G4w905N2S2r6HQfAlNs=') ;background-size: contain;">
        <header  class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-2 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-5 fs-6" style="color: khaki" href="#">ADMINISTRADOR</a>
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
        <h2 style="text-align:center;color: #ffc107" > PRODUCTOS SUGERIDOS</h2>
    <center>
        
        <div class="table-responsive">
          
            <table class="table table-sm" align='center'>
                <thead>
                    <tr>
                        
                        <th height='80px' width='80px'>IDProduc</th>
                        <th height='80px' width='80px'>IDusuario</th>
                        <th height='80px' width='80px'>Nombre</th>
                         <th height='80px' width='80px'>Marca</th>
                        <th height='80px' width='80px'>Descripcion</th>
                       
                        
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var="dato" items="${listarecomen}">
                        <tr>
                             
                            <td> ${dato.getIDrecomendacion()}</td>
                            <td> ${dato.getCliente().getIDuser()}</td>
                            <td> ${dato.getNombreProduc()}</td>
                            <td> ${dato.getMarcaProduc()}</td>
                            <td> ${dato.getDescripProduc()}</td>
                                
                           
                        </tr>

                    </c:forEach>


                </tbody>


            </table>
        </div>
    </center>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
