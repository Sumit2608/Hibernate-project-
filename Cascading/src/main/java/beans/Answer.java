package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Answer_Table")
public class Answer {
    @Id
    private int A_Id;
    private String ans;
    @ManyToOne
    Question question;

    public int getA_Id() {
        return A_Id;
    }

    public void setA_Id(int a_Id) {
        A_Id = a_Id;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
