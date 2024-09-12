package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
//        Employee e1= new Employee();
//        e1.setEmpId(101);
//        e1.setEmpName("Sumit");
//        e1.setSalary(15000);
//
//        Employee e2= new Employee();
//        e2.setEmpId(102);
//        e2.setEmpName("Aryan");
//        e2.setSalary(18000);
//
//        Employee e3= new Employee();
//        e3.setEmpId(103);
//        e3.setEmpName("Atul");
//        e3.setSalary(5000);
//
//        Employee e4= new Employee();
//        e4.setEmpId(104);
//        e4.setEmpName("Aniket");
//        e4.setSalary(25000);
//
//        Employee e5= new Employee();
//        e5.setEmpId(105);
//        e5.setEmpName("Kuldeep");
//        e5.setSalary(10000);
//
//        Employee e6= new Employee();
//        e6.setEmpId(106);
//        e6.setEmpName("Rigzin");
//        e6.setSalary(20000);

        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf= cfg.buildSessionFactory();
        Session s=sf.openSession();
        Transaction ts=s.beginTransaction();

//        try{
//            s.save(e1);
//            s.save(e2);
//            s.save(e3);
//            s.save(e4);
//            s.save(e5);
//            s.save(e6);
//            ts.commit();
//        }
//        catch(Exception e){
//            System.out.println(e);
//            ts.rollback();
//        }

        Query query=s.createQuery("SELECT AVG(Salary) FROM Employee");
        double avgSalary =(Double)query.uniqueResult();
        System.out.println(avgSalary);
        ts.commit();




    }
}
