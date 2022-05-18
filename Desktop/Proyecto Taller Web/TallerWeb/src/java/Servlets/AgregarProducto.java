/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaEntidades.EntidadDetalleFacturas;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */
public class AgregarProducto extends HttpServlet {
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
     List<EntidadDetalleFacturas> misDetalles = new ArrayList();  
     HttpSession sesion = request.getSession();
     misDetalles = (List<EntidadDetalleFacturas>)sesion.getAttribute("misDetalles");

         
        EntidadDetalleFacturas detalle = new EntidadDetalleFacturas();
    detalle.setIdProducto(Integer.parseInt(request.getParameter("txtIdProducto")));
                    detalle.setCantidad(Float.parseFloat(request.getParameter("txtcantidad")));
                     detalle.setNombre(request.getParameter("txtdescripcion"));
                     detalle.setPrecioVenta(Float.parseFloat(request.getParameter("txtprecio")));
                     detalle.setTotal(Float.parseFloat(request.getParameter("txtcantidad"))* Float.parseFloat(request.getParameter("txtprecio")));
       
        if(misDetalles == null)
        {
             misDetalles = new ArrayList();  
             misDetalles.add(detalle);
        }else
        {
            if(!validarExistencia(detalle.getIdProducto(), misDetalles)){
                   
                     misDetalles.add(detalle);
            }else{
            Integer cont = 0;
             List<EntidadDetalleFacturas> lista2 = misDetalles;
            for (EntidadDetalleFacturas det : lista2) {
                if (det.getIdProducto() == Integer.parseInt(request.getParameter("txtIdProducto"))){
                det.setCantidad(det.getCantidad() + Float.parseFloat(request.getParameter("txtcantidad")));
                det.setTotal(det.getTotal()+ Float.parseFloat(request.getParameter("txtprecio"))* Float.parseFloat(request.getParameter("txtcantidad")));
                  lista2.set(cont, det);
                     break;
                 }
                cont ++;
            }
            }
          
        }
       
        
        sesion.setAttribute("misDetalles", misDetalles);
         response.sendRedirect("Facturacion.jsp?msgFac=" + "Producto agregado" + "&txtnumFactura= 1" );
        }
    }
    
       public boolean validarExistencia(int idProducto,List<EntidadDetalleFacturas> lista){
       boolean ok = false;
       for (EntidadDetalleFacturas det : lista) {
            if (det.getIdProducto() == idProducto){
                ok = true;
                     break;
                 }
         }
       return ok;
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
        processRequest(request, response);
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
        processRequest(request, response);
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
