package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
       Student std=new Student();
       std.setStd_Id(102);
       std.setDateOfBirth(LocalDate.ofEpochDay(2003-10-12));
       std.setEmail("asv@gmail.com");
       std.setFirstName("Vivek");
       std.setGender("Male");
       std.setLastName("Sharma");
       std.setPhone_no(732792348);

       Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();

        try {
            s.save(std);
            ts.commit();
        } catch (Exception e)  {
            System.out.println(e);
            ts.rollback();
        }
        Student std1 = s.get(Student.class, 106);
        if (std1 != null) {
            System.out.println(std1.toString());
        } else {
            System.out.println("No student found with ID 106.");
        }
    }

}
