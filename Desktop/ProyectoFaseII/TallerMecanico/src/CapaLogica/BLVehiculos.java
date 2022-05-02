/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaAccesoDatos.DAVehiculos;
import CapaEntidades.EntidadVehiculos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class BLVehiculos {
    //Atributos
    private String mensaje;
    
    //Método 
    public String getMensaje(){
        return mensaje;
    }
    
    //Llamar al método modificar de la lógica
    public int Modificar(EntidadVehiculos vehiculos) throws Exception{
        int resultado = -1;
        DAVehiculos daVehiculo;
        try {
           daVehiculo = new DAVehiculos();
           resultado = daVehiculo.Modificar(vehiculos);
           mensaje = daVehiculo.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método eliminar de la lógica
    public int Eliminar(EntidadVehiculos vehiculos) throws Exception{
        int resultado = -1;
        DAVehiculos daVehiculo;
        try {
           daVehiculo = new DAVehiculos();
           resultado = daVehiculo.Eliminar(vehiculos);
           mensaje = daVehiculo.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método insertar de la lógica
    public int Insertar(EntidadVehiculos vehiculos) throws Exception{
        int resultado = -1;
        DAVehiculos daVehiculo;
        try {
           daVehiculo = new DAVehiculos();
           resultado = daVehiculo.Insertar(vehiculos);
           mensaje = daVehiculo.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    public List<EntidadVehiculos> ListarVehiculos(String condicion) throws Exception{
        List<EntidadVehiculos> vehiculos = new ArrayList();
        DAVehiculos daVehiculo;
        try {
            daVehiculo = new DAVehiculos();
            vehiculos = daVehiculo.ListarVehiculos(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return vehiculos;
    }
    
    public EntidadVehiculos ObtenerUnVehiculo(String condicion) throws Exception{
        EntidadVehiculos resultado;
        DAVehiculos daVehiculo;
        try {
            daVehiculo = new DAVehiculos();
            resultado = daVehiculo.ObtenerUnVehiculo(condicion);
            if (resultado.getExiste()) {
                mensaje = "Vehiculo encontrado!";
            }
            else{
                mensaje = "Vehiculo NO encontrado";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
 
    
}//Fin
