/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author gabri
 */
public class EntidadUsuarios extends Informaciones{
        Calendar today = Calendar.getInstance();
        private int idPerfil; 
        private Date fecha;
        private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    //getter/setter

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


        
         
    //constructor
    public EntidadUsuarios(int id, String nombre, String cedula, boolean estado, String direccion, String telefono1, String telefono2, String correo, int idPerfil, Date fecha) {
        super(id, nombre, cedula, estado, direccion, telefono1, telefono2, correo);
    this.idPerfil = idPerfil;
    this.fecha = fecha;
    }
    
    //constructor vacio
    public EntidadUsuarios() {
        super(0, "", "", false, "", "", "", "");
        this.idPerfil=0;
        this.fecha = (Date) today.getTime();
    }

    public EntidadUsuarios(int id, String nombre, String cedula, String direccion, String telefono1, String telefono2, String correo) {
        super(id, nombre, cedula, direccion, telefono1, telefono2, correo);
    }
    
    
    
    
}
