/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

/**
 *
 * @author gabri
 */
public class EntidadVehiculos {
    //Atributos
    private int id; 
    private String placa; 
    private int idTipoVehiculo;
    private int idEstilo;
    private int idMarca;
    private int idTipoCombustible;
    private int idTipoTransmision;
    private Boolean estado; 
    private Boolean existe;
    
  
    //Getter y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdTipoCombustible() {
        return idTipoCombustible;
    }

    public void setIdTipoCombustible(int idTipoCombustible) {
        this.idTipoCombustible = idTipoCombustible;
    }

    public int getIdTipoTransmision() {
        return idTipoTransmision;
    }

    public void setIdTipoTransmision(int idTipoTrasmision) {
        this.idTipoTransmision = idTipoTrasmision;
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

    public EntidadVehiculos(int id, String placa, int idTipoVehiculo, int idEstilo, int idMarca, int idTipoCombustible, int idTipoTransmision, Boolean estado) {
        this.id = id;
        this.placa = placa;
        this.idTipoVehiculo = idTipoVehiculo;
        this.idEstilo = idEstilo;
        this.idMarca = idMarca;
        this.idTipoCombustible = idTipoCombustible;
        this.idTipoTransmision = idTipoTransmision;
        this.estado = estado;
    }
   
    //Constructor vacío 
    
    public EntidadVehiculos() {
        this.id = 0;
        this.placa = "";
        this.idTipoVehiculo = 0;
        this.idEstilo = 0;
        this.idMarca = 0;
        this.idTipoCombustible = 0;
        this.idTipoTransmision = 0;
        this.estado = false;
        this.existe=false;
    }
}
