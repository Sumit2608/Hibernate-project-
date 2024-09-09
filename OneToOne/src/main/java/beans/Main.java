package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Question q1=new Question();
        q1.setQ_Id(101);
        q1.setQuestion("What is Python?");
        Answer a1=new Answer();
        a1.setA_Id(1102);
        a1.setAns("Python is a interactive language.");
        q1.setAnswer(a1);


        Question q2=new Question();
        q2.setQ_Id(102);
        q2.setQuestion("What is Java?");
        Answer a2=new Answer();
        a2.setA_Id(1103);
        a2.setAns("Java is a object oriented programming.");
        q2.setAnswer(a2);


        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();
        s.save(q1);
        s.save(q2);
        s.save(a1);
        s.save(a2);
        ts.commit();

        Question ques=s.get(Question.class,101);
        System.out.println(ques.getQuestion());
        System.out.println(ques.getAnswer().getAns());

        Question ques1=s.load(Question.class,102);
        System.out.println(ques1.getQuestion());
        System.out.println(ques1.getAnswer().getAns());
    }
}
