package DAO;

import beans.Transaction1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    private final SessionFactory sessionFactory;

    public TransactionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Transaction1 transaction1) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(transaction1);
            tx.commit();
        }
    }

    @Override
    public Transaction1 findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Transaction1.class, id);
        }
    }

    @Override
    public void update(Transaction1 transaction1) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(transaction1);
            tx.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Transaction1 transaction1 = session.get(Transaction1.class, id);
            if (transaction1 != null) {
                session.delete(transaction1);
            }
            tx.commit();
        }
    }

    @Override
    public List<Transaction1> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Transaction", Transaction1.class).list();
        }
    }
}
