package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();

        Address a=new Address();
        a.setHouse_no(12);
        a.setCity("Delhi");
        Student ss=new Student();
        ss.setId(101);
        ss.setName("Sumit");
        ss.setAddress(a);
        s.save(ss);
        ts.commit();


    }


}
