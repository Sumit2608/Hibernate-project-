package beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Question_Table")
public class Question {
    @Id
    private int Q_Id;
    private String Question;
    @OneToMany(mappedBy = "question")
    List<Answer> answerlist;


    public int getQ_Id() {
        return Q_Id;
    }

    public void setQ_Id(int q_Id) {
        Q_Id = q_Id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public List<Answer> getAnswerlist() {
        return answerlist;
    }

    public void setAnswerlist(List<Answer> answerlist) {
        this.answerlist = answerlist;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Q_Id=" + Q_Id +
                ", Question='" + Question + '\'' +
                ", answerlist=" + answerlist +
                '}';
    }
}

