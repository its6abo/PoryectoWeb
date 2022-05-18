/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaAccesoDatos.DAEmpresas;
import CapaEntidades.EntidadEmpresas;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class BLEmpresas {
        public List<EntidadEmpresas> ListarEmpresas(String condicion) throws Exception{
        List<EntidadEmpresas> empresas = new ArrayList();
        DAEmpresas daEmpresas;
        try {
            daEmpresas = new DAEmpresas();
            empresas = daEmpresas.ListarEmpresas(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return empresas;
    }
        
   
     //Atributos
    private String mensaje;
    
    //Método 
    public String getMensaje(){
        return mensaje;
    }
    
    //Llamar al método modificar de la lógica
    public int Modificar(EntidadEmpresas empresa) throws Exception{
        int resultado = -1;
        DAEmpresas daEmpresas;
        try {
           daEmpresas = new DAEmpresas();
           resultado = daEmpresas.Modificar(empresa);
           mensaje = daEmpresas.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método eliminar de la lógica
    public int Eliminar(EntidadEmpresas empresa) throws Exception{
        int resultado = -1;
        DAEmpresas daEmpresas;
        try {
           daEmpresas = new DAEmpresas();
           resultado = daEmpresas.Eliminar(empresa);
           mensaje = daEmpresas.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método insertar de la lógica
    public int Insertar(EntidadEmpresas empresas) throws Exception{
        int resultado = -1;
        DAEmpresas daEmpresas;
        try {
           daEmpresas = new DAEmpresas();
           resultado = daEmpresas.Insertar(empresas);
           mensaje = daEmpresas.getMensaje();
        } catch (Exception ex) {
                Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        }
        return resultado;
    }
    

    
    public EntidadEmpresas ObtenerUnaEmpresa(String condicion) throws Exception{
        EntidadEmpresas resultado;
        DAEmpresas daEmpresas;
        try {
            daEmpresas = new DAEmpresas();
            resultado = daEmpresas.ObtenerUnaEmpresa(condicion);
            if (resultado.getExiste()) {
                mensaje = "Empresa encontrada!";
            }
            else{
                mensaje = "Empresa NO encontrada";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
}
