/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;



import CapaEntidades.EntidadClientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static CapaAccesoDatos.ClaseConexion.getConnection;
import java.sql.Connection;
/**
 *
 * @author gabri
 */
public class DAClientes {
    //ATRUBUTOS
    private String _mensaje;
    
    //PROPIEDADES
    public String getMensaje(){
        return _mensaje;
    }
    //CONSTRUCTORES
    public DAClientes(){
        _mensaje="";
    }
    

    
   //Listar
    public List<EntidadClientes> ListarClientes(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadClientes cli;
        List<EntidadClientes> lista = new ArrayList();
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia;    
            sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Clientes WHERE estado=1";
            if (!condicion.equals("")) {
                // se le quita el where a la sentencia para que no haya conflicto a la hora de buscar. 
                sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Clientes";
                sentencia = String.format("%s WHERE estado=1 AND %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadClientes(rs.getInt("ID"),
                                             rs.getString("NOMBRE"),
                                             rs.getString("CEDULA"),
                                             rs.getBoolean("ESTADO"),
                                             rs.getString("DIRECCION"),
                                             rs.getString("TELEFONO1"),
                                             rs.getString("TELEFONO2"),
                                             rs.getString("CORREO"),
                                             rs.getInt("IDTIPODOC")
                ));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }     
        return lista;
    }//Fin listar
    
    
    
  //Insertar
    public int Insertar(EntidadClientes clientes) throws SQLException, Exception {
        int id = -1;
        String sentencia = "INSERT INTO CR_Clientes(IdTipodoc,NOMBRE,CEDULA,DIRECCION,TELEFONO1,TELEFONO2,CORREO) VALUES(?,?,?,?,?,?,?) ";
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();            
            PreparedStatement ps =_conexion.prepareStatement(sentencia);
            ps.setInt(1, clientes.getIdTipodoc());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getCedula());
            ps.setString(4, clientes.getDireccion());
            ps.setString(5, clientes.getTelefono1());
            ps.setString(6, clientes.getTelefono2());
            ps.setString(7, clientes.getCorreo());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
                     if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return id;
    } //Fin insertar 
    
    
         //Modificar 
        public int Modificar(EntidadClientes clientes) throws SQLException, Exception {
        int resultado = 0;
        String sentencia = "UPDATE CR_Clientes SET IDTIPODOC=?,NOMBRE=?,CEDULA=?,ESTADO=?,DIRECCION=?,TELEFONO1=?,TELEFONO2=?,CORREO=? WHERE ID=?";
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, clientes.getIdTipodoc());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getCedula());
            ps.setBoolean(4, clientes.isEstado());
            ps.setString(5, clientes.getDireccion());
            ps.setString(6, clientes.getTelefono1());
            ps.setString(7, clientes.getTelefono2());
            ps.setString(8, clientes.getCorreo());
            ps.setInt(9, clientes.getId());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               _mensaje = "Cliente modificado!"; 
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
                        if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;

    }// Fin Modificar
    
    
    //Eliminar
    public int Eliminar(EntidadClientes clientes) throws SQLException, Exception {
        int resultado = 0;
        String sentencia = "update CR_Clientes set estado = 0 WHERE ID=?";
        Connection _conexion = null;
        try {
            _conexion=ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, clientes.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               _mensaje = "Cliente eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;

    } //Fin Eliminar
    
    
    //Método para obtener 
    public EntidadClientes ObtenerUnCliente(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadClientes cliente = new EntidadClientes();
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Clientes";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setCedula(rs.getString(3));
                cliente.setEstado(rs.getBoolean(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setTelefono1(rs.getString(6));
                cliente.setTelefono2(rs.getString(7));
                cliente.setCorreo(rs.getString(8));
                cliente.setIdTipodoc(rs.getInt(9));
                cliente.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
                if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return cliente;
    }
    
} //Fin clase
