/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadProductos;
import Config.Config;
import java.sql.Connection;
import java.sql.Date;
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
public class DAProductos {
    
    //Atributos
    private Connection _cnn;

    //GET
    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }
    
    //Constructor Inicializar
    public DAProductos() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url); //Clase de tipo interfaz
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Insertar un producto
    public int Insertar(EntidadProductos productos) throws SQLException {
        int id = -1;
        String sentencia = "INSERT INTO CR_Producto(IDEMPRESA,DESCRIPCION,PRECIOCOSTO,PRECIOVENTA) VALUES(?,?,?,?) ";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, productos.getIdEmpresa());
            ps.setString(2, productos.getDescripcion());
            ps.setInt(3, productos.getPrecioCosto());
            ps.setInt(4,productos.getPrecioVenta());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
                mensaje = "Producto ingresado satisfactoriamente";
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return id;
    }
    
     //Modificar un producto
        public int Modificar(EntidadProductos productos) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE CR_Producto SET IDEMPRESA=?,DESCRIPCION=?,PRECIOCOSTO=?,PRECIOVENTA=? WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, productos.getIdEmpresa());
            ps.setString(2, productos.getDescripcion());
            ps.setInt(3, productos.getPrecioCosto());
            ps.setInt(4,productos.getPrecioVenta()); 
            ps.setInt(5,productos.getId()); 
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Producto modificado!"; 
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
        
        
    //Eliminar un producto
    public int Eliminar(EntidadProductos productos) throws SQLException {
        int resultado = 0;
        String sentencia = "update CR_Producto set estado = 0 WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, productos.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Producto eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
    
     //Listar Registros en un ResultSet
    public ResultSet ListarProductos(String condicion, String orden) throws SQLException{
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,IDEMPRESA,DESCRIPCION,PRECIOCOSTO,PRECIOVENTA,ESTADO,FECHA FROM CR_Producto";
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
    public List<EntidadProductos> ListarProductos(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadProductos> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,IDEMPRESA,DESCRIPCION,PRECIOCOSTO,PRECIOVENTA,ESTADO,FECHA FROM CR_Producto";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadProductos(rs.getInt("ID"),
                                             rs.getInt("IDEMPRESA"),
                                             rs.getString("DESCRIPCION"),
                                             rs.getInt("PRECIOCOSTO"),
                                             rs.getInt("PRECIOVENTA"),
                                             rs.getDate("FECHA"), 
                                             rs.getBoolean("ESTADO")
                ));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }     
        return lista;
    }
    
    //Método para obtener un producto
    public EntidadProductos ObtenerUnProducto(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadProductos productos = new EntidadProductos();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,IDEMPRESA,DESCRIPCION,PRECIOCOSTO,PRECIOVENTA,ESTADO,FECHA FROM CR_Producto";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                productos.setId(rs.getInt(1));
                productos.setIdEmpresa(rs.getInt(2));
                productos.setDescripcion(rs.getString(3));
                productos.setPrecioCosto(rs.getInt(4));
                productos.setPrecioVenta(rs.getInt(5));
                productos.setEstado(rs.getBoolean(6));
                productos.setFecha(rs.getDate(7));
                productos.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return productos;
    }
   
    
}
