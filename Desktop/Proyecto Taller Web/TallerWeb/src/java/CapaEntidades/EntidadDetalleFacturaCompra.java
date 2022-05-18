/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

/**
 *
 * @author gabri
 */
public class EntidadDetalleFacturaCompra {
    private int id; 
    private int idFactura; 
    private int idEmpresa; 
    private int idProducto; 
    private float cantidad; 
    private float precioCompra; 

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }
    private float total;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
 

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public EntidadDetalleFacturaCompra(int id, int idFactura, int idEmpresa, int idProducto, float cantidad, float precioCompra, float total) {
        this.id = id;
        this.idFactura = idFactura;
        this.idEmpresa = idEmpresa;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.total = total;
    }

    public EntidadDetalleFacturaCompra() {
        this.id = 0;
        this.idFactura = 0;
        this.idEmpresa = 0;
        this.idProducto = 0;
        this.cantidad = 0;
        this.precioCompra = 0;
        this.total = 0;
        this.nombre = "";
    }
    
    
    
    
}