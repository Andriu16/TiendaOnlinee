<%-- 
    Document   : addformcli
    Created on : 15/06/2022, 09:58:23 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Orlando Ipaarraguirre">
        <title>Dashboard </title>
        <!-- Bootstrap core CSS --> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta name="theme-color" content="#7952b3">
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
        <!-- <link href="../css/dashboard.css" rel="stylesheet">
         <link href="../css/valida.css" rel="stylesheet" type="text/css"/>  -->
    </head>
    <body style="background: url('https://okdiario.com/img/2021/11/25/franki-chamaki-ivfp_yxzuyq-unsplash11.jpg') no-repeat;background-size: cover;">

      

        <div class="container-fluid">
            <div class="row">
                

                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="fw-bold" style="color: white">Registro de Usuario</h1>                       
                    </div>

                    <!-- <h2>Section title</h2>-->
                    <form action="../iniciarUsuario">
                       <!-- <div  class="input-group mb-3" id="grupo__dni">
                            <span class="input-group-text" id="basic-addon1">IDuser</span>
                            <input type="text" class="form-control" autofocus placeholder="Idusuario" required id="txtIDuser" name="txtIDuser">
                        </div> -->

                        <div class="input-group mb-3">
                            <span class="input-group-text and fw-bold" id="basic-addon1">Nombre</span>
                            <input type="text" class="form-control" placeholder="Nombres" id="txtNombre" name="txtNombre" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text and fw-bold" id="basic-addon1">Apellidos</span>
                            <input type="text" class="form-control" placeholder="Apellidos" id="txtApellidos" name="txtApellidos" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text and fw-bold" id="basic-addon1">Direccion</span>
                            <input type="text" class="form-control" placeholder="Provincia,Distrito,AV" id="txtDireccion" name="txtDireccion" required="">
                            
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text and fw-bold" id="basic-addon1">Correo</span>
                            <input type="email" class="form-control" placeholder="example@gmail.com" id="txtcorreo" name="txtcorreo" required="">
                            
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text and fw-bold" id="basic-addon1">Fecha De Nacimiento</span>
                            <input type="text" class="form-control" placeholder="00/00/0000" id="txtFecha" name="txtFecha" required="">
                            
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text and fw-bold" id="basic-addon1">Identificacion</span>
                            <input type="text" class="form-control" placeholder="DNI o CARNET EXTRANJERIA" id="txtIdentificacion" name="txtIdentificacion" required="">
                            
                        </div>
                       <div class="input-group mb-3">
                            
                            <input type="hidden" class="form-control"  id="txtIDCargo" name="txtIDCargo" required="" value="2">
                            <!-- poner un valor fijo -->
                        </div>

                       
                        <div class="input-group mb-3">
                            <span class="input-group-text and fw-bold" id="basic-addon1">Contraseña</span>
                            <input type="password" class="form-control" placeholder="*******" id="txtContrasena" name="txtContrasena" required="">
                            
                        </div>



                        <div class="input-group" style="text-align:center">                            
                            <button type="button" class="btn btn-secondary and fw-bold">&nbsp;Cancelar&nbsp;&nbsp;</button>
                            <input type="submit"  class="btn btn-info and fw-bold" name="accion"  value="agregarUser">                            
                        </div>  

                    </form>
                </main>
            </div>            
        </div>
        <!-- <script src="../js/formscript.js" type="text/javascript"></script>
         <script src="../js/bootstrap-bundle-min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <!--  <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>-->

    </body>

</html>

