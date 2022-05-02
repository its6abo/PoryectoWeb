/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaAccesoDatos.DAClientes;
import CapaEntidades.EntidadClientes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
 public class BLClientes {
    //Atributos
    private String mensaje;
    
    //Método 
    public String getMensaje(){
        return mensaje;
    }
    
    //Llamar al método modificar de la lógica
    public int Modificar(EntidadClientes cliente) throws Exception{
        int resultado = -1;
        DAClientes daCliente;
        try {
           daCliente = new DAClientes();
           resultado = daCliente.Modificar(cliente);
           mensaje = daCliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método eliminar de la lógica
    public int Eliminar(EntidadClientes cliente) throws Exception{
        int resultado = -1;
        DAClientes daCliente;
        try {
           daCliente = new DAClientes();
           resultado = daCliente.Eliminar(cliente);
           mensaje = daCliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método insertar de la lógica
    public int Insertar(EntidadClientes cliente) throws Exception{
        int resultado = -1;
        DAClientes daCliente;
        try {
           daCliente = new DAClientes();
           resultado = daCliente.Insertar(cliente);
           mensaje = daCliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    public List<EntidadClientes> ListarClientes(String condicion) throws Exception{
        List<EntidadClientes> clientes = new ArrayList();
        DAClientes daCliente;
        try {
            daCliente = new DAClientes();
            clientes = daCliente.ListarClientes(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return clientes;
    }
    
    public EntidadClientes ObtenerUnCliente(String condicion) throws Exception{
        EntidadClientes resultado;
        DAClientes daCliente;
        try {
            daCliente = new DAClientes();
            resultado = daCliente.ObtenerUnCliente(condicion);
            if (resultado.getExiste()) {
                mensaje = "Cliente encontrado!";
            }
            else{
                mensaje = "Cliente NO encontrado";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
}
