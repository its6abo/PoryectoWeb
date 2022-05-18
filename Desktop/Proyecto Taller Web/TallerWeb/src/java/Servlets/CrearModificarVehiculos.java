/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaEntidades.EntidadVehiculos;
import CapaLogica.BLVehiculos;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
public class CrearModificarVehiculos extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try
        {
             BLVehiculos logica = new BLVehiculos();
            int resultado;
            EntidadVehiculos vehiculo = new EntidadVehiculos();
            vehiculo.setEstado(true);
            vehiculo.setId(Integer.parseInt(request.getParameter("txtCodigo")));
            vehiculo.setPlaca(new String(request.getParameter("txtPlaca").getBytes("ISO-8859-1"),"UTF-8"));  
            vehiculo.setIdTipoVehiculo(Integer.parseInt(request.getParameter("tipovehiculo")));
            vehiculo.setIdEstilo(Integer.parseInt(request.getParameter("estilo")));
            vehiculo.setIdMarca(Integer.parseInt(request.getParameter("marca")));
            vehiculo.setIdTipoCombustible(Integer.parseInt(request.getParameter("combustible")));
            vehiculo.setIdTipoTransmision(Integer.parseInt(request.getParameter("transmision")));
              String mensaje = "";//Mensaje del procedimiento almacenado
            mensaje = URLEncoder.encode(mensaje, "UTF-8");
          
            if(vehiculo.getId() > 0){
               mensaje = "Vehiculo Modificado";//Mensaje del procedimiento almacenado
    
             resultado = logica.Modificar(vehiculo);            
            }else{
                mensaje = "Vehiculo Agregado";
           resultado= logica.Insertar(vehiculo);
            }
            response.sendRedirect("ListarVehiculos.jsp?meCli=" + mensaje + "&resultado=" + resultado);
        } catch (Exception ex)
        {
            //throw ex;
            
            out.print(ex.getMessage());
             
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
