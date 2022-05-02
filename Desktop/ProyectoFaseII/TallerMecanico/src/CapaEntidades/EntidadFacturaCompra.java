/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gabri
 */
public class EntidadFacturaCompra {
    Calendar today = Calendar.getInstance();
    
    //Atributos
    private int id; 
    private int idEmpresa;  
    private int idUsuario; 
    private int idProveedor;   
    private float descuento;
    private float total;
    private Date fecha;
    private Boolean estado; 
    private Boolean existe=false;
     private List<EntidadDetalleFacturaCompra> listaDetalles;

    public List<EntidadDetalleFacturaCompra> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<EntidadDetalleFacturaCompra> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
    
    //Metodos Get y Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean existe) {
        this.existe = existe;
    }
    
    //Constructor 

    public EntidadFacturaCompra(int id, int idEmpresa, int idUsuario, int idProveedor, float descuento, float total, Date fecha, Boolean estado) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idUsuario = idUsuario;
        this.idProveedor = idProveedor;
        this.descuento = descuento;
        this.total = total;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    // Vacio 

    public EntidadFacturaCompra() {
        
        
        this.id = 0;
        this.idEmpresa = 0;
        this.idUsuario = 0;
        this.idProveedor = 0;
        this.descuento = 0;
        this.total = 0;
        this.fecha = (Date) today.getTime();
        this.estado = false;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}//Fin
