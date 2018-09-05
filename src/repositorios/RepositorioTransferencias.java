/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import banco.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelos.Transferencia;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author Usuario
 */
public class RepositorioTransferencias {
    private static ArrayList<Transferencia> listaTransferencia;
    private static SessionFactory factory; 
    
    public RepositorioTransferencias(){
        this.listaTransferencia=new ArrayList<Transferencia>();
    }
    
    public void Guardar(Transferencia transferencia){
        Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
           
      try {
         tx = session.beginTransaction();
         session.save(transferencia); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
    }
    
    public ArrayList<Transferencia> obtenerTodos()
    {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      ArrayList<Transferencia> arrayADevolver = new ArrayList<>();
      
      try {
         tx = session.beginTransaction();
         List transferenciasList = session.createQuery("FROM Transferencia").list();
         for (Iterator iterator = transferenciasList.iterator(); iterator.hasNext();){
            Transferencia transferencia = (Transferencia) iterator.next(); 
            arrayADevolver.add(transferencia);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }     
        
        return arrayADevolver;
    }
    
    public Transferencia BuscarPorId(int id) {
        ArrayList<Transferencia> lista = obtenerTodos();

        for (Transferencia transferencia : lista) {
            if (transferencia.getIdTransferencia()== id) {
                return transferencia;
            }
        }
        return null;
    }
}
