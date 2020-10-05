package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractDAO {

    private SessionFactory sessionFactory;

    protected final Session getSession(){
        Session session = null;
        try{
            session = this.sessionFactory.getCurrentSession();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (session != null)
            session = sessionFactory.openSession();

        return session;
    }

    protected final Transaction getTransaction(Session session){
        Transaction transaction = session.getTransaction();
        if (!transaction.isActive())
            transaction = session.beginTransaction();
        return transaction;
    }
}
