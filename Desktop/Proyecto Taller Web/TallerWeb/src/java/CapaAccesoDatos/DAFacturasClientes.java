/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadDetalleFacturas;
import CapaEntidades.EntidadEmpresas;
import CapaEntidades.EntidadFacturaClientes;
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
public class DAFacturasClientes {
    
    //ATRUBUTOS
    private String _mensaje;
    
    //PROPIEDADES
    public String getMensaje(){
        return _mensaje;
    }
    //CONSTRUCTORES
    public DAFacturasClientes(){
        _mensaje="";
    }
    

    
    //Insertar un facturaCliente
    public int Insertar(EntidadFacturaClientes factura) throws SQLException, Exception {
        int id = -1;
        String sentencia = "INSERT INTO CR_FacturasClientes(idEmpresa,idCliente,idUsuario,idTipoFactura,descuento,total) VALUES(?,?,?,?,?,?) ";
        Connection _conexion = null;    
        try {
            _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, factura.getIdEmpresa());
            ps.setInt(2, factura.getIdCliente());
            ps.setInt(3, factura.getIdUsuario());
            ps.setInt(4, factura.getIdTipoFactura());
            ps.setFloat(5, factura.getDescuento());
            ps.setFloat(6, factura.getTotal());
            ps.execute();   
        
  
                
            for (EntidadDetalleFacturas det : factura.getListaDetalles())
            {
                String detSentencia = "INSERT INTO CR_DetalleFacturas(idFactura,idEmpresa,idProducto,cantidad,precioVenta,descuento,total) VALUES((select isnull(max(id),0) from [dbo].[CR_FacturasClientes]),?,?,?,?,?,?)";
               PreparedStatement psDet = _conexion.prepareStatement(detSentencia, Statement.RETURN_GENERATED_KEYS);
            
                psDet.setInt(1, 1);
                psDet.setInt(2, det.getIdProducto());
                psDet.setFloat(3, det.getCantidad());
                psDet.setFloat(4, det.getPrecioVenta());
                psDet.setFloat(5, det.getDescuento());
                psDet.setFloat(6, det.getTotal());
                psDet.execute();               
            }


            _mensaje = "Factura ingresada satisfactoriamente";
            
        } catch (Exception ex) {
            throw ex;
        } finally {
                  if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return id;
    }
      
    //Listar Registros en un ResultSet
    public List<EntidadFacturaClientes> ListarFacturas(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        List<EntidadFacturaClientes> lista = new ArrayList();
        Connection _conexion = null;        
        try {
             _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();  
                    String sentencia = "SELECT f.id, f.total, f.descuento, f.fecha, c.nombre cliente, U.nombre usuario FROM CR_FacturasClientes f\n" +
                                "INNER JOIN CR_Clientes C ON C.id = f.idCliente\n" +
                                "INNER JOIN CR_Usuarios U ON U.id = f.idUsuario \n";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadFacturaClientes(rs.getInt("id"),
                                             rs.getFloat("total"),
                                             rs.getFloat("descuento"),
                                             rs.getDate("fecha"),
                                             rs.getString("cliente"),
                                             rs.getString("usuario")));
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
    
   
}//FIN
