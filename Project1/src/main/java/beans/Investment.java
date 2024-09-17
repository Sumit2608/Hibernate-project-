package beans;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Investment_Table")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Investment_Id;
    private String name;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public long getInvestment_Id() {
        return Investment_Id;
    }

    public void setInvestment_Id(long investment_Id) {
        Investment_Id = investment_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "Investment_Id=" + Investment_Id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", user=" + user +
                '}';
    }
}
