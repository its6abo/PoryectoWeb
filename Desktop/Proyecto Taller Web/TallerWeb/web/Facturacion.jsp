<%@page import="java.util.ArrayList"%>
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
     <% 
         float total = 0;
         List<EntidadDetalleFacturas> DatosDetalles = new ArrayList<EntidadDetalleFacturas>();
     %>
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
   
                
                
                
                
     <header>
 </header> 
    <div class="container"> 
        <div class-"row">
            <div class="col-10"></div>
            <h5 class="text-primary">Facturación</h5>
    </div>
        <br>   

 <form  action="AgregarProducto" method="post">  
          
         <div class="form-group"> 
        <div class="input-group">
            <input type="hidden" id="txtIdCliente" name="txtIdCliente" value="<>"
                   readonly="" class="form-control"/> 
            <input type="text" id="txtNombreCliente" name="txtNombreCliente"
                   value="" readonly="" class="form-control"
                   placeholder="Seleccione un cliente"/>&nbsp;&nbsp;
            <a id="btnbuscar" class="btn btn-primary" data-toggle="modal"
                data-target="#buscarCliente"><i class="fas fa-search"></i></a> 
        </div> 
    </div>
     <!-- Inicia el detalle de factura --> 
    <div class="form-group">
        <div class="input-group">
            <input type="hidden" id="txtIdProducto" name="txtIdProducto" value="" readonly="" class="form-control"/> 
            <input type="text" id="txtdescripcion" name="txtdescripcion" value="" class="form-control" readonly
                   placeholder="Seleccione un producto"/>&nbsp;&nbsp; 
            <a id="btnBuscarP" class="btn btn-primary" data-toggle="modal" data-target="#buscarProducto">
                <i class="fa fa-search"></i></a>&nbsp;&nbsp; 
            <input type="number" id="txtcantidad" name="txtcantidad" value="" class="form-control"
                   placeholder="Cantidad"/> &nbsp;&nbsp; 
            <input type="number" id="txtprecio" readonly = "true" name="txtprecio" value="" class="form-control"
                   placeholder="Precio"/>&nbsp;&nbsp;
            <input type="number" id="txtexistencia" readonly name="txtexistencia" value="" class="form-control"
                   placeholder="Existencia"/>
        </div> 
    </div> 
    <br/> 
    <div class="form-group">
        <input type="submit" name="Guardar" id="BtnGuardar" value="Agregar y Guardar" onclick="" class="btn btn-primary"/>
    </div> 
</form> 
        <br>
<hr/>    


<!-- Mostrar detalle de factura --> 
<h5 class="text-primary">Detalle de Factura</h5>
<table id="DetalleFactura" class="table"> 
    <thead> 
        <tr>
            <th>Código</th> 
            <th>Descripción</th> 
            <th>Cantidad</th> 
            <th>Precio</th> 
            <th>Subtotal</th>
            <th>Eliminar </th> 
        </tr> 
    </thead>
    
    
<tbody>
    

<% 
HttpSession sesion = request.getSession();
DatosDetalles = (List<EntidadDetalleFacturas>)sesion.getAttribute("misDetalles");
    

if (DatosDetalles != null) {
        for (EntidadDetalleFacturas registroDetalle : DatosDetalles) {
%>
<tr>
    <%
        int numfactura = 0;
        int codigop = registroDetalle.getIdProducto();
        String descripcion = new String (registroDetalle.getNombre().getBytes ("ISO-8859-1"), "UTF-8");
        float cantidad = registroDetalle.getCantidad(); 
        double precioV = registroDetalle.getPrecioVenta();
        total += (cantidad * precioV);
        %>
        <td><%= codigop%></td> 
        <td><%= descripcion%></td> 
        <td><%= cantidad%></td> 
        <td><%= precioV%></td>
        <td><%= cantidad * precioV%></td> 
        <td>
           <a href="EliminarDetalle?idproducto=<%=codigop%>&idfactura=<%=numfactura%>">
                <i class="fas fa-trash-alt"></i></a> 
        </td> 
</tr>

    <%
        } // cierre de for 
        } // cierre del if
    %>
    </tbody> 
</table> 
 <form  action="Facturar" method="post">  
 
<div class="float-right">
<p class="text-danger h5" >Total = <%= total%> </p> 
</div> 
<br><br>
<%
//mensaje generado en en servlets facturas
if (request.getParameter("msgFac") != null) {
    out.print("<p class='text-danger'>" + new String(request.getParameter("msgFac").getBytes("ISO-8859-1"), "UTF-8") + "</p>");
    }
%>    
    <input type="submit" id="BtnCancelar" value="Realizar Facturacion" class="btn btn-primary"/>&nbsp; &nbsp; 
    <a href="index.html" class="btn btn-secondary">Regresar</a>
</div> <!-- container principal -->
</form>
    

<!-- Modal de clientes --> 
<div class="modal" id="buscarCliente" tabindex="1" role="dialog" aria-labelledby="tituloVentana">
    <div class="modal-dialog" role="document"> 
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="tituloVentaja">Buscar cliente</h5>
                <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true"
                    onclick="Limpiar()"> 
                  <span aria-hidden="true">&times;</span>
                </button> 
            </div> 
            <div class="modal-body">
            <!-- tabla de clientes --> 
            <table id="tablaClientes">
                <thead> 
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Seleccionar</th> 
                    </tr> 
                </thead>

<tbody>
<%
    BLClientes logicaClientes = new BLClientes();
    List<EntidadClientes> datosClientes;
    datosClientes = logicaClientes. ListarClientes("");
    for (EntidadClientes registroC : datosClientes) {
%>
<tr> 
    <%int codigoCliente = registroC.getId();
        String nombreCliente = registroC.getNombre();%>
        <td><%= codigoCliente%></td>
        <td><%= nombreCliente%></td> 
        <td>
            <a href="#" data-dismiss="modal"
                onclick="SeleccionarCliente('<%=codigoCliente%>', '<%= nombreCliente%>');">Seleccionar</a> 
        </td> 
</tr>
<%} %>
</tbody> 
</table> 
</div> <!-- modal body --> 
<div class="modal-footer"> 
<button class="btn btn-warning" type="button" data-dismiss="modal" onclick="Limpiar()">
    Cancelar 
</button> 
</div> 
</div> <!-- modal content -->
</div> <!-- modal dialog -->
</div> <!-- modal --> 


<!-- Modal de PRODUCTO -->
<div class="modal" id="buscarProducto" tabindex="1" role="dialog" aria-labelledby="tituloVentana"> 
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="tituloVentana">Buscar producto</h5>
                <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true"
                        onclick="LimpiarProducto()"> 
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
            <!-- tabla de clientes -->
            <table id="tablaProductos">
                <thead> 
                    <tr>
                        <th>Código</th> 
                        <th>Descripción</th>
                        <th>Precio</th>
                        <th>Seleccionar</th>
                    </tr> 
                </thead>
                
            <tbody>

               <%     
                    BLProductos logicaProductos = new BLProductos();
                    List<EntidadProductos> datosProductos;
                    datosProductos = logicaProductos.ListarProductos("");
                    for (EntidadProductos registroP: datosProductos) {
                %>
                <tr>
                    <%int codigoProducto = registroP.getId();
                        String nombreProducto = registroP.getDescripcion(); 
                        double precio = registroP.getPrecioVenta();
                        double existencia = registroP.getStock();
                     %>
                    <td><%= codigoProducto%></td> 
                    <td><%= nombreProducto%></td>
                    <td><%= precio%></td>
                    <td>
                        <a href="#" data-dismiss="modal"
                           onclick="SeleccionarProducto('<%=codigoProducto%>',
                                                '<%= nombreProducto%>', '<%= precio%>', '<%= existencia%>');">Seleccionar</a>
                    </td> 
                </tr>
                <%}%>
            </tbody>
        </table> 
            </div> <!-- modal body -->
            <div class="modal-footer">
                <button class="btn btn-warning" type="button" data-dismiss="modal"
                        onclick="LimpiarProducto()"> Cancelar
                </button> 
            </div> 
        </div> <!-- modal content --> 
    </div> <!-- mnodal dialog --> 
</div> <!-- modal -->
  


<!-- Scripts requeridos --> 
<script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
<script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="lib/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="lib/bootstrap-datepicker/locales/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
<script src="lib/DataTables/datatables.min.js" type="text/javascript"></script>
<script src="lib/DataTables/DataTables-1.10.21/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>

<script>
//cuando el documento este listo 
//Cargue las siguientes funciones
$(document).ready(function () {
    //mostrar calendario 
    $('.datepicker').datepicker({
    format: 'yyyy-mm-dd',
    autoclose: true,
    language: 'es' 
}); 
//hacer que la lista de clientes se comporte como un datatable 
// Configurar la tabla clientes del modal 
$('#tablaClientes').dataTable({
   "lengthMenu": [[5, 15, 15, -1], [5, 10, 15, "All"]],
   "language": {
   "info": "Página_PAGE_de_PAGES_ ",
   "infoEmpty": "No existen Registros disponibles",
   "zeroRecords": "No se encuentran registros",
   "search": "Buscar",
   "infoFiltered": "",
   "lengthMenu": "Mostrar_MENU_ Registros",
   "paginate": {
        "first": "Primero",
        "last": "Último",
        "next": "Siguiente",
        "previous": "Anterior"
        }
   }
});


//Configura la tabla productos del modal
$('#tablaProductos').dataTable({
"lengthMenu": [[5, 15, 15, -1], [5, 10, 15, "All"]],
"language": {
    "info": "Página _PAGE_ de _PAGES_",
    "infoEmpty": "No existen Registros disponibles",
    "zeroRecords": "No se encuentran registros",
    "search": "Buscar",
    "infoFiltered": "",
    "lengthMenu": "",
    "paginate": {
        "first": "Primero",
        "last": "Último",
        "next": "Siguiente", 
        "previous": "Anterior"
        }
    }
});
});


//seleccionar cliente 
// estas funciones se llaman con un evento desde un modal 
function SeleccionarCliente(idCliente, nombreCliente) {
    $("#txtIdCliente").val(idCliente);
    $("#txtNombreCliente").val(nombreCliente);
}

//seleccionar producto 
function SeleccionarProducto(idProducto, Descripcion, Precio, Existencia) {
$("#txtIdProducto").val(idProducto);
$("#txtdescripcion").val(Descripcion);
$("#txtprecio").val(Precio);
$("#txtexistencia").val(Existencia);
$("#txtcantidad").focus();
}

// seleccionar cliente 
function Limpiar() {
$("#txtIdCliente").val("");
$("#txtNombreCliente").val("");
}
//seleccionar producto 
function LimpiarProducto() {
$("#txtIdProducto").val("");
$("#txtdescripcion").val("");
$("#txtprecio").val("");
$("#txtexistencia").val("");
}
        </script>                
                
                
          
                <!-- *** FIN FORMULARIO *** -->
                                
                <br>

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

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

    <script src="lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
     <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
             
         <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>
    
    <script src="lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
        
    </body>
</html>