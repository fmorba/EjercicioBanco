/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.util.ArrayList;
import modelos.Transferencia;


/**
 *
 * @author Usuario
 */
public class RepositorioTransferencias {
    private static ArrayList<Transferencia> listaTransferencia;
    
    public RepositorioTransferencias(){
        this.listaTransferencia=new ArrayList<Transferencia>();
    }
    
    public void Guardar(Transferencia transferencia){
        this.listaTransferencia.add(transferencia);
    }
    
    public Transferencia[] obtenerTodos()
    {
        Transferencia[] arrayADevolver = new Transferencia[this.listaTransferencia.size()];
        
        return this.listaTransferencia.toArray(arrayADevolver);
    }
    
    
}
