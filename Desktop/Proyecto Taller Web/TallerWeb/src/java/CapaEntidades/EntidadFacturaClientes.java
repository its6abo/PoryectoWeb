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
public class EntidadFacturaClientes {
    Calendar today = Calendar.getInstance();
    
     //Atributos
    private int id; 
    private int idEmpresa; 
    private int idCliente; 
    private int idUsuario; 
    private int idTipoFactura; 
    private Boolean estado; 
    private Date fecha;
    private float descuento;
    private float total;
    private Boolean existe=false;
    private List<EntidadDetalleFacturas> listaDetalles;
    private String cliente;
    private String fechaInicio;
    private String fechaFin;

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
        
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    private String usuario;


    public List<EntidadDetalleFacturas> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<EntidadDetalleFacturas> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }           
  
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean existe) {
        this.existe = existe;
    }
    
    //Constructores

    public EntidadFacturaClientes(int id, int idEmpresa, int idCliente, int idUsuario, int idTipoFactura, Boolean estado, Date fecha, float descuento, float total, List<EntidadDetalleFacturas> listaDetalles ) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idTipoFactura = idTipoFactura;
        this.estado = estado;
        this.fecha = fecha;
        this.descuento = descuento;
        this.total = total;
        this.listaDetalles = listaDetalles;
    }
    
        //Constructor vacío

    public EntidadFacturaClientes() {
        
        this.id = 0;
        this.idEmpresa = 0;
        this.idCliente = 0;
        this.idUsuario = 0;
        this.idTipoFactura = 0;
        this.estado = false;
        this.fecha = (Date) today.getTime();
        this.descuento = 0;
        this.total = 0;
        this.listaDetalles = null;
    }

    //

    public EntidadFacturaClientes(int id, int idEmpresa, int idCliente, int idUsuario, int idTipoFactura, Boolean estado, Date fecha, float descuento, float total) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idTipoFactura = idTipoFactura;
        this.estado = estado;
        this.fecha = fecha;
        this.descuento = descuento;
        this.total = total;
    }
      public EntidadFacturaClientes(int id, float total, float descuento, Date fecha, String cliente, String usuario) {
        this.id = id;
        this.total = total;
        this.descuento = descuento;
        this.fecha = fecha;
        this.cliente = cliente;
        this.usuario = usuario;
    }
    
    
    
}//FIN


