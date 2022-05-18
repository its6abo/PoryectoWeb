/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaAccesoDatos.DAUsuarios;
import CapaLogica.BLUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
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
public class login extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
          
            CapaAccesoDatos.DAUsuarios miUsuario = new CapaAccesoDatos.DAUsuarios();   
            String cedula=(new String(request.getParameter("txtusuariolo")));
            BLUsuarios logica = new BLUsuarios();
            String contrasenia1=(new String(request.getParameter("txtpasslo"))); 
            String  contrasenia=logica.toHexString(contrasenia1);
            String condicion = ("estado = 1 and cedula = '"+cedula+"'");
                 
              CapaEntidades.EntidadUsuarios usuarios = miUsuario.ObtenerUnUsuarios(condicion);
              if(usuarios.getPass().equals(contrasenia)){
                if(usuarios.getId() > 0){
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("usuario", usuarios);
                     response.sendRedirect("index.html");  
                }else{           
                  response.sendRedirect("Login.jsp?msgFac=");
                }
                }
        
        }catch(Exception ex){

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
