/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaEntidades.EntidadProveedores;
import CapaLogica.BLProveedores;
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
public class CrearModificarProveedores extends HttpServlet {

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
             BLProveedores logica = new BLProveedores();
            int resultado;
            EntidadProveedores proveedores = new EntidadProveedores();
            proveedores.setEstado(true);
            proveedores.setId(Integer.parseInt(request.getParameter("txtCodigo")));
            proveedores.setIdTipodoc(Integer.parseInt(request.getParameter("doc")));
            proveedores.setNombre(new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"),"UTF-8"));  
            proveedores.setCedula(new String(request.getParameter("txtCedula").getBytes("ISO-8859-1"),"UTF-8"));
            proveedores.setTelefono1(new String(request.getParameter("txtTelefono1").getBytes("ISO-8859-1"),"UTF-8"));
            proveedores.setTelefono2(new String(request.getParameter("txtTelefono2").getBytes("ISO-8859-1"),"UTF-8"));
            proveedores.setDireccion(new String(request.getParameter("txtDireccion").getBytes("ISO-8859-1"),"UTF-8"));
            proveedores.setCorreo(new String(request.getParameter("txtCorreo").getBytes("ISO-8859-1"),"UTF-8"));
              String mensaje = "";//Mensaje del procedimiento almacenado
            mensaje = URLEncoder.encode(mensaje, "UTF-8");
          
            if(proveedores.getId() > 0){
               mensaje = "Proveedor Modificado";//Mensaje del procedimiento almacenado
    
             resultado = logica.Modificar(proveedores);            
            }else{
                mensaje = "Proveedor Agregado";
           resultado= logica.Insertar(proveedores);
            }
            response.sendRedirect("ListarProveedores.jsp?meCli=" + mensaje + "&resultado=" + resultado);
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
