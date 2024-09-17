package Util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Create a Configuration instance
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(beans.User.class);
            configuration.addAnnotatedClass(beans.Investment.class);
            configuration.addAnnotatedClass(beans.Transaction1.class);


            // Create a ServiceRegistry instance from the Configuration
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            // Build the SessionFactory from the Configuration and ServiceRegistry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            // Log the exception
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
