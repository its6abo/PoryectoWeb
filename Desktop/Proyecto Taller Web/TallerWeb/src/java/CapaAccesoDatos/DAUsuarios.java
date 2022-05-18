/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadUsuarios;
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
public class DAUsuarios {
    
        //ATRUBUTOS
    private String _mensaje;
    
    //PROPIEDADES
    public String getMensaje(){
        return _mensaje;
    }
    //CONSTRUCTORES
    public DAUsuarios(){
        _mensaje="";
    }

    //Listar
    public List<EntidadUsuarios> ListarRegistros(String condicion) throws Exception{
        ResultSet rs = null;
        EntidadUsuarios usuario;
        List<EntidadUsuarios> lista = new ArrayList<>();
        Connection _conexion = null;
        try {
            //abrir la conexion 
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia;
            sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDPERFIL,FECHA FROM CR_Usuarios WHERE estado=1";
            if(!condicion.equals("")){
                // se le quita el where a la sentencia para que no haya conflicto a la hora de buscar. 
                sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDPERFIL,FECHA FROM CR_Usuarios";
                sentencia = String.format("%s WHERE estado=1 AND %s", sentencia,condicion);
            }
            rs = st.executeQuery(sentencia);
            //recorrer el rs para cargar la lista
            while (rs.next()){
               usuario=(new EntidadUsuarios(rs.getInt("ID"),
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
                lista.add(usuario);
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
    public int Insertar(EntidadUsuarios usuarios) throws SQLException, Exception {
        int id = -1;
        String sentencia = "INSERT INTO CR_Usuarios(NOMBRE,CEDULA,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDPERFIL,pass) VALUES(?,?,?,?,?,?,?,?) ";
         Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            PreparedStatement ps = _conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            usuarios.setPass("5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5");
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getCedula());
            ps.setString(3, usuarios.getDireccion());
            ps.setString(4, usuarios.getTelefono1());
            ps.setString(5, usuarios.getTelefono2());
            ps.setString(6, usuarios.getCorreo());
            ps.setInt(7, usuarios.getIdPerfil());
            ps.setString(8, usuarios.getPass());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
                       if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return id;
    }
    
     //Modificar un usuario
        public int Modificar(EntidadUsuarios usuarios) throws SQLException, Exception {
        int resultado = 0;
        String sentencia = "UPDATE CR_Usuarios SET NOMBRE=?,CEDULA=?,DIRECCION=?,TELEFONO1=?,TELEFONO2=?,CORREO=?,IDPERFIL=? WHERE ID=?";
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getCedula());
            ps.setString(3, usuarios.getDireccion());
            ps.setString(4, usuarios.getTelefono1());
            ps.setString(5, usuarios.getTelefono2());
            ps.setString(6, usuarios.getCorreo());
            ps.setInt(7, usuarios.getIdPerfil());
            ps.setInt(8, usuarios.getId());
            resultado = ps.executeUpdate();
        

        } catch (Exception ex) {
            throw ex;
        } finally {
                        if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;

    }
        
        
    //Eliminar un usuario
    public int Eliminar(EntidadUsuarios usuarios) throws SQLException, Exception {
        int resultado = 0;
        String sentencia = "update CR_Usuarios set estado = 0 WHERE ID=?";
        Connection _conexion = null;
        try {
            _conexion=ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, usuarios.getId());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               _mensaje = "Usuario eliminado"; 
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

    //Método para obtener un usuario
    public EntidadUsuarios ObtenerUnUsuarios(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadUsuarios usuarios = new EntidadUsuarios();
        Connection _conexion = null;
        try {
             //abrir la conexion 
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,IDPERFIL,FECHA,PASS FROM CR_Usuarios";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
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
                if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return usuarios;
    }
    
}
