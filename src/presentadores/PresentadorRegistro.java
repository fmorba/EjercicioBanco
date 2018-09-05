/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentadores;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Registro;
import modelos.Transferencia;
import repositorios.RepositorioRegistros;
import servicios.ServicioTransferencia;
import vistas.VentanaInicio;

/**
 *
 * @author Usuario
 */
public class PresentadorRegistro {
    private VentanaInicio vista;
    private RepositorioRegistros registros;
    
    public PresentadorRegistro(VentanaInicio vista){
        this.vista = vista;
        this.registros = new RepositorioRegistros();
    }
    
    
    public ArrayList<Registro> BuscarRegistrosPorCliente(){
        String IdCliente = this.vista.getClienteInformeTextField().getText();
        ArrayList<Registro> lista = new ArrayList<>();
        
        try {
            int id = Integer.valueOf(IdCliente);
            lista=registros.obtenerRegistrosPorCliente(id);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No ingreso un id correcto.");
        }
        
        return lista;
    }
}
