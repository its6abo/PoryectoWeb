/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;
import CapaEntidades.EntidadDetalleFacturas;
import CapaLogica.BLFacturaClientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */

public class EliminarDetalle extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{ 

    
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
     resp. setContentType ("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();
    try {
    BLFacturaClientes LogicaDetalle = new BLFacturaClientes(); 
    int codigo = Integer.parseInt(req.getParameter("idproducto")); 
    int factura = Integer.parseInt(req.getParameter("idfactura"));
    EntidadDetalleFacturas Entidad = new EntidadDetalleFacturas(); 
    Entidad.setIdProducto(codigo); 
    Entidad.setIdFactura(factura); 
   // LogicaDetalle.Eliminar(Entidad);
    resp.sendRedirect("Facturacion.jsp?txtnumFactura="+factura);
    }
    catch (Exception e){
    out.print(e.getMessage());
        }   
    }
    
}//fin