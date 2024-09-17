package Service;

import beans.Transaction1;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void createTransaction(BigDecimal amount, Long investmentId);
    Transaction1 getTransactionById(Long Transaction_id);
    void updateTransaction(Long Transaction_id, BigDecimal amount);
    void deleteTransaction(Long Transaction_id);
    List<Transaction1> getAllTransactions();
}
