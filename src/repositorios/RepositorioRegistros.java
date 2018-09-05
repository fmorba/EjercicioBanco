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
import modelos.Registro;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Usuario
 */
public class RepositorioRegistros {
     private static SessionFactory factory; 
    
    public RepositorioRegistros(){
    }
    
    public void Guardar(Registro registro){
        Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
           
      try {
         tx = session.beginTransaction();
         session.save(registro); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
    }
    
    public ArrayList<Registro> obtenerTodos()
    {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      ArrayList<Registro> arrayADevolver = new ArrayList<>();
      
      try {
         tx = session.beginTransaction();
         List registrosList = session.createQuery("FROM Registro").list();
         for (Iterator iterator = registrosList.iterator(); iterator.hasNext();){
            Registro registro = (Registro) iterator.next(); 
            arrayADevolver.add(registro);
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
    
    public ArrayList<Registro> obtenerRegistrosPorCliente(int id)
    {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      ArrayList<Registro> arrayADevolver = new ArrayList<>();
      
      try {
         tx = session.beginTransaction();
         List registrosList = session.createQuery("FROM Registro WHERE idRegistro="+id).list();
         for (Iterator iterator = registrosList.iterator(); iterator.hasNext();){
            Registro registro = (Registro) iterator.next(); 
            arrayADevolver.add(registro);
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
}
