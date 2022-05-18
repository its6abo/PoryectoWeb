/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaEntidades.EntidadClientes;
import CapaLogica.BLClientes;
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
public class CrearModificarClientes extends HttpServlet {

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
            BLClientes logica = new BLClientes();
            int resultado;
            EntidadClientes clientes = new EntidadClientes();
            clientes.setEstado(true);
            clientes.setId(Integer.parseInt(request.getParameter("txtCodigo")));
            clientes.setIdTipodoc(Integer.parseInt(request.getParameter("doc")));
            clientes.setNombre(new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"),"UTF-8"));  
            clientes.setCedula(new String(request.getParameter("txtCedula").getBytes("ISO-8859-1"),"UTF-8"));
            clientes.setTelefono1(new String(request.getParameter("txtTelefono1").getBytes("ISO-8859-1"),"UTF-8"));
            clientes.setTelefono2(new String(request.getParameter("txtTelefono2").getBytes("ISO-8859-1"),"UTF-8"));
            clientes.setDireccion(new String(request.getParameter("txtDireccion").getBytes("ISO-8859-1"),"UTF-8"));
            clientes.setCorreo(new String(request.getParameter("txtCorreo").getBytes("ISO-8859-1"),"UTF-8"));
              String mensaje = "";//Mensaje del procedimiento almacenado
            mensaje = URLEncoder.encode(mensaje, "UTF-8");
          
            if(clientes.getId() > 0){
               mensaje = "Cliente Modificado";//Mensaje del procedimiento almacenado
    
             resultado = logica.Modificar(clientes);            
            }else{
                mensaje = "Cliente Agregado";
           resultado= logica.Insertar(clientes);
            }
            response.sendRedirect("ListarClientes.jsp?meCli=" + mensaje + "&resultado=" + resultado);
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
