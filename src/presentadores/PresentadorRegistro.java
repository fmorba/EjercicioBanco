/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Cliente;
import modelos.Registro;
import modelos.Transferencia;
import repositorios.RepositorioCliente;
import repositorios.RepositorioRegistros;
import repositorios.RepositorioTransferencias;
import servicios.ServicioTransferencia;
import vistas.VentanaInicio;

/**
 *
 * @author Usuario
 */
public class PresentadorRegistro {
    private VentanaInicio vista;
    private RepositorioRegistros registros;
    private RepositorioCliente clientes;
    private RepositorioTransferencias transferencias;
    
    public PresentadorRegistro(VentanaInicio vista){
        this.vista = vista;
        this.registros = new RepositorioRegistros();
        this.clientes = new RepositorioCliente();
        this.transferencias=new RepositorioTransferencias();
    }
    
    
    public ArrayList<Registro> BuscarRegistrosPorCliente(){
        String IdCliente = this.vista.getClienteInformeTextField().getText();
        ArrayList<Registro> lista = new ArrayList<>();
        
        try {
            int id = Integer.valueOf(IdCliente);
            lista=registros.obtenerRegistrosPorCliente(id);
            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No ingreso un id correcto.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No ingreso un id correcto.");
        }       
        
        return lista;
    }
    
    public void displayResult() {
        List resultList=this.BuscarRegistrosPorCliente();
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("ID");
        tableHeaders.add("Nombre");
        tableHeaders.add("Apellido");
        tableHeaders.add("Saldo Inicial");
        tableHeaders.add("Transferencia");
        tableHeaders.add("Cantidad");
        tableHeaders.add("Saldo Final");     

        for (Object o : resultList) {
            Registro registro = (Registro) o;
            Vector<Object> oneRow = new Vector<Object>();
            Cliente cliente = clientes.BuscarPorId(registro.getCliente().getIdCliente());
            Transferencia transferencia = transferencias.BuscarPorId(registro.getTransferencia().getIdTransferencia());
            oneRow.add(registro.getCliente().getIdCliente());
            oneRow.add(cliente.getNombre());
            oneRow.add(cliente.getApellido());
            oneRow.add(registro.getEstadoSaldoInicio());
            oneRow.add(registro.getTipo());
            oneRow.add(transferencia.getCantidad());
            oneRow.add(registro.getEstadoSaldoFinal());
            tableData.add(oneRow);
        }
        this.vista.getInformeTable().setModel(new DefaultTableModel(tableData, tableHeaders));
    }
}
