/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.util.ArrayList;
import modelos.Cliente;

/**
 *
 * @author Usuario
 */
public class RepositorioCliente {

    private static ArrayList<Cliente> listaClientes;

    public RepositorioCliente() {
        this.listaClientes = new ArrayList<Cliente>();
    }

    public void Guardar(Cliente cliente) {
        this.listaClientes.add(cliente);
    }

    public Cliente[] obtenerTodos() {
        Cliente[] arrayADevolver = new Cliente[this.listaClientes.size()];

        return this.listaClientes.toArray(arrayADevolver);
    }

    public Cliente BuscarPorId(int id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void ActualizarSaldoCliente(float monto, int id, boolean identificador) {
        for (int i = 0; i < listaClientes.size(); i++) {
            
            if (listaClientes.get(i).getId() == id) {
                Cliente clienteActualizable = listaClientes.get(i);
                float saldo;
                
                //identificador = true -> recibe saldo, false->trasnfiere saldo.
                if (identificador) {                    
                    saldo = clienteActualizable.getSaldoActual()+monto;
                    clienteActualizable.setSaldoActual(saldo);
                    listaClientes.set(i, clienteActualizable);
                }else{
                    saldo = clienteActualizable.getSaldoActual()-monto;
                    if (saldo<0) {
                        throw new NullPointerException ("No cuenta con el saldo disponible para realizar esta operación.");
                    }
                    clienteActualizable.setSaldoActual(saldo);
                    listaClientes.set(i, clienteActualizable);                
                }
                
                
            }

        }
    }

}
