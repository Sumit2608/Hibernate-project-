package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name="Question_Table")
public class Question {
    @Id
    int Q_id;
    String question;
    @OneToMany(mappedBy = "question")
    List<Answer> answerList;

    public int getQ_id() {
        return Q_id;
    }

    public void setQ_id(int q_id) {
        Q_id = q_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Q_id=" + Q_id +
                ", question='" + question + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
