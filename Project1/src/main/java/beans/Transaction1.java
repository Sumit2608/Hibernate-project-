package beans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Transaction_id;

    private BigDecimal amount;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "investment_id")
    private Investment investment;

    // Getters and Setters

    public Long getTransaction_id() {
        return Transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        Transaction_id = transaction_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Transaction_id=" + Transaction_id +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", investment=" + investment +
                '}';
    }
}