/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaAccesoDatos;

import CapaEntidades.EntidadDetalleFacturaCompra;
import CapaEntidades.EntidadFacturaClientes;
import CapaEntidades.EntidadFacturaCompra;
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
public class DAFacturasCompra {
    
       //Atributos
    private Connection _cnn;

    //GET
    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }
    
    //Constructor Inicializar
    public DAFacturasCompra() throws Exception{
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url); //Clase de tipo interfaz
            mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Insertar un facturaCliente
    public int Insertar(EntidadFacturaCompra factura) throws SQLException {
        int id = -1;
        String sentencia = "INSERT INTO CR_FacturasCompra(idEmpresa,idProveedor,idUsuario,descuento,total) VALUES(?,?,?,?,?) ";
            try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, factura.getIdEmpresa());
            ps.setInt(2, factura.getIdProveedor());
            ps.setInt(3, factura.getIdUsuario());
            ps.setFloat(4, factura.getDescuento());
            ps.setFloat(5, factura.getTotal());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
                
                for (EntidadDetalleFacturaCompra det : factura.getListaDetalles())
                {
                    String detSentencia = "INSERT INTO CR_DetalleFacturasCompra(idFacturaRecibida,idEmpresa,idProducto,cantidad,precioCompra,total,descuento) VALUES(?,?,?,?,?,?,?)";
                   PreparedStatement psDet = _cnn.prepareStatement(detSentencia, Statement.RETURN_GENERATED_KEYS);
                    psDet.setInt(1, id);
                    psDet.setInt(2, factura.getIdEmpresa());
                    psDet.setInt(3, det.getIdProducto());
                    psDet.setFloat(4, det.getCantidad());
                    psDet.setFloat(5, det.getPrecioCompra());
                    psDet.setFloat(6, det.getTotal());
                    psDet.setFloat(7, 0);
                    psDet.execute();               
                }
                
                
                mensaje = "Factura ingresada satisfactoriamente";
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return id;
    }
      
    //Listar Registros en un ResultSet
    public List<EntidadFacturaClientes> ListarFacturas(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadFacturaClientes> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
                    String sentencia = "SELECT f.id, f.total, f.descuento, f.fecha, c.nombre cliente, U.nombre usuario FROM CR_FacturasClientes f\n" +
                                "INNER JOIN CR_Clientes C ON C.id = f.idCliente\n" +
                                "INNER JOIN CR_Usuarios U ON U.id = f.idUsuario \n";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
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
            _cnn = null;
        }     
        return lista;
    }
    
    
}//FIN