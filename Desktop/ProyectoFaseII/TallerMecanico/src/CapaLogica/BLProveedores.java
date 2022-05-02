/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaAccesoDatos.DAProveedores;
import CapaEntidades.EntidadProveedores;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class BLProveedores {
     //Atributos
    private String mensaje;
    
    //Método 
    public String getMensaje(){
        return mensaje;
    }
    
    //Llamar al método modificar de la lógica
    public int Modificar(EntidadProveedores cliente) throws Exception{
        int resultado = -1;
        DAProveedores daProvedor;
        try {
           daProvedor = new DAProveedores();
           resultado = daProvedor.Modificar(cliente);
           mensaje = daProvedor.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método eliminar de la lógica
    public int Eliminar(EntidadProveedores cliente) throws Exception{
        int resultado = -1;
        DAProveedores daCliente;
        try {
           daCliente = new DAProveedores();
           resultado = daCliente.Eliminar(cliente);
           mensaje = daCliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método insertar de la lógica
    public int Insertar(EntidadProveedores cliente) throws Exception{
        int resultado = -1;
        DAProveedores daCliente;
        try {
           daCliente = new DAProveedores();
           resultado = daCliente.Insertar(cliente);
           mensaje = daCliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    public List<EntidadProveedores> ListarProveedor(String condicion) throws Exception{
        List<EntidadProveedores> proveedores = new ArrayList();
        DAProveedores daCliente;
        try {
            daCliente = new DAProveedores();
            proveedores = daCliente.ListarProveedores(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return proveedores;
    }
    
    public EntidadProveedores ObtenerUnProveedor(String condicion) throws Exception{
        EntidadProveedores resultado;
        DAProveedores DAProveedores;
        try {
            DAProveedores = new DAProveedores();
            resultado = DAProveedores.ObtenerUnProveedor(condicion);
            if (resultado.getExiste()) {
                mensaje = "Proveedor encontrado!";
            }
            else{
                mensaje = "Proveedor NO encontrado";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
}
