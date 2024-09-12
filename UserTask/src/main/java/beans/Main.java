package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User u1=new User();
        u1.setUserId(201);
        u1.setUserName("Sumit");

        Task t1=new Task();
        t1.setTask_id(301);
        t1.setTitle("Debugging");

        Task t2= new Task();
        t2.setTask_id(302);
        t2.setTitle("Programming");

        List<Task> taskList=new ArrayList<>();
        taskList.add(t1);
        taskList.add(t2);
        u1.setTaskList(taskList);

        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();

        try {
            s.save(u1);
            s.save(t1);
            s.save(t2);
            ts.commit();
        } catch (Exception e)  {
            System.out.println(e);
            ts.rollback();
        }




    }
}
