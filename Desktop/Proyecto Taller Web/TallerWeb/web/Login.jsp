<%-- 
    Document   : Login
    Created on : 11 may. 2022, 6:06:08 p. m.
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- ***INICIO HEAD*** -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Taller Mecánico</title>

    <!-- Fuentes-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="lib/fontawesome-free-5.14.0-web/" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Estilos -->
    <link href="css2/sb-admin-2.min.css" rel="stylesheet">
    <link rel="icon" href="img/Favicon.png">
</head>
 <!-- ***FIN HEAD*** -->



<html>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container-xl px-4">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <!-- Basic login form-->
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header justify-content-center"><h3 class="fw-light my-4">Bienvenido!</h3></div>
                                    <div class="card-body">
                                        <!-- Login form-->
                                        <form action="login" method="post">
                                            <!-- Form Group (email address)-->
                                            <div class="mb-3">
                                                <label class="small mb-1" for="inputEmailAddress">Usuario</label>
                                                <input class="form-control" id="txtusuariolo" name="txtusuariolo" />
                                            </div>
                                            <!-- Form Group (password)-->
                                            <div class="mb-3">
                                                <label class="small mb-1" for="inputPassword">Contraseña</label>
                                                <input  class="form-control" id="txtpasslo" name="txtpasslo" type="password" />
                                            </div>
                                            <!-- Form Group (login box)-->
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                
                                                <input type="submit" name="Guardar" id="BtnGuardar" value="Ingresar" class="btn btn-primary"/>
                                             
                                            
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
    </body>
</html>
