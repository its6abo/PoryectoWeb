/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaEntidades.EntidadFacturaClientes;
import CapaLogica.BLFacturaClientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
public class CrearFactura extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        EntidadFacturaClientes fac = new EntidadFacturaClientes();
        BLFacturaClientes log = new BLFacturaClientes();
       fac.setIdUsuario(Integer.parseInt(request.getParameter("txtIdUsuario")));
          fac.setIdCliente(Integer.parseInt(request.getParameter("txtIdCliente")));
          fac.setIdTipoFactura(1);
          int cantidad =Integer.parseInt(request.getParameter("txtCantidad"));
          int Precio =Integer.parseInt(request.getParameter("txtprecio"));
          fac.setTotal(cantidad*Precio);
    }


}
