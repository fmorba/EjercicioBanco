/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentadores;

import javax.swing.JOptionPane;
import repositorios.RepositorioCliente;
import servicios.ServicioCliente;
import vistas.VentanaInicio;

/**
 *
 * @author Usuario
 */
public class PresentadorCliente {
    private VentanaInicio vista;
    private ServicioCliente servicio;
    
    public PresentadorCliente(VentanaInicio vista){
        this.vista = vista;
        this.servicio = new ServicioCliente();
    }
    
    public void GuardarDatosClientes() {
        String Nombre = this.vista.getNombreTextField().getText();
        String Apellido = this.vista.getApellidoTextField().getText();
        String DNI = this.vista.getDniTextField().getText();
        String Saldo = this.vista.getSaldoInicialTextField().getText();
        
        try {
           
           servicio.GuardarDatos(Nombre, Apellido, DNI, Saldo);
            
            this.vista.getNombreTextField().setText("");
            this.vista.getApellidoTextField().setText("");
            this.vista.getDniTextField().setText("");
            this.vista.getSaldoInicialTextField().setText("");
            
            JOptionPane.showMessageDialog(null, "Datos guardados.");
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
