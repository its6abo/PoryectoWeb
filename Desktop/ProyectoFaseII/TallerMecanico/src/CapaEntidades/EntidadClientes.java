/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

/**
 *
 * @author gabri
 */
public class EntidadClientes extends Informaciones{
    
    private int idTipodoc; 
    
    //getter/setter
    public int getIdTipodoc() {
        return idTipodoc;
    }

    public void setIdTipodoc(int idTipodoc) {
        this.idTipodoc = idTipodoc;
    }
         
    //constructor
    public EntidadClientes(int id, String nombre, String cedula, boolean estado, String direccion, String telefono1, String telefono2, String correo, int idTipodoc) {
        super(id, nombre, cedula, estado, direccion, telefono1, telefono2, correo);
    this.idTipodoc = idTipodoc;
    }
    
    //constructor vacio
    public EntidadClientes() {
        super(0, "", "", false, "", "", "", "");
        this.idTipodoc=0;
    }
    
    
}
