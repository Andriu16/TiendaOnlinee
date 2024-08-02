<%-- 
    Document   : carrito
    Created on : 12/07/2022, 04:36:54 PM
    Author     : user
--%>
<%@page import="modelo.carrito"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body style="background: url('https://media.istockphoto.com/photos/white-and-grey-smooth-stripes-abstract-minimal-geometric-motion-picture-id1307805809?b=1&k=20&m=1307805809&s=170667a&w=0&h=QdoOpqYEnhtU5N-y6sCTKpR5G4w905N2S2r6HQfAlNs=') no-repeat;background-size: cover;">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="ControllerCarrito?accion=Inic">Carrito de Compras</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <!-- accion-->
                        <a class="nav-link" href="ControllerCarrito?accion=Inic" >Home <span class="sr-only">(current)</span></a>
                    </li>
                    

                    <li class="nav-item active">
                        <a class="nav-link " href="ControllerCarrito?accion=Inic" > Seguir Comprando</a>
                    </li>
                </ul>

                
         
            </div>
        </nav>
        <div class="container mt-4" >
            <h3>Carrito</h3>
            <div class="row">

                <div class="col-sm-8" >
                    <table class="table table-hover" >
                        <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>NOMBRES</th>
                                <th>DESCRIPCION</th>
                                <th>PRECIO</th>
                                <th>CANTIDAD</th>
                                <th>SUBTOTAL</th>
                                <th>ACCION</th>


                            </tr>

                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                                <tr>
                                    <td>${car.getItem()}</td>
                                    <td>${car.getNombres()}</td>
                                    <td right='50px' left='50px' >
                                    <img src="ControllerImg?id=${car.getIdProducto()}" width="100" height="100">
                                    ${car.getDescripcion()}
                                    </td>
                                    <td>${car.getPrecioCompra()}</td>
                                    <td>${car. getCantidad()}</td>
                                    <td>${car.getSubTotal()}</td>


                                    <td class="cart_delete">
                                        
                                        <a class="btn btn-danger btn-block" href="ControllerCarrito?accion=Delete&idp=${car.getItem()}" id="btnDelete"  >eliminar</a>

                                    </td>


                                    <!-- modificar para el javascrp-->

                                </tr>
                            </c:forEach>

                        </tbody>


                    </table>
                </div>

                <div clas="col-sm-4" style="margin-left:130px">
                    <div class="card">
                        <div class="card-header">
                            <h3>Generar compra</h3>

                        </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <input type="text" value="S/.${totalPagar}" readonly="" class="form-control">
                            <label>Descuento:</label>
                            <input type="text" value="S/.0.00" readonly="" class="form-control">
                            <label>Total a Pagar:</label>
                            <input type="text" value="S/.${totalPagar}0" readonly="" class="form-control">


                        </div>
                        <div class="card-footer">
                            <a href="ControllerCarrito?accion=GenerarCompra" class="btn btn-info btn-block">Generar Compra</a>
                           
                        </div>

                    </div>

                </div>
            </div>


        </div>
                            
                            
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="Jss/Borraritem.js" ></script>
    </body>

</html>