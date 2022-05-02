/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author gabri
 */
public class EntidadProductos {
    
    Calendar today = Calendar.getInstance();
    
     //Atributos
    private int id; 
    private int idEmpresa;
    private String descripcion;
    private int precioCosto;
    private int precioVenta;
    private Date fecha;
    private Boolean estado; 
    private Boolean existe;
    
   
    
    //Getter y Setter

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(int precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
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

    
    
    
    //Constructores
    
    public EntidadProductos(int id, int idEmpresa, String descripcion, int precioCosto, int precioVenta, Date fecha, Boolean estado) {
        this.id = id;    
        this.idEmpresa = idEmpresa;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.fecha = fecha;
        this.estado = estado;
      
    }

    //Constructor vacío
    public EntidadProductos() {
        this.id = 0;    
        this.idEmpresa = 0;
        this.descripcion = "";
        this.precioCosto = 0;
        this.precioVenta = 0;
        this.fecha = (Date) today.getTime();
        this.estado = false;
        this.existe = false;
    }
   
    
}// Fin 
