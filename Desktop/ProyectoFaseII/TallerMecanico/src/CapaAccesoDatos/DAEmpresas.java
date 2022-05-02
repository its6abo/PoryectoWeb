/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadEmpresas;
import Config.Config;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class DAEmpresas {
    
    //Atributos
    private Connection _cnn;

    //GET
    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }
    
    //Constructor Inicializar
    public DAEmpresas() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url); //Clase de tipo interfaz
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Insertar una empresa
    public int Insertar(EntidadEmpresas empresas) throws SQLException {
        int id = -1;
        String sentencia = "INSERT INTO CR_Empresa(NOMBRECOMERCIAL,NOMBRE,CEDULA,DIRECCION,TELEFONO1,TELEFONO2,CORREO) VALUES(?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empresas.getNombreComercial());
            ps.setString(2, empresas.getNombre());
            ps.setString(3, empresas.getCedula());
            ps.setString(4, empresas.getDireccion());
            ps.setString(5, empresas.getTelefono1());
            ps.setString(6, empresas.getTelefono2());
            ps.setString(7, empresas.getCorreo());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
                mensaje = "Empresa ingresada satisfactoriamente";
            }
        } catch (Exception ex) {
              mensaje=String.valueOf(ex);
               throw ex;
             
        } finally {
            _cnn = null;
        }
        return id;
    }
    
     //Modificar una empresa 
        public int Modificar(EntidadEmpresas empresas) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE CR_Empresa SET NOMBRE=?,CEDULA=?,DIRECCION=?,TELEFONO1=?,TELEFONO2=?,CORREO=?,NOMBRECOMERCIAL=? WHERE Id=?";
              
         try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setString(1, empresas.getNombre());
            ps.setString(2, empresas.getCedula());
          //  ps.setBoolean(5, empresas.isEstado());
            ps.setString(3, empresas.getDireccion());
            ps.setString(4, empresas.getTelefono1());
            ps.setString(5, empresas.getTelefono2());
            ps.setString(6, empresas.getCorreo());
            ps.setString(7, empresas.getNombreComercial());
             ps.setInt(8, empresas.getId());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Empresa modificada!"; 
            }else if (resultado == -100) {
               mensaje = "La cedula ingresada ya existe!"; 
            }

        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        } finally {
            _cnn = null;
        }
        return resultado;

    }
        
        
    //Eliminar una empresa
    public int Eliminar(EntidadEmpresas empresas) throws SQLException {
        int resultado = 0;
        String sentencia = "update CR_Empresa set estado = 0 WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, empresas.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Empresa eliminada!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
    
     //Listar Registros en un ResultSet
    public ResultSet ListarEmpresas(String condicion, String orden) throws SQLException{
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRECOMERCIAL,NOMBRE,CEDULA,DIRECCION,TELEFONO1,TELEFONO2,CORREO FROM CR_Empresa";
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
    public List<EntidadEmpresas> ListarEmpresas(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadEmpresas> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,NOMBRECOMERCIAL FROM CR_Empresa";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadEmpresas(rs.getInt("ID"),
                                             rs.getString("NOMBRE"),
                                             rs.getString("CEDULA"),
                                             rs.getBoolean("ESTADO"),
                                             rs.getString("DIRECCION"),
                                             rs.getString("TELEFONO1"),
                                             rs.getString("TELEFONO2"),
                                             rs.getString("CORREO"),
                                             rs.getString("NOMBRECOMERCIAL")
                ));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }     
        return lista;
    }
    
    //Método para obtener una empresa
    public EntidadEmpresas ObtenerUnaEmpresa(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadEmpresas empresa = new EntidadEmpresas();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,NOMBRE,CEDULA,ESTADO,DIRECCION,TELEFONO1,TELEFONO2,CORREO,NOMBRECOMERCIAL FROM CR_Empresa";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                empresa.setId(rs.getInt(1));
                empresa.setNombre(rs.getString(2));
                empresa.setCedula(rs.getString(3));
                empresa.setEstado(rs.getBoolean(4));
                empresa.setDireccion(rs.getString(5));
                empresa.setTelefono1(rs.getString(6));
                empresa.setTelefono2(rs.getString(7));
                empresa.setCorreo(rs.getString(8));
                empresa.setNombreComercial(rs.getString(9));
                empresa.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return empresa;
    }
    
    
    
}//Fin
