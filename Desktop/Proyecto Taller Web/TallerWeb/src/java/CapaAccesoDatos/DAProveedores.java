/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;
import CapaEntidades.EntidadProveedores;
import java.sql.Connection;
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
public class DAProveedores {
    
        //ATRUBUTOS
    private String _mensaje;
    
    //PROPIEDADES
    public String getMensaje(){
        return _mensaje;
    }
    //CONSTRUCTORES
    public DAProveedores(){
        _mensaje="";
    }
    
    //Listar
    public List<EntidadProveedores> ListarProveedores(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        Connection _conexion = null;
        List<EntidadProveedores> lista = new ArrayList();
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia;
            sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Proveedores WHERE estado=1";
            if (!condicion.equals("")) {
                // se le quita el where a la sentencia para que no haya conflicto a la hora de buscar. 
                sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Proveedores";
                sentencia = String.format("%s WHERE estado=1 AND %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadProveedores(rs.getInt("ID"),
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
    }
    
    //Fin Listar
    
    //Insertar
    public int Insertar(EntidadProveedores proveedores) throws SQLException, Exception {
        int id = -1;
        String sentencia = "INSERT INTO CR_Proveedores(NOMBRE,CEDULA,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC) VALUES(?,?,?,?,?,?,?) ";
        Connection _conexion = null;
        try {
             _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();  
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, proveedores.getNombre());
            ps.setString(2, proveedores.getCedula());
            ps.setString(3, proveedores.getDireccion());
            ps.setString(4, proveedores.getTelefono1());
            ps.setString(5, proveedores.getTelefono2());
            ps.setString(6, proveedores.getCorreo());
            ps.setInt(7, proveedores.getIdTipodoc());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
            ClaseConexion.close(_conexion);
            }
        }
        return id;
    }//Fin Insertar
    
    
         //Modificar un proveedor
        public int Modificar(EntidadProveedores proveedores) throws SQLException, Exception {
        int resultado = 0;
        String sentencia = "UPDATE CR_Proveedores SET NOMBRE=?,CEDULA=?,ESTADO=?,DIRECCION=?,TELEFONO1=?,TELEFONO2=?,CORREO=?,IDTIPODOC=? WHERE ID=?";
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, proveedores.getNombre());
            ps.setString(2, proveedores.getCedula());
            ps.setBoolean(3, proveedores.isEstado());
            ps.setString(4, proveedores.getDireccion());
            ps.setString(5, proveedores.getTelefono1());
            ps.setString(6, proveedores.getTelefono2());
            ps.setString(7, proveedores.getCorreo());
            ps.setInt(8, proveedores.getIdTipodoc());
            ps.setInt(9, proveedores.getId());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               _mensaje = "Proveedor modificado!"; 
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
    
    
        //Eliminar un proveedor
    public int Eliminar(EntidadProveedores proveedores) throws SQLException, ClassNotFoundException {
        int resultado = 0;
        String sentencia = "update CR_Proveedores set estado = 0 WHERE ID=?";
        Connection _conexion = null;
        try {
            _conexion=ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, proveedores.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               _mensaje = "Proveedor eliminado!"; 
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
    
    
        //Método para obtener un proveedor
    public EntidadProveedores ObtenerUnProveedor(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadProveedores provedores = new EntidadProveedores();
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Proveedores";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            if (rs.next()) {
                provedores.setId(rs.getInt(1));
                provedores.setNombre(rs.getString(2));
                provedores.setCedula(rs.getString(3));
                provedores.setEstado(rs.getBoolean(4));
                provedores.setDireccion(rs.getString(5));
                provedores.setTelefono1(rs.getString(6));
                provedores.setTelefono2(rs.getString(7));
                provedores.setCorreo(rs.getString(8));
                provedores.setIdTipodoc(rs.getInt(9));
                provedores.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
                if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return provedores;
    }

}//Fin Clase
