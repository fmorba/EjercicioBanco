/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.util.ArrayList;
import modelos.Registro;

/**
 *
 * @author Usuario
 */
public class RepositorioRegistros {
     private static ArrayList<Registro> listaRegistros;
    
    public RepositorioRegistros(){
        this.listaRegistros=new ArrayList<Registro>();
    }
    
    public void Guardar(Registro registro){
        this.listaRegistros.add(registro);
    }
    
    public Registro[] obtenerTodos()
    {
        Registro[] arrayADevolver = new Registro[this.listaRegistros.size()];
        
        return this.listaRegistros.toArray(arrayADevolver);
    }
    
    public ArrayList<Registro> obtenerRegistrosPorCliente(int id)
    {
        ArrayList<Registro> arrayADevolver = new ArrayList<Registro>();
        
        for (Registro registro : listaRegistros) {
            if (registro.getCliente().getId()==id) {
                arrayADevolver.add(registro);
            }
        }
        return arrayADevolver;
    }
}
