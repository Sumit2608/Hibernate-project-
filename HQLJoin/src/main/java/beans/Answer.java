package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="Answer_Table")
public class Answer {
    @Id
    int A_id;
    String answer;
    @ManyToOne
    Question question;

    public int getA_id() {
        return A_id;
    }

    public void setA_id(int a_id) {
        A_id = a_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "A_id=" + A_id +
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }
}
