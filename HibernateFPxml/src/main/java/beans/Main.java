package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration() ;
        cfg.configure("hibernate.cfg.xml") ;
        SessionFactory sf = cfg.buildSessionFactory() ;
        Session s = sf.openSession() ;
        Transaction tx = s.beginTransaction() ;

        Student std = new Student() ;
        std.setId(101);
        std.setName("Aryan");
        std.setRollno(69);
        std.setCity("New Delhi");
        std.setEmail("abc@gmail.com");
        std.setGender("Male");

        s.save(std) ;
        tx.commit();
    }
}