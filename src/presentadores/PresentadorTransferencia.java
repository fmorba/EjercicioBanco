/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentadores;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Transferencia;
import servicios.ServicioTransferencia;
import vistas.VentanaInicio;

/**
 *
 * @author Usuario
 */
public class PresentadorTransferencia {
    private VentanaInicio vista;
    private ServicioTransferencia servicio;
    
    public PresentadorTransferencia(VentanaInicio vista){
        this.vista = vista;
        this.servicio = new ServicioTransferencia();
    }
    
    public void GuardarDatosTransferencia() {
        String Monto = this.vista.getMontoTextField().getText();
        String IDOrigen = this.vista.getOrigenTextField().getText();
        String IDDestino = this.vista.getDestinoTextField().getText();
        
        try {
            
            servicio.GuardarDatos(Monto, IDOrigen, IDDestino);
            
            this.vista.getNombreTextField().setText("");
            this.vista.getApellidoTextField().setText("");
            this.vista.getDniTextField().setText("");
            this.vista.getSaldoInicialTextField().setText("");
            
            JOptionPane.showMessageDialog(null, "Datos guardados.");
            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
