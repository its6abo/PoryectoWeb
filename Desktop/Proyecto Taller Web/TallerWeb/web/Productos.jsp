<%@page import="CapaEntidades.*"%>
<%@page import="CapaLogica.*"%>
<%@page import="java.util.List" %>
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
 
                <!-- *** INICIO FORMULARIO *** -->
                
        <div class="container">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card-group mb-4">            
                        <h5 class="text-primary">Mantenimiento de Productos</h5>
                    </div>
                   
                    
                    <!-- *** Modifica *** -->
                     <%
                        String id = request.getParameter("idCrearModificar");
                        int codigo = Integer.parseInt(id);
                        EntidadProductos productos;
                        BLProductos logica = new BLProductos();
                        if(codigo > 0){
                            //cliente exite
                            productos = logica.ObtenerUnProducto("Id="+id);                         
                        }else{
                            productos = new EntidadProductos();
                            
                        }
                     %> 
                     
                     
                     <!-- No tiene jsp por eso es un servlet -->
                     <form action="CrearModificarProductos" method="post" id="AgregarModificarProductos">
                        <div class="form-group">
                            
                            <!-- *** Trae el id cuando modifica *** -->
                            
                            <%if(codigo > 0){%>
                                <label for = "txtCodigo" class="control-lable">Id
                                <input 
                                    type="number" 
                                    id="txtCodigo" 
                                    name="txtCodigo"  
                                    value="<%=productos.getId()%>"
                                    readonly
                                    class="form-control"/>
                            <%}else{%>
                                <input 
                                    type="hidden" 
                                    id="txtCodigo" 
                                    name="txtCodigo"  
                                    value="-1"
                                    />
                            <%}%>
                            </label>
                            
                        
                            <!-- *** COMBOBOX *** -->
                            </div>
                            <div> 
                                <label 
                                    for = "Empresa" 
                                    class="control-lable">Empresa
                                </label>
                                <select name="Empresa">
                                    <option value="1">Taller Mecanico</option> 
                                    <option value="3">DIPAC</option>
                                    <option value="4">DISAL</option>
                                    <option value="5">DHL</option>
                                <select/>
                            </div>
                            <br>
                           
                        
                            <div> 
                            <label 
                                for = "txtDescripcion" 
                                class="control-lable">Descripcion
                            <input 
                                id="txtDescripcion" 
                                name="txtDescripcion"  
                                value="<%=productos.getDescripcion()%>"
                                class="form-control"
                            />
                            </label>  
                             </div>
                                
                        
                            <div> 
                            <label 
                                for = "txtPrecioCosto" 
                                class="control-lable">Precio Costo
                            <input 
                                id="txtPrecioCosto" 
                                name="txtPrecioCosto"  
                                value="<%=productos.getPrecioCosto()%>"
                                min="1"
                                class="form-control"
                            />
                            </label>
                            </div>                     
                        
                                
                        <div> 
                            <label 
                                for = "txtPrecioVenta" 
                                class="control-lable">Precio Venta
                            <input 
                                id="txtPrecioVenta" 
                                name="txtPrecioVenta" 
                                value="<%=productos.getPrecioVenta()%>"
                                min="1"
                                class="form-control"
                            />
                            </label>
                            </div>
                                
                                <br>    
                                
                            <div> 
                            <label for="txtStock"
                                   class="control-lable">Cantidad
                            <input 
                                type="number" id="txtStock" name="txtStock"
                                value="<%=productos.getStock()%>"
                                min="1" max="1000"/>
                            </label>
                            </div>
               
                        <!-- *** Botón Guardar y regresar *** -->       
                        
                        <br> 
                        <div class="form-group">
                            <div class="input-group">
                                <input 
                                    type="submit" 
                                    id="btnGuardar" 
                                    value="Guardar"
                                    class="btn btn-primary"
                                />
                                &nbsp;&nbsp
                                <input 
                                    type="button" 
                                    id="btnRegresar" 
                                    value="Regresar"
                                    class="btn btn-secondary"
                                    onclick="location.href='ListarProductos.jsp'"
                                />
                            
                                <br> 
                        </div> 
                     </form>
                </div>            
            </div>            
        </div>
    </div>
                    <br>             
                                <!-- *** FIN FORMULARIO *** -->
                                


                    <!-- *** INICIO FOOTER *** -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Taller Mecánico 2022</span>
                    </div>
                </div>
            </footer>
             <!-- *** FIN FOOTER *** -->
             
             
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
             

        <script src="lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
       
        
        <!-- Validaciones -->
        <script>
            $(document).ready(function(){
                
                $("#AgregarModificarProductos").validate({
                    
                    rules:{
                        txtDescripcion:{required:true,minlength:1,maxlength:25},
                        txtPrecioCosto:{required:true,number:true},
                        txtPrecioVenta:{required:true,number:true},                    
                        txtStock:{required:true,number:true}
                    },
                    messages:{
                        txtDescripcion:"'Descripcion' requerida, mínimo 1 carácteres, máximo 25.",
                        txtPrecioCosto:"'Precio Costo' requerido, solo se permiten numeros positivos",
                        txtPrecioVenta:"'Precio Venta' requerido, solo se permiten numeros positivos",
                        txtStock:" mín 1, máx 1000."
                    },
                    errorElement:'span'
                       
                });
            });
            
        </script>
        
    </body>
</html>