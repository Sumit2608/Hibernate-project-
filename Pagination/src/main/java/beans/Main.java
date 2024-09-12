package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();
//        for(int i=1;i<=100;i++){
//            Student std =new Student();
//            std.setStd_Id(i);
//            std.setName("a"+i);
//            std.setAge(18+i%2);
//            s.save(std);
//        }
//        ts.commit();
        Query query=s.createQuery("FROM Student");
        query.setFirstResult(30);
        query.setMaxResults(10);
        List<Student> studentList=query.list();
        for(Student std:studentList){
            System.out.println(std);
        }



    }

}
