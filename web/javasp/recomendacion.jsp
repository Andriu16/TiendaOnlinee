<%-- 
    Document   : recomendacion
    Created on : 16/07/2022, 03:22:18 PM
    Author     : user
--%>

<%@page import="modelo.Recomendaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="h-100">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.98.0">
        <title>Cover Template · Bootstrap v5.2</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/cover/">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">



        <link href="/docs/5.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.2/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.2/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.2/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
        <link rel="icon" href="/docs/5.2/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#712cf9">


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

            .b-example-divider {
                height: 3rem;
                background-color: rgba(0, 0, 0, .1);
                border: solid rgba(0, 0, 0, .15);
                border-width: 1px 0;
                box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
            }

            .b-example-vr {
                flex-shrink: 0;
                width: 1.5rem;
                height: 100vh;
            }

            .bi {
                vertical-align: -.125em;
                fill: currentColor;
            }

            .nav-scroller {
                position: relative;
                z-index: 2;
                height: 2.75rem;
                overflow-y: hidden;
            }

            .nav-scroller .nav {
                display: flex;
                flex-wrap: nowrap;
                padding-bottom: 1rem;
                margin-top: -1px;
                overflow-x: auto;
                text-align: center;
                white-space: nowrap;
                -webkit-overflow-scrolling: touch;
            }
        </style>


        <!-- Custom styles for this template -->
        <link href="cover.css" rel="stylesheet">
    </head>
    <body class="d-flex h-100 text-center text-white bg-dark">

        <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
            <header class="mb-auto">
                <div>
                    <h3 class="float-md-start mb-0">Recomendaciones</h3>
                    <nav class="nav nav-masthead justify-content-center float-md-end">
                        <div class="navbar-nav">
                            <div class="nav-item text-nowrap">
                                <a class="nav-link px-3" href="../ControllerCarrito?accion=Inic" style="color:white">Inicio</a>
                            </div>
                        </div>

                    </nav>
                </div>
            </header>

            <main class="px-3">
                <h1>Bienvenido</h1>
                <p class="lead">Porfavor escriba los datos del producto a sugerir</p>
                <%
                Recomendaciones rr= new Recomendaciones();
                %>
                
                
                <form action="../ControllerCarrito" method="POST">
                    
                    <div class="input-group mb-3">
                        
                        <input type="hidden" class="form-control"  id="txtIdusuario" name="txtIdusuario" value="8">>


                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text and fw-bold" id="basic-addon1">Nombre </span>
                        <input type="text" class="form-control"  id="txtProduName" name="txtProduName" required="">


                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text and fw-bold" id="basic-addon1">Marca </span>
                        <input type="text" class="form-control"  id="txtProduMarca" name="txtProduMarca" required="">


                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text and fw-bold" id="basic-addon1">Descripcion </span>
                        <input type="text" class="form-control"  id="txtProduDescrip" name="txtProduDescrip" required="">


                    </div>
                    <div class="input-group" style="text-align:center">                            

                        <input type="submit"  class="btn btn-info and fw-bold" name="accion"  value="Correcto">                            
                    </div>  

                </form>

            </main>

            <footer class="mt-auto text-white-50">

            </footer>
        </div>



    </body>
</html>
