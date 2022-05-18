/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadVehiculos;
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
public class DAVehiculos {
    
    //ATRUBUTOS
    private String _mensaje;
    
    //PROPIEDADES
    public String getMensaje(){
        return _mensaje;
    }
    //CONSTRUCTORES
    public DAVehiculos(){
        _mensaje="";
    }
    

        //Listar Registros en un ResultSet
    public List<EntidadVehiculos> ListarVehiculos(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        Connection _conexion = null;
        List<EntidadVehiculos> lista = new ArrayList();
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia = "SELECT ID,PLACA,IDTIPOVEHICULO,IDESTILO,IDMARCA,IDTIPOCOMBUSTIBLE,IDTIPOTRANSMISION,ESTADO FROM CR_Vehiculo WHERE estado=1";
            if (!condicion.equals("")) {
                // se le quita el where a la sentencia para que no haya conflicto a la hora de buscar. 
                sentencia = "SELECT ID,PLACA,IDTIPOVEHICULO,IDESTILO,IDMARCA,IDTIPOCOMBUSTIBLE,IDTIPOTRANSMISION,ESTADO FROM CR_Vehiculo";
                sentencia = String.format("%s WHERE estado=1 AND %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadVehiculos(rs.getInt("ID"),
                                             rs.getString("PLACA"),
                                             rs.getInt("IDTIPOVEHICULO"),
                                             rs.getInt("IDESTILO"),
                                             rs.getInt("IDMARCA"),
                                             rs.getInt("IDTIPOCOMBUSTIBLE"),
                                             rs.getInt("IDTIPOTRANSMISION"),
                                             rs.getBoolean("ESTADO")
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
    
    

    //Insertar un vehiculo
    public int Insertar(EntidadVehiculos vehiculos) throws SQLException, Exception {
        int id = -1;
        String sentencia = "INSERT INTO CR_Vehiculo(PLACA,IDTIPOVEHICULO,IDESTILO,IDMARCA,IDTIPOCOMBUSTIBLE,IDTIPOTRANSMISION) VALUES(?,?,?,?,?,?) ";
        Connection _conexion = null;
        try {
             _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();  
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, vehiculos.getPlaca());
            ps.setInt(2, vehiculos.getIdTipoVehiculo());
            ps.setInt(3, vehiculos.getIdEstilo());
            ps.setInt(4,vehiculos.getIdMarca());
            ps.setInt(5, vehiculos.getIdTipoCombustible());
            ps.setInt(6, vehiculos.getIdTipoTransmision());
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
    
     //Modificar un vehiculo
        public int Modificar(EntidadVehiculos vehiculos) throws SQLException, Exception {
         Connection _conexion = null;
        int resultado = 0;
        String sentencia = "UPDATE CR_Vehiculo SET PLACA=?,IDTIPOVEHICULO=?,IDESTILO=?,IDMARCA=?,IDTIPOCOMBUSTIBLE=?,IDTIPOTRANSMISION=?,ESTADO=? WHERE ID=?";
        try {
            _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, vehiculos.getPlaca());
            ps.setInt(2, vehiculos.getIdTipoVehiculo());
            ps.setInt(3, vehiculos.getIdEstilo());
            ps.setInt(4,vehiculos.getIdMarca());
            ps.setInt(5, vehiculos.getIdTipoCombustible());
            ps.setInt(6, vehiculos.getIdTipoTransmision());
            ps.setBoolean(7, vehiculos.getEstado());
            ps.setInt(8, vehiculos.getId());
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               _mensaje = "Vehiculo modificado!"; 
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
        
        
    //Eliminar un vehiculos
    public int Eliminar(EntidadVehiculos vehiculos) throws SQLException {
         Connection _conexion = null;
        int resultado = 0;
        String sentencia = "DELETE FROM CR_Vehiculo WHERE id=?";
        try {
            _conexion=ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, vehiculos.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               _mensaje = "Vehiculo eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        return resultado;

    }
    }
    
    
    //Método para obtener un vehiculo
    public EntidadVehiculos ObtenerUnVehiculo(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadVehiculos vehiculo = new EntidadVehiculos();
         Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia = "SELECT ID,PLACA,IDTIPOVEHICULO,IDESTILO,IDMARCA,IDTIPOCOMBUSTIBLE,IDTIPOTRANSMISION,ESTADO FROM CR_Vehiculo";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            if (rs.next()) {
                vehiculo.setId(rs.getInt(1));
                vehiculo.setPlaca(rs.getString(2));
                vehiculo.setIdTipoVehiculo(rs.getInt(3));
                vehiculo.setIdEstilo(rs.getInt(4));
                vehiculo.setIdMarca(rs.getInt(5));
                vehiculo.setIdTipoCombustible(rs.getInt(6));
                vehiculo.setIdTipoTransmision(rs.getInt(7));
                vehiculo.setEstado(rs.getBoolean(8));
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
                if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return vehiculo;
    }
    
}//Fin
