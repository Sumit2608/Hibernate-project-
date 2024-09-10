package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee emp1=new Employee();
        emp1.setEmp_Id(205);
        emp1.setEmp_Name("Ashish");

        Project p1=new Project();
        p1.setP_Id(40);
        p1.setP_Name("AI");

        Employee emp2=new Employee();
        emp2.setEmp_Id(265);
        emp2.setEmp_Name("Ash");

        Project p2=new Project();
        p2.setP_Id(50);
        p2.setP_Name("Unicorn");

        Employee emp3=new Employee();
        emp3.setEmp_Id(285);
        emp3.setEmp_Name("Aman");

        Project p3=new Project();
        p3.setP_Id(45);
        p3.setP_Name("Blackbox");

        List<Employee> elist1=new ArrayList<>();
        elist1.add(emp1);
        elist1.add(emp2);

        List<Employee> elist2=new ArrayList<>();
        elist2.add(emp3);
        elist1.add(emp2);

        List<Employee> elist3=new ArrayList<>();
        elist3.add(emp1);
        elist3.add(emp2);
        elist3.add(emp3);

        List<Project> plist1=new ArrayList<>();
        plist1.add(p1);
        plist1.add(p2);

        List<Project> plist2=new ArrayList<>();
        plist2.add(p3);
        plist2.add(p1);

        List<Project> plist3=new ArrayList<>();
        plist3.add(p1);
        plist3.add(p2);
        plist3.add(p3);

        emp1.setProject(plist1);
        p1.setEmployee(elist1);
        emp2.setProject(plist2);
        p2.setEmployee(elist2);
        emp3.setProject(plist3);
        p3.setEmployee(elist3);

        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();

        try {
            s.save(emp1);
            s.save(emp2);
            s.save(emp3);
            s.save(p1);
            s.save(p2);
            s.save(p3);
            ts.commit();
        } catch (Exception e)  {
            System.out.println(e);
            ts.rollback();
        }

        Employee emp=s.get(Employee.class,205);
        System.out.println(emp.getEmp_Name());
        for(Project p:emp.getProject()){
            System.out.println(p.getP_Name());
        }







    }
}
