package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Answer_Table")
public class Answer {
    @Id
    private int A_Id;
    private String ans;

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
}
