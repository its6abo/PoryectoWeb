/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import CapaEntidades.EntidadEmpresas;
import CapaLogica.BLEmpresas;
import java.io.*;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EliminarEmpresas")
public class EliminarEmpresas extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //para poder escribir en el html
        PrintWriter out = resp.getWriter();
        try
        {
            BLEmpresas logica = new BLEmpresas();
            EntidadEmpresas proveedores = new EntidadEmpresas();
            //parametro que se envió Query String
            String id = req.getParameter("idEliminar");
            int codigo = Integer.parseInt(id);
            proveedores.setId(codigo);
            int resultado = logica.Eliminar(proveedores);
            String mensaje = logica.getMensaje();//Mensaje del procedimiento almacenado
            mensaje = URLEncoder.encode(mensaje, "UTF-8");
            resp.sendRedirect("ListarEmpresas.jsp?meCli=" + mensaje + "&resultado=" + resultado);
        } catch (Exception ex)
        {
            out.print(ex.getMessage());
        }
    }
}
