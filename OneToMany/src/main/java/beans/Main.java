package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        Question q1=new Question();
        q1.setQ_Id(111);
        q1.setQuestion("What is Python?");

        Answer a1=new Answer();
        a1.setA_Id(2212);
        a1.setAns("Python is a interactive language.");
        a1.setQuestion(q1);

        Answer a3=new Answer();
        a3.setA_Id(2243);
        a3.setAns("Python is a open source language");
        a3.setQuestion(q1);

        List<Answer> answerlist=new ArrayList<>();
        answerlist.add(a1);
        answerlist.add(a3);
        q1.setAnswerlist(answerlist);


        Question q2=new Question();
        q2.setQ_Id(112);
        q2.setQuestion("What is Java?");

        Answer a2=new Answer();
        a2.setA_Id(2233);
        a2.setAns("Java is a object oriented programming.");
        a2.setQuestion(q2);

        Answer a4=new Answer();
        a4.setA_Id(2232);
        a4.setAns("Java does not support multiple inheritance.");
        a4.setQuestion(q2);

        List<Answer> answerlist1=new ArrayList<>();
        answerlist1.add(a2);
        answerlist1.add(a4);
        q2.setAnswerlist(answerlist1);


        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();

        try {
            s.save(q1);
            s.save(a1);
            s.save(a3);
            s.save(q2);
            s.save(a2);
            s.save(a4);
            ts.commit();
        } catch (Exception e)  {
            System.out.println(e);
            ts.rollback();
        }


        Question ques=s.get(Question.class,111);
        System.out.println(ques.getQuestion());
        for(Answer a: ques.getAnswerlist()) {
            System.out.println(a.getAns());
        }


        Question ques1=s.load(Question.class,112);
        System.out.println(ques1.getQuestion());
        for(Answer b:ques1.getAnswerlist()) {
            System.out.println(b.getAns());
        }

    }
}
