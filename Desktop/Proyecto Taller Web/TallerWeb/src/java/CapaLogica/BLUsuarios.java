/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;


import CapaAccesoDatos.DAUsuarios;
import CapaEntidades.EntidadUsuarios;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class BLUsuarios {
    
         public List<EntidadUsuarios> ListarRegistros(String condicion) throws Exception{
        List<EntidadUsuarios> resultado=new ArrayList();
        DAUsuarios daProducto;
        try {
            daProducto=new DAUsuarios();
            resultado=daProducto.ListarRegistros(condicion);
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
         }
    
    //Atributos
    private String mensaje;
    
    //Método 
    public String getMensaje(){
        return mensaje;
    }
    
  
    public static String toHexString(String pass) throws NoSuchAlgorithmException
    {
        // Convert byte array into signum representation
         MessageDigest md = MessageDigest.getInstance("SHA-256");
        BigInteger number = new BigInteger(1, md.digest(pass.getBytes(StandardCharsets.UTF_8)));        
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        } 
        return hexString.toString();
    }
    
    //Modificar
    public int Modificar(EntidadUsuarios usuarios) throws Exception{
        int resultado = -1;
        DAUsuarios daUsuarios;
        try {
           daUsuarios = new DAUsuarios();
           resultado = daUsuarios.Modificar(usuarios);
           mensaje = daUsuarios.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método eliminar de la lógica
    public int Eliminar(EntidadUsuarios usuarios) throws Exception{
        int resultado = -1;
        DAUsuarios daUsuario;
        try {
           daUsuario = new DAUsuarios();
           resultado = daUsuario.Eliminar(usuarios);
           mensaje = daUsuario.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método insertar de la lógica
    public int Insertar(EntidadUsuarios usuarios) throws Exception{
        int resultado = -1;
        DAUsuarios daCliente;
        try {
           daCliente = new DAUsuarios();
           resultado = daCliente.Insertar(usuarios);
           mensaje = daCliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    public EntidadUsuarios ObtenerUnUsuarios(String condicion) throws Exception{
        EntidadUsuarios resultado;
        DAUsuarios DAUsuarios;
        try {
            DAUsuarios = new DAUsuarios();
            resultado = DAUsuarios.ObtenerUnUsuarios(condicion);
            if (resultado.getExiste()) {
                mensaje = "Usuario encontrado!";
            }
            else{
                mensaje = "Usuario NO encontrado";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
}
