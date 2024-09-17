package DAO;

import beans.Investment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class InvestmentDAOImpl implements InvestmentDAO {
    private final SessionFactory sessionFactory;

    public InvestmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Investment investment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(investment);
            transaction.commit();
        }
    }

    @Override
    public Investment findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Investment.class, id);
        }
    }

    @Override
    public void update(Investment investment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(investment);
            transaction.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Investment investment = session.get(Investment.class, id);
            if (investment != null) {
                session.delete(investment);
            }
            transaction.commit();
        }
    }

    @Override
    public List<Investment> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Investment", Investment.class).list();
        }
    }
}
