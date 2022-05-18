/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaAccesoDatos.DAProductos;
import CapaEntidades.EntidadProductos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class BLProductos {
    
        public List<EntidadProductos> ListarProductos(String condicion) throws Exception{
        List<EntidadProductos> productos = new ArrayList();
        DAProductos daProductos;
        try {
            daProductos = new DAProductos();
            productos = daProductos.ListarProductos(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return productos;
    }
    
    //Atributos
    private String mensaje;
    
    //Método 
    public String getMensaje(){
        return mensaje;
    }    
    
    
    //Llamar al método modificar de la lógica
    public int Modificar(EntidadProductos productos) throws Exception{
        int resultado = -1;
        DAProductos daProductos;
        try {
           daProductos = new DAProductos();
           resultado = daProductos.Modificar(productos);
           mensaje = daProductos.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método eliminar de la lógica
    public int Eliminar(EntidadProductos productos) throws Exception{
        int resultado = -1;
        DAProductos daProductos;
        try {
           daProductos = new DAProductos();
           resultado = daProductos.Eliminar(productos);
           mensaje = daProductos.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método insertar de la lógica
    public int Insertar(EntidadProductos productos) throws Exception{
        int resultado = -1;
        DAProductos daProductos;
        try {
           daProductos = new DAProductos();
           resultado = daProductos.Insertar(productos);
           mensaje = daProductos.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    

    
    public EntidadProductos ObtenerUnProducto(String condicion) throws Exception{
        EntidadProductos resultado;
        DAProductos daProductos;
        try {
            daProductos = new DAProductos();
            resultado = daProductos.ObtenerUnProducto(condicion);
            if (resultado.getExiste()) {
                mensaje = "Producto encontrado!";
            }
            else{
                mensaje = "Producto NO encontrado";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
}//Fin
