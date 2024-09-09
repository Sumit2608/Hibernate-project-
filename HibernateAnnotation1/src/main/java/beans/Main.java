package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();

        Employee e = new Employee();
        e.setEmp_Id(101);
        e.setName("Sumit");
        e.setAge(21);
        e.setAddress("Delhi");
        e.setDateofjoining(new Date());
        e.setIs_Working(true);

        s.save(e);
        ts.commit();


    }


}
