<%@page import="CapaEntidades.EntidadProductos"%>
<%@page import="java.util.List"%>
<%@page import="CapaLogica.BLProductos"%>
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
    <!-- Estilos Tabla -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
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
                <div class="container-fluid">

                <form action="ListarProductos.jsp" method="post">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" id="txtnombre" name="txtnombre" value="" 
                               placeholder="Buscar por Descripcion" class="form-control"/>
                        &nbsp;&nbsp;
                        <input type="submit" id="btnbuscar" name="btnbuscar" value="Buscar" 
                               class="btn btn-primary"/><br><br>
                    </div> 
                </div> 
                </form>
                    
                    
                    <!-- Tabla -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Listar Productos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="0%" cellspacing="0">
                                    <thead>
                                        <tr id="titulos">
                                            <th>Id</th>
                                            <th>IdEmpresa</th>
                                            <th>Descripcion</th>                                           
                                            <th>PrecioCosto</th>
                                            <th>PrecioVenta</th>
                                            <th>Stock</th>                       
                                            <th>Opciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      
                    <!-- Consulta a la bd para obtener la lista
                        mediante código JAVA--> 
                    <% 
                        String nombre = "";
                        String condicion = "";
                        //si el txtnombre no está vacio
                        if(request.getParameter("txtnombre")!=null){
                            nombre = request.getParameter("txtnombre");
                            condicion = "DESCRIPCION LIKE '%" + nombre + "%'";
                        }
                        BLProductos logica = new BLProductos();
                        List<EntidadProductos> datos;
                        datos = logica.ListarProductos(condicion);
            
                        //for para llenar la tabla
                        for (EntidadProductos registro:datos){
                    %>
                    
                    <tr>
                        <% int codigo=registro.getId();%>
                        <td><%=codigo%></td>
                        <td><%=registro.getIdEmpresa()%></td>
                        <td><%=registro.getDescripcion()%></td>
                        <td><%=registro.getPrecioCosto()%></td>
                        <td><%=registro.getPrecioVenta()%></td>
                        <td><%=registro.getStock()%></td>


                        <!--Columna para los botones -->
                        <td>
                            <!--Botón para modificar -->
                            <a href="Productos.jsp?idCrearModificar=<%=codigo%>"> <i class="fas fa-user-edit"></i></a> |
                            <!--Botón para Eliminar -->
                            <a href="EliminarProductos?idEliminar=<%=codigo %>"> <i class="fas fa-trash-alt"></i></a> |
                        </td>
                    </tr>
                    <%}%><!--Para cerrar el for --> 
                <%
                    if(request.getParameter("meCli") != null){
                        out.print("<p class='text-danger'>" + new String(request.getParameter("meCli").getBytes("ISO-8859-1"),"UTF-8")+"</P>");
                    }
                
                %>
                </tbody
            </table>   
            </table>
            
                     <a href="Productos.jsp?idCrearModificar=-1" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class= "fas fa-plus" ></i>
                        </span>
                        <span class="text">Agregar</span>
                     </a>
            
                     <a href="index.html" class="btn btn-secondary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-arrow-left"></i>
                        </span>
                        <span class="text">Regresar al inicio</span>
                     </a>           
            
                            </div>
                        </div>
                    </div>

                </div>              
            </div>
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
    
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>

</html>