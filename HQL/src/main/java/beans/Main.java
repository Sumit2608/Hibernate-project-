package beans;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();

//        Address a=new Address();
//        a.setHouse_no(12);
//        a.setCity("Delhi");
//        Student ss=new Student();
//        ss.setId(101);
//        ss.setName("Sumit");
//        ss.setAddress(a);
//
//        Address a1=new Address();
//        a1.setHouse_no(13);
//        a1.setCity("Gurugram");
//        Student s2=new Student();
//        s2.setId(102);
//        s2.setName("Amit");
//        s2.setAddress(a1);
//
//        Address a2=new Address();
//        a2.setHouse_no(13);
//        a2.setCity("Noida");
//        Student s3=new Student();
//        s3.setId(103);
//        s3.setName("Aryan");
//        s3.setAddress(a2);
//        try{
//            s.save(ss);
//            s.save(s2);
//            s.save(s3);
//            System.out.println("Success");
//            ts.commit();
//        }
//        catch(Exception e){
//            System.out.println("Failed");
//            ts.rollback();
//
//        }
//        s.close();
//        String q="FROM Student ";
//        Query query=s.createQuery(q);
//        List<Student> studentList=query.list();
//        for(Student std:studentList){
//            System.out.println(std);
//        }
//        String q="FROM Student WHERE name='Aryan'";
//        Query query=s.createQuery(q);
//        Student student=(Student)query.uniqueResult();
//        System.out.println(student);
//        String q="FROM Student WHERE name=:x OR name=:a";
//        Query query=s.createQuery(q);
//        query.setParameter("x","Sumit");
//        query.setParameter("a","Aryan");
//        List<Student> studentList=query.list();
//        for(Student std:studentList) {
//            System.out.println(std);
//        String q="UPDATE  Student SET name=:x WHERE Id=:a";
//        Query query=s.createQuery(q);
//        query.setParameter("x","Atul");
//        query.setParameter("a",102);
//        int r=query.executeUpdate();
//        System.out.println(r);
        String q="DELETE FROM  Student WHERE Id=:a";
        Query query=s.createQuery(q);

        query.setParameter("a",102);
        int r=query.executeUpdate();
        System.out.println(r);

        ts.commit();

    }


}
