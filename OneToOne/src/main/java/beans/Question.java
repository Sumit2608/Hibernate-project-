package beans;

import javax.persistence.*;

@Entity
@Table(name="Question_Table")
public class Question {
    @Id
    private int Q_Id;
    private String Question;
    @OneToOne
    @JoinColumn(name="A_Id")
    private Answer answer;


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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Q_Id=" + Q_Id +
                ", Question='" + Question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
