/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaEntidades.EntidadDetalleFacturas;
import CapaEntidades.EntidadFacturaClientes;
import CapaLogica.BLFacturaClientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */
public class Facturar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
              EntidadFacturaClientes factura = new EntidadFacturaClientes();
  HttpSession sesion1 = request.getSession();
      CapaEntidades.EntidadUsuarios usuario = (CapaEntidades.EntidadUsuarios)sesion1.getAttribute("usuario");
                //mpresa.setId(Integer.parseInt(txtId.getText()));
                factura.setIdEmpresa(1);
                factura.setIdCliente(1);
                factura.setIdUsuario(usuario.getId());
              //usuarios.setEstado(Boolean.valueOf(txtEstado.getText()));
                factura.setDescuento(0);
                  HttpSession sesion2 = request.getSession();
              List<EntidadDetalleFacturas> misDetalles = (List<EntidadDetalleFacturas>)sesion2.getAttribute("misDetalles");
               float total = 0;
              for (EntidadDetalleFacturas det : misDetalles) {
                 total += det.getTotal();
                 }
                factura.setTotal(total);
                factura.setListaDetalles(misDetalles);               
                factura.setIdTipoFactura(1);   
                BLFacturaClientes logica = new BLFacturaClientes();     
                logica.Insertar(factura);            
          misDetalles = null;
          sesion2.setAttribute("misDetalles", misDetalles);
         response.sendRedirect("Facturacion.jsp?msgFac=" + "Producto agregado" + "&txtnumFactura= 1" );
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Facturar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Facturar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
