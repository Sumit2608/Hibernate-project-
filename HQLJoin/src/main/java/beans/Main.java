package beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
//        Question q1=new Question();
//        q1.setQ_id(111);
//        q1.setQuestion("What is Python?");
//
//        Answer a1=new Answer();
//        a1.setA_id(2212);
//        a1.setAnswer("Python is a interactive language.");
//        a1.setQuestion(q1);
//
//        Answer a3=new Answer();
//        a3.setA_id(2243);
//        a3.setAnswer("Python is a open source language");
//        a3.setQuestion(q1);
//
//        List<Answer> answerlist=new ArrayList<>();
//        answerlist.add(a1);
//        answerlist.add(a3);
//        q1.setAnswerList(answerlist);
//
//
//        Question q2=new Question();
//        q2.setQ_id(112);
//        q2.setQuestion("What is Java?");
//
//        Answer a2=new Answer();
//        a2.setA_id(2233);
//        a2.setAnswer("Java is a object oriented programming.");
//        a2.setQuestion(q2);
//
//        Answer a4=new Answer();
//        a4.setA_id(2232);
//        a4.setAnswer("Java does not support multiple inheritance.");
//        a4.setQuestion(q2);
//
//        List<Answer> answerlist1=new ArrayList<>();
//        answerlist1.add(a2);
//        answerlist1.add(a4);
//        q2.setAnswerList(answerlist1);
//
//        Question q3=new Question();
//        q3.setQ_id(119);
//        q3.setQuestion("What is Python?");
//
//        Answer a5=new Answer();
//        a5.setA_id(2210);
//        a5.setAnswer("C++ is not a interactive language.");
//
//
//        Answer a6=new Answer();
//        a6.setA_id(2248);
//        a6.setAnswer("C++ is not a open source language");
//
//
//        List<Answer> answerlist3=new ArrayList<>();
//        answerlist3.add(a5);
//        answerlist3.add(a6);
//        q3.setAnswerList(answerlist3);



        Configuration cfg=new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s= sf.openSession();
        Transaction ts=s.beginTransaction();

//        try {
//            s.save(q1);
//            s.save(a1);
//            s.save(a3);
//            s.save(q2);
//            s.save(a2);
//            s.save(a4);
//            s.save(q3);
//            s.save(a5);
//            s.save(a6);
//            ts.commit();
//        } catch (Exception e)  {
//            System.out.println(e);
//            ts.rollback();
//        }


//        Question ques=s.get(Question.class,111);
//        System.out.println(ques.getQuestion());
//        for(Answer a: ques.getAnswerList()) {
//            System.out.println(a.getAnswer());
//        }
//
//
//        Question ques1=s.load(Question.class,112);
//        System.out.println(ques1.getQuestion());
//        for(Answer b:ques1.getAnswerList()) {
//            System.out.println(b.getAnswer());
//        }
        String q="SELECT q.question,a.answer FROM Answer AS a INNER JOIN a.question AS q";
        Query query=s.createQuery(q);
        List<Object []> list=query.list();
        for(Object [] obj:list){
            System.out.println(obj[0]+" "+obj[1]);
        }
        ts.commit();
    }
}

