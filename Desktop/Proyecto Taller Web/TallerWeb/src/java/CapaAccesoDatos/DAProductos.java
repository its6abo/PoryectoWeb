/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadProductos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static CapaAccesoDatos.ClaseConexion.getConnection;

/**
 *
 * @author gabri
 */
public class DAProductos {
    
    //ATRUBUTOS
    private String _mensaje;
    
    //PROPIEDADES
    public String getMensaje(){
        return _mensaje;
    }
    //CONSTRUCTORES
    public DAProductos(){
        _mensaje="";
    }
    
 
     //Listar 
    public List<EntidadProductos> ListarProductos(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        Connection _conexion = null;
        List<EntidadProductos> lista = new ArrayList();
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia = "SELECT ID,IDEMPRESA,DESCRIPCION,PRECIOCOSTO,PRECIOVENTA,FECHA,ESTADO,Stock FROM CR_Producto WHERE estado=1";
            if (!condicion.equals("")) {
                // se le quita el where a la sentencia para que no haya conflicto a la hora de buscar. 
                sentencia = "SELECT ID,IDEMPRESA,DESCRIPCION,PRECIOCOSTO,PRECIOVENTA,FECHA,ESTADO,Stock FROM CR_Producto";
                sentencia = String.format("%s WHERE estado=1 AND %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadProductos(rs.getInt("ID"),
                                             rs.getInt("IDEMPRESA"),
                                             rs.getString("DESCRIPCION"),
                                             rs.getInt("PRECIOCOSTO"),
                                             rs.getInt("PRECIOVENTA"),
                                             rs.getDate("FECHA"), 
                                             rs.getBoolean("ESTADO"),
                                             rs.getFloat("Stock")
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
    }
    
    
    //Insertar un producto
    public int Insertar(EntidadProductos productos) throws SQLException {
        int id = -1;
        String sentencia = "INSERT INTO CR_Producto(IDEMPRESA,DESCRIPCION,PRECIOCOSTO,PRECIOVENTA,STOCK) VALUES(?,?,?,?,?) ";
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();  
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, productos.getIdEmpresa());
            ps.setString(2, productos.getDescripcion());
            ps.setInt(3, productos.getPrecioCosto());
            ps.setInt(4,productos.getPrecioVenta());
            ps.setFloat(5,productos.getStock());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
       
        } finally {
            if(_conexion != null){
            ClaseConexion.close(_conexion);
            }
        return id;
    }
    }
    
    //Modificar un producto
        public int Modificar(EntidadProductos productos) throws SQLException, Exception{
        int resultado = 0;
        String sentencia = "UPDATE CR_Producto SET IDEMPRESA=?,DESCRIPCION=?,PRECIOCOSTO=?,PRECIOVENTA=?,STOCK=? WHERE ID=?";
        Connection _conexion = null; 
        try {
             _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, productos.getIdEmpresa());
            ps.setString(2, productos.getDescripcion());
            ps.setInt(3, productos.getPrecioCosto());
            ps.setInt(4,productos.getPrecioVenta());
            ps.setFloat(5,productos.getStock());
            ps.setInt(6,productos.getId()); 
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               _mensaje = "Producto modificado!"; 
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
                              if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;   
    }    
    
    //Eliminar un producto
    public int Eliminar(EntidadProductos productos) throws SQLException, Exception {
        int resultado = 0;
        String sentencia = "update CR_Producto set estado = 0 WHERE ID=?";
        Connection _conexion = null;
        try {
            _conexion=ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, productos.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               _mensaje = "Producto eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;

    }
    
    
      //Método para obtener un producto
    public EntidadProductos ObtenerUnProducto(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadProductos productos = new EntidadProductos();
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia = "SELECT ID,IDEMPRESA,DESCRIPCION,PRECIOCOSTO,PRECIOVENTA,ESTADO,FECHA FROM CR_Producto";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
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
                if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return productos;
    }
    
}
