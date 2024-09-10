package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee emp=new Employee();
        emp.setEmpId(123);
        emp.setEmpName("Kashish");
        emp.setSalary(15000);

        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();

        try {
            s.save(emp);
            ts.commit();
        } catch (Exception e)  {
            System.out.println(e);
            ts.rollback();
        }
        Employee e=s.get(Employee.class,123);
        System.out.println(e.toString());

    }

}

