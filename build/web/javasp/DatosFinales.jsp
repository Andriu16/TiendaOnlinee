<%-- 
    Document   : DatosFinales
    Created on : 12/07/2022, 11:15:46 PM
    Author     : user
--%>
<%@page import="matodosDAO.ProductoDAO"%>
<%@page import="modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.ultimosDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="theme-color" content="#7952b3">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }
            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
        <title>JSP Page</title>

    </head>
    <body style="background: url('https://okdiario.com/img/2021/11/25/franki-chamaki-ivfp_yxzuyq-unsplash11.jpg') ;background-size: contain;">
        <div class="container-fluid" >
            <div class="row">


                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2" style="color: white">Datos finales para su compra:</h1>                       
                    </div>
                    

                    <!-- <h2>Section title</h2>-->
                    <form action="ControllerCarrito" method="POST" >

                        <div  class="input-group mb-3" id="grupo__dni">

                            <input type="hidden" class="form-control" value="1" id="txtIDdetalle" name="txtIDdetalle">
                            <!--value ="VALOR X"-->
                        </div> 

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">Departamento </span>
                            <input type="text" class="form-control" placeholder="----" id="txtDepartamento" name="txtDepartamento" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">Distrito</span>
                            <input type="text" class="form-control" placeholder="---" id="txtDistrito" name="txtDistrito" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">Avenida</span>
                            <input type="text" class="form-control" placeholder="---" id="txtAvenida" name="txtAvenida" required="">

                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">Referencia</span>
                            <input type="text" class="form-control" placeholder="---" id="txtReferencia" name="txtReferencia" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">Dpto/lote/manzana/grupo</span>
                            <input type="text" class="form-control" placeholder="---" id="txtDireccionExacta" name="txtDireccionExacta" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">Fecha de entrega Deseada</span>
                            <input type="text" class="form-control" placeholder="---" id="txtFechaDeseada" name="txtFechaDeseada" required="">

                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">Tipo de Entrega</span>
                            <input type="text" class="form-control" placeholder="A,B,C" id="txtTipoEntrega" name="txtTipoEntrega" required="">
                            <!--Chancar los datos que tiene que pagar -->
                        </div>



                        <p></p>


                        <div class="input-group" style="text-align:center">                            


                            <div class="input-group" style="text-align:center">                            

                                <input type="submit"  class="btn btn-info" name="accion"  value="DatosListos">                            
                            </div>  



                        </div>  





                    </form>

                </main>
            </div>            
        </div>





        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

