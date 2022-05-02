/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadClientes;
import Config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class DAClientes {
    //Atributos
    private Connection _cnn;

    //GET
    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }
    
    //Constructor Inicializar
    public DAClientes() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url); //Clase de tipo interfaz
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Insertar un cliente
    public int Insertar(EntidadClientes clientes) throws SQLException {
        int id = -1;
        String sentencia = "INSERT INTO CR_Clientes(IdTipodoc,NOMBRE,CEDULA,DIRECCION,TELEFONO1,TELEFONO2,CORREO) VALUES(?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clientes.getIdTipodoc());
            ps.setString(2, clientes.getNombre());
            ps.setString(3, clientes.getCedula());
            ps.setString(4, clientes.getDireccion());
            ps.setString(5, clientes.getTelefono1());
            ps.setString(6, clientes.getTelefono2());
            ps.setString(7, clientes.getCorreo());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
                mensaje = "Cliente ingresado satisfactoriamente";
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return id;
    }
    
     //Modificar un cliente
        public int Modificar(EntidadClientes clientes) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE CR_Clientes SET IDTIPODOC=?,NOMBRE=?,CEDULA=?,ESTADO=?,DIRECCION=?,TELEFONO1=?,TELEFONO2=?,CORREO=? WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
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
               mensaje = "Cliente modificado!"; 
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
        
        
    //Eliminar un cliente
    public int Eliminar(EntidadClientes clientes) throws SQLException {
        int resultado = 0;
        String sentencia = "update CR_Clientes set estado = 0 WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, clientes.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Cliente eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
    
     //Listar Registros en un ResultSet
    public ResultSet ListarClientes(String condicion, String orden) throws SQLException{
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,IDTIPODOC,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO FROM CR_Clientes";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            if (!orden.equals("")) {
                sentencia = String.format("%s ORDER BY %s", sentencia, orden);
            }
            rs = stm.executeQuery(sentencia);
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }     
        return rs;
    }
    
    //Listar Registros en un ResultSet
    public List<EntidadClientes> ListarClientes(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadClientes> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Clientes";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
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
            _cnn = null;
        }     
        return lista;
    }
    
    //Método para obtener un cliente
    public EntidadClientes ObtenerUnCliente(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadClientes cliente = new EntidadClientes();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Clientes";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
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
            _cnn = null;
        }
        return cliente;
    }
    
   
    
} //Fin clase
