<%-- 
    Document   : ListarCatalogo
    Created on : 12 may. 2022, 4:55:43 p. m.
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

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
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="icon" href="img/Favicon.png">
</head>
 <!-- ***FIN HEAD*** -->

 
 <body id="page-top">
    <!-- Container -->
    <div id="wrapper">

        
        
        <!-- *** INICIO BARRA LATERLAL *** -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Barra Lateral Logo -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div>
                    <img src="img/LogoTaller.png" width="60" height="60" alt="alt"/>
                </div>
                <div class="sidebar-brand-text mx-3"> Taller Mecánico </div>
            </a>

            <!-- Divisor -->
            <hr class="sidebar-divider my-0">

            <!-- Panel de usuarios -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                   <i class="fas fa-fw fa-home"></i>
                    <span>Inicio</span></a>
            </li>

            <!-- Linea División -->
            <hr class="sidebar-divider">

                <li class="nav-item active">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-users"></i>
                    <span>Personas</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Administrar</h6>
                        <a class="collapse-item" href="ListarUsuarios.jsp">Usuarios</a>
                        <a class="collapse-item" href="ListarClientes.jsp">Clientes</a>
                        <a class="collapse-item" href="ListarProveedores.jsp">Proveedores</a>
                    </div>
                </div>
            </li>
            
            <!-- Linea División -->
            <hr class="sidebar-divider">
            
            <!-- Titulo -->
            <div class="sidebar-heading">
                Interfaz
            </div>

            <li class="nav-item active">
                <a class="nav-link" href="ListarCatalogo.jsp"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-shopping-basket"></i>
                    <span>Catálogo</span>
                </a>
            </li>
            
            <li class="nav-item active">
                <a class="nav-link" href="ListarProductos.jsp"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-oil-can"></i>
                    <span>Productos</span>
                </a>
            </li>
            
            <li class="nav-item active">
                <a class="nav-link" href="ListarVehiculos.jsp"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-car"></i>
                    <span>Vehículos</span>
                </a>
            </li>
            
            <li class="nav-item active">
                <a class="nav-link" href="ListarVentas.jsp"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-money-check-alt"></i>
                    <span>Ventas</span>
                </a>
            </li>
            
            <li class="nav-item active">
                <a class="nav-link" href="ListarEmpresas.jsp"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-business-time"></i>
                    <span>Empresas</span>
                </a>
            </li>                                  

            <!-- Linea División -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Boton Cerrar -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>
        <!-- *** FIN BARRA LATERLAL *** -->


        
        <!-- CONTENEDOR -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- CONTENIDO PRINCIPAL -->
            <div id="content">

                
                <!-- *** INICIO BARRA ARRIBA *** -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Barra Arriba -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Barra -->
                    <ul class="navbar-nav ml-auto">
                                               
                        <!-- Factuación -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link" href="Facturacion.jsp">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                                <img class="img-profile" src="img/Factura.png">
                            </a>
                        </li>                          
                        
                        <!-- Carrito -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                                <img class="img-profile"
                                     src="img/Carrito.png">
                            </a>
                        </li>                        
                        <div class="topbar-divider d-none d-sm-block"></div>
                        <!-- Perfil Usuario -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                                <img class="img-profile rounded-circle"
                                     src="img/Perfil.png">
                            </a>
                            <!-- Usuario Salir -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="Login.html" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Salir
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- *** FIN BARRA ARRIBA *** -->
 
 
 
 
 
 <!-- *** INICIO DEL CONTENIDO DE LA PAG *** -->
 
                <div id="layoutSidenav_content">
                <main>
                    <header class="page-header page-header-dark bg-gradient-primary-to-secondary pb-10">
                        <div class="container-xl px-4">
                            <div class="page-header-content pt-0">
                                <div class="row align-items-center justify-content-between">
                                    <div class="col-auto mt-4">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </header>
 
                            
                            <div class="container-xl px-3 mt-n10">
                            <div class="row">
                            <div class="col-xl-4 mb-4">
                                
                                
                                
                                <!-- 1 Tarjeta-->
                                <div class="card lift h-100">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-primary mb-3" data-feather="package"></i>
                                                <h5 class="text-primary">Llanta</h5>
                                                <h5 class="text-secondary">₡40.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/p1llanta.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-xl-4 mb-4">
                                <!-- 2 Tarjeta-->
                                <div class="card lift h-100" href="#!">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-secondary mb-3" data-feather="book"></i>
                                                <h5 class="text-primary">Radiador</h5>
                                                <h5 class="text-secondary">₡80.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/p2radiador.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                            <div class="col-xl-4 mb-4">
                          <!-- 3 Tarjeta -->
                                <div class="card lift h-100" href="#!">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-secondary mb-3" data-feather="book"></i>
                                                <h5 class="text-primary">Compensador</h5>
                                                <h5 class="text-secondary">₡30.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/p3compensador.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                               </div>
                           </div>     
                          
                          
                          
                             <div class="container-xl px-3 mt-n10">
                            <div class="row">
                            <div class="col-xl-4 mb-4">
                                
                                
                                
                                <!-- 4 Tarjeta-->
                                <div class="card lift h-100">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-primary mb-3" data-feather="package"></i>
                                                <h5 class="text-primary">Botaguas</h5>
                                                <h5 class="text-secondary">₡26.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/pbotaguas.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-xl-4 mb-4">
                                <!-- 5 Tarjeta-->
                                <div class="card lift h-100" href="#!">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-secondary mb-3" data-feather="book"></i>
                                                <h5 class="text-primary">Herramientas</h5>
                                                <h5 class="text-secondary">₡40.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/p4herramientas.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                            <div class="col-xl-4 mb-4">
                          <!-- 6 Tarjeta -->
                                <div class="card lift h-100" href="#!">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-secondary mb-3" data-feather="book"></i>
                                                <h5 class="text-primary">Frenos</h5>
                                                <h5 class="text-secondary">₡12.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/p5freno.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                               </div>
                           </div>                              
                          
 
                             <div class="container-xl px-3 mt-n10">
                            <div class="row">
                            <div class="col-xl-4 mb-4">
                                
                                
                                
                                <!-- 7 Tarjeta-->
                                <div class="card lift h-100">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-primary mb-3" data-feather="package"></i>
                                                <h5 class="text-primary">Parachoques</h5>
                                                <h5 class="text-secondary">₡45.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/p6parachoques.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-xl-4 mb-4">
                                <!-- 8 Tarjeta-->
                                <div class="card lift h-100" href="#!">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-secondary mb-3" data-feather="book"></i>
                                                <h5 class="text-primary">Rack</h5>
                                                <h5 class="text-secondary">₡50.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/p7racks.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                            <div class="col-xl-4 mb-4">
                          <!-- 9 Tarjeta -->
                                <div class="card lift h-100" href="#!">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-secondary mb-3" data-feather="book"></i>
                                                <h5 class="text-primary">Aros</h5>
                                                <h5 class="text-secondary">₡90.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/p8aros.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                               </div>
                           </div>                                  
                                
                                
                             <div class="container-xl px-3 mt-n10">
                            <div class="row">
                            <div class="col-xl-4 mb-4">
                                
                                
                                
                                <!-- 10 Tarjeta-->
                                <div class="card lift h-100">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-primary mb-3" data-feather="package"></i>
                                                <h5 class="text-primary">Shampoo</h5>
                                                <h5 class="text-secondary">₡6.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/pshampoo.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-xl-4 mb-4">
                                <!-- 11 Tarjeta-->
                                <div class="card lift h-100" href="#!">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-secondary mb-3" data-feather="book"></i>
                                                <h5 class="text-primary">Batería</h5>
                                                <h5 class="text-secondary">₡90.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/pbateria.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                            <div class="col-xl-4 mb-4">
                          <!-- 12 Tarjeta -->
                                <div class="card lift h-100" href="#!">
                                    <div class="card-body d-flex justify-content-center flex-column">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div class="me-3">
                                                <i class="feather-xl text-secondary mb-3" data-feather="book"></i>
                                                <h5 class="text-primary">Aceite</h5>
                                                <h5 class="text-secondary">₡7.000</h5>
                                                <a id="btnbuscar2" class="btn btn-primary" class="btn-primary" data-toggle="modal"
                                                data-target="#buscarEmpleado"><i class="fas fa-shopping-cart"></i>
                                                </a>
                                            </div>
                                            <img src="img/paceite.png" alt="..." style="width: 8rem" />
                                        </div>
                                    </div>
                               </div>
                           </div>                                       
                          
                          </div>  
                          </div>  
                          </div>        
                          </div>
                          </div>  
                          </div>  
                          </div>  
                          </div> 
                          <main>
 
 
<!-- *** FIN DEL CONTENIDO DE LA PAG *** -->                           
                                        
                               
            <!-- *** INICIO FOOTER *** -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Taller Mecánico 2022</span>
                    </div>
                </div>
            </footer>
             <!-- *** FIN FOOTER *** -->

        </div>
        <!-- FIN CONTENIDO PRINCIPAL -->
    </div>
    <!-- FIN CONTENEDOR -->

    <!-- BOTÓN PARA DESPLAZAR EL MENÚ -->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- MODAL PARA SALIR DEL PERFIL -->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Listo para salir?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Seleccione "Cerrar Sesión" a continuación si está listo para finalizar su sesión actual.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                    <a class="btn btn-primary" href="Login.jsp">Cerrar Sesión</a>
                </div>
            </div>
        </div>
    </div>
    <!-- FIN MODAL -->

    
     <!-- ***Librerias*** -->
    
    <!-- Bootstrap JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Scripts-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>
</html>                                       
