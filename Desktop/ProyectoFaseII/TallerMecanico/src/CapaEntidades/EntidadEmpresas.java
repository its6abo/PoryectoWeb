/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

/**
 *
 * @author gabri
 */
public class EntidadEmpresas extends Informaciones {
        private String nombreComercial; 
    
    //getter/setter

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
        
         
    //constructor
    public EntidadEmpresas(int id, String nombre, String cedula, boolean estado, String direccion, String telefono1, String telefono2, String correo, String nombreComercial) {
        super(id, nombre, cedula, estado, direccion, telefono1, telefono2, correo);
    this.nombreComercial = nombreComercial;
    }
    
    //constructor vacio
    public EntidadEmpresas() {
        super(0, "", "", false, "", "", "", "",false);
        this.nombreComercial="";
        
    }

    public EntidadEmpresas(String nombreComercial, int id, String nombre, String cedula, boolean estado, String direccion, String telefono1, String telefono2, String correo) {
        super(id, nombre, cedula, estado, direccion, telefono1, telefono2, correo);
        this.nombreComercial = nombreComercial;
    }
    
    
    
    
}
