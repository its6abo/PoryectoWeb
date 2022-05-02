/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadVehiculos;
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
public class DAVehiculos {
    
    //Atributos
    private Connection _cnn;

    //GET
    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }
    
    //Constructor Inicializar
    public DAVehiculos() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url); //Clase de tipo interfaz
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Insertar un vehiculo
    public int Insertar(EntidadVehiculos vehiculos) throws SQLException {
        int id = -1;
        String sentencia = "INSERT INTO CR_Vehiculo(PLACA,IDTIPOVEHICULO,IDESTILO,IDMARCA,IDTIPOCOMBUSTIBLE,IDTIPOTRANSMISION) VALUES(?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vehiculos.getPlaca());
            ps.setInt(2, vehiculos.getIdTipoVehiculo());
            ps.setInt(3, vehiculos.getIdEstilo());
            ps.setInt(4,vehiculos.getIdMarca());
            ps.setInt(5, vehiculos.getIdTipoCombustible());
            ps.setInt(6, vehiculos.getIdTipoTransmision());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
                mensaje = "Vehículo ingresado satisfactoriamente";
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return id;
    }
    
     //Modificar un vehiculo
        public int Modificar(EntidadVehiculos vehiculos) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE CR_Vehiculo SET PLACA=?,IDTIPOVEHICULO=?,IDESTILO=?,IDMARCA=?,IDTIPOCOMBUSTIBLE=?,IDTIPOTRANSMISION=?,ESTADO=? WHERE ID=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
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
               mensaje = "Vehiculo modificado!"; 
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
        
        
    //Eliminar un vehiculos
    public int Eliminar(EntidadVehiculos vehiculos) throws SQLException {
        int resultado = 0;
        String sentencia = "DELETE FROM CR_Vehiculo WHERE id=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setInt(1, vehiculos.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Vehiculo eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
    
     //Listar Registros en un ResultSet
    public ResultSet ListarVehiculos(String condicion, String orden) throws SQLException{
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID=?,PLACA=?,IDTIPOVEHICULO=?,IDESTILO=?,IDMARCA=?,IDTIPOCOMBUSTIBLE=?,IDTIPOTRANSMISION=?,ESTADO=? FROM CR_Vehiculo";
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
    public List<EntidadVehiculos> ListarVehiculos(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadVehiculos> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,PLACA,IDTIPOVEHICULO,IDESTILO,IDMARCA,IDTIPOCOMBUSTIBLE,IDTIPOTRANSMISION,ESTADO FROM CR_Vehiculo";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
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
            _cnn = null;
        }     
        return lista;
    }
    
    //Método para obtener un vehiculo
    public EntidadVehiculos ObtenerUnVehiculo(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadVehiculos vehiculo = new EntidadVehiculos();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT ID,PLACA,IDTIPOVEHICULO,IDESTILO,IDMARCA,IDTIPOCOMBUSTIBLE,IDTIPOTRANSMISION,ESTADO FROM CR_Vehiculo";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
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
            _cnn = null;
        }
        return vehiculo;
    }
    

    
}//Fin
