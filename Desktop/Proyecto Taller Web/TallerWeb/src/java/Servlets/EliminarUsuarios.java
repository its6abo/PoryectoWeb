
package Servlets;

import CapaEntidades.EntidadUsuarios;
import CapaLogica.BLUsuarios;
import java.io.*;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//Anotacion definir la ruta de acceso dentro de la aplicacion
@WebServlet("/EliminarUsuarios")
public class EliminarUsuarios extends HttpServlet{    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //para poder escribir en el html
        PrintWriter out = resp.getWriter();
        try
        {
            BLUsuarios logica = new BLUsuarios();
            EntidadUsuarios usuarios = new EntidadUsuarios();
            //parametro que se envió Query String
            String id = req.getParameter("idEliminar");
            int codigo = Integer.parseInt(id);
            usuarios.setId(codigo);
            int resultado = logica.Eliminar(usuarios);
            String mensaje = logica.getMensaje();//Mensaje del procedimiento almacenado
            mensaje = URLEncoder.encode(mensaje, "UTF-8");
            resp.sendRedirect("ListarUsuarios.jsp?meCli=" + mensaje + "&resultado=" + resultado);
        } catch (Exception ex)
        {
            out.print(ex.getMessage());
        }
    }
    
    //sobreescribir el método doGet
    
    
   
}//Fin class EliminarClientes
