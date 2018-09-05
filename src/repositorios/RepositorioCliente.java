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
import modelos.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Usuario
 */
public class RepositorioCliente {

    private static SessionFactory factory;

    public RepositorioCliente() {
    }

    public void Guardar(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ArrayList<Cliente> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Cliente> arrayADevolver = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List clientesList = session.createQuery("FROM  Cliente").list();
            for (Iterator iterator = clientesList.iterator(); iterator.hasNext();) {
                Cliente cliente = (Cliente) iterator.next();
                arrayADevolver.add(cliente);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return arrayADevolver;
    }

    public Cliente BuscarPorId(int id) {
        ArrayList<Cliente> listaClientes = obtenerTodos();

        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void ActualizarSaldoCliente(float monto, int id, boolean identificador) {
        Cliente cliente = BuscarPorId(id);

        float saldo;

        //identificador = true -> recibe saldo, false->trasnfiere saldo.
        if (identificador) {
            saldo = cliente.getSaldoActual() + monto;
            cliente.setSaldoActual(saldo);
        } else {
            saldo = cliente.getSaldoActual() - monto;
            if (saldo < 0) {
                throw new NullPointerException("No cuenta con el saldo disponible para realizar esta operación.");
            }
            cliente.setSaldoActual(saldo);
        }

    }

}
