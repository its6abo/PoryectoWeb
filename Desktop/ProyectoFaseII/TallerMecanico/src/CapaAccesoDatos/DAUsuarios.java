/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadUsuarios;
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
public class DAUsuarios {
    
     //Atributos
    private Connection _cnn;

    //GET
    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }
    
     //Constructor Inicializar
    public DAUsuarios() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url); //Clase de tipo interfaz
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Insertar un usuario
    public int Insertar(EntidadUsuarios usuarios) throws SQLException {
        int id = -1;
        String sentencia = "INSERT INTO CR_Usuarios(NOMBRE,CEDULA,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDPERFIL,pass) VALUES(?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getCedula());
            ps.setString(3, usuarios.getDireccion());
            ps.setString(4, usuarios.getTelefono1());
            ps.setString(5, usuarios.getTelefono2());
            ps.setString(6, usuarios.getCorreo());
            ps.setInt(7, usuarios.getIdPerfil());
            ps.setString(8, usuarios.getPass());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
                mensaje = "Usuario ingresado satisfactoriamente";
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return id;
    }
    
     //Modificar un usuario
        public int Modificar(EntidadUsuarios usuarios) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE CR_Usuarios SET NOMBRE=?,CEDULA=?,ESTADO=?,DIRECCION=?,TELEFONO1=?,TELEFONO2=?,CORREO=?,IDPERFIL=? WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getCedula());
            ps.setBoolean(3, usuarios.isEstado());
            ps.setString(4, usuarios.getDireccion());
            ps.setString(5, usuarios.getTelefono1());
            ps.setString(6, usuarios.getTelefono2());
            ps.setString(7, usuarios.getCorreo());
            ps.setInt(8, usuarios.getIdPerfil());
            ps.setInt(9, usuarios.getId());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Usuario modificado!"; 
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
        
        
    //Eliminar un usuario
    public int Eliminar(EntidadUsuarios usuarios) throws SQLException {
        int resultado = 0;
        String sentencia = "update CR_Usuarios set estado = 0 WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, usuarios.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Usuario eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
    
     //Listar Registros en un ResultSet
    public ResultSet ListarUsuario(String condicion, String orden) throws SQLException{
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDPERFIL,FECHA FROM CR_Usuarios";
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
    public List<EntidadUsuarios> ListarUsuarios(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadUsuarios> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDPERFIL,FECHA FROM CR_Usuarios";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadUsuarios(rs.getInt("ID"),
                                             rs.getString("NOMBRE"),
                                             rs.getString("CEDULA"),
                                             rs.getBoolean("ESTADO"),
                                             rs.getString("DIRECCION"),
                                             rs.getString("TELEFONO1"),
                                             rs.getString("TELEFONO2"),
                                             rs.getString("CORREO"),
                                             rs.getInt("IDPERFIL"),
                                             rs.getDate("FECHA")
                ));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }     
        return lista;
    }
    
    //Método para obtener un usuario
    public EntidadUsuarios ObtenerUnUsuarios(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadUsuarios usuarios = new EntidadUsuarios();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDPERFIL,FECHA,PASS FROM CR_Usuarios";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                usuarios.setId(rs.getInt(1));
                usuarios.setNombre(rs.getString(2));
                usuarios.setCedula(rs.getString(3));
                usuarios.setEstado(rs.getBoolean(4));
                usuarios.setDireccion(rs.getString(5));
                usuarios.setTelefono1(rs.getString(6));
                usuarios.setTelefono2(rs.getString(7));
                usuarios.setCorreo(rs.getString(8));
                usuarios.setIdPerfil(rs.getInt(9));
                usuarios.setFecha(rs.getDate(10));
                usuarios.setExiste(true);
                usuarios.setPass(rs.getString(11));
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return usuarios;
    }
    
}
