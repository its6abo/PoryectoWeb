/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;
import CapaEntidades.EntidadProveedores;
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
public class DAProveedores {
    
    //Atributos
    private Connection _cnn;

    //GET
    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }
    
     //Constructor Inicializar
    public DAProveedores() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url); //Clase de tipo interfaz
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Insertar un proveedores
    public int Insertar(EntidadProveedores proveedores) throws SQLException {
        int id = -1;
        String sentencia = "INSERT INTO CR_Proveedores(NOMBRE,CEDULA,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC) VALUES(?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proveedores.getNombre());
            ps.setString(2, proveedores.getCedula());
            ps.setString(3, proveedores.getDireccion());
            ps.setString(4, proveedores.getTelefono1());
            ps.setString(5, proveedores.getTelefono2());
            ps.setString(6, proveedores.getCorreo());
            ps.setInt(7, proveedores.getIdTipodoc());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
                mensaje = "Proveedor ingresado satisfactoriamente";
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return id;
    }
    
     //Modificar un proveedor
        public int Modificar(EntidadProveedores proveedores) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE CR_Proveedores SET NOMBRE=?,CEDULA=?,ESTADO=?,DIRECCION=?,TELEFONO1=?,TELEFONO2=?,CORREO=?,IDTIPODOC=? WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
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
               mensaje = "Proveedor modificado!"; 
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
        
        
    //Eliminar un proveedor
    public int Eliminar(EntidadProveedores proveedores) throws SQLException {
        int resultado = 0;
        String sentencia = "update CR_Proveedores set estado = 0 WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, proveedores.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Proveedor eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
    
     //Listar Registros en un ResultSet
    public ResultSet ListarProveedores(String condicion, String orden) throws SQLException{
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Proveedores";
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
    public List<EntidadProveedores> ListarProveedores(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadProveedores> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Proveedores";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
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
            _cnn = null;
        }     
        return lista;
    }
    
    //Método para obtener un proveedor
    public EntidadProveedores ObtenerUnProveedor(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadProveedores provedores = new EntidadProveedores();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDTIPODOC FROM CR_Proveedores";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
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
            _cnn = null;
        }
        return provedores;
    }
      
}//Fin Clase
