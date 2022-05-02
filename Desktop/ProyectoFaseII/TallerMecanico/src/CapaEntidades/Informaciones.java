/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

/**
 *
 * @author gabri
 */

public class Informaciones {
    //Atributos
    private int id; 
    private String nombre; 
    private String cedula;
    private Boolean estado; 
    private String direccion; 
    private String telefono1; 
    private String telefono2; 
    private String correo;
    private Boolean existe=false;
    
   
    
    //Getter y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
        public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean existe) {
        this.existe = existe;
    }
    //Constructores

    public Informaciones(int id, String nombre, String cedula, boolean estado, String direccion, String telefono1, String telefono2, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = estado;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correo = correo;
       
    }
    
    //Constructor vacío 
    
    public Informaciones() {
        this.id = 0;
        this.nombre = "";
        this.cedula = "";
        this.estado = false;
        this.direccion = "";
        this.telefono1 = "";
        this.telefono2 = "";
        this.correo = "";
        this.existe=false;
    }
    
    //Constructor lleno con el existe para actualizar 

    public Informaciones(int id, String nombre, String cedula, Boolean estado, String direccion, String telefono1, String telefono2, String correo, Boolean existe) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = estado;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correo = correo;
        this.existe = existe;
    }

    public Informaciones(int id, String nombre, String cedula, String direccion, String telefono1, String telefono2, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correo = correo;
    }
    
    
    
    
} // Fin Clase
