/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaAccesoDatos.DAFacturasClientes;
import CapaEntidades.EntidadFacturaClientes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class BLFacturaClientes {
    
        //Atributos
    private String mensaje;
    
    //Método 
    public String getMensaje(){
        return mensaje;
    }
    
    

    
    //Llamar al método insertar de la lógica
    public int Insertar(EntidadFacturaClientes productos) throws Exception{
        int resultado = -1;
        DAFacturasClientes dafactura;
        try {
           dafactura = new DAFacturasClientes();
           resultado = dafactura.Insertar(productos);
           mensaje = dafactura.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    public List<EntidadFacturaClientes> Listar(String condicion) throws Exception{
        List<EntidadFacturaClientes> facturas = new ArrayList();
        DAFacturasClientes daFacturas;
        try {
            daFacturas = new DAFacturasClientes();
            facturas = daFacturas.ListarFacturas(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return facturas;
    }
    
  
    
    
}
