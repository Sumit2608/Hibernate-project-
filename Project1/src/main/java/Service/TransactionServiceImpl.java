package Service;

import DAO.InvestmentDAO;
import DAO.TransactionDAO;
import ExceptionHandling.ResourceNotFoundException;
import beans.Investment;
import beans.Transaction1;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final TransactionDAO transactionDAO;
    private final InvestmentDAO investmentDAO;

    public TransactionServiceImpl(TransactionDAO transactionDAO, InvestmentDAO investmentDAO) {
        this.transactionDAO = transactionDAO;
        this.investmentDAO = investmentDAO;
    }

    @Override
    public void createTransaction(BigDecimal amount, Long investmentId) {
        Investment investment = investmentDAO.findById(investmentId);
        if (investment != null) {
            Transaction1 transaction = new Transaction1();
            transaction.setAmount(amount);
            transaction.setTimestamp(LocalDateTime.now());
            transaction.setInvestment(investment);
            transactionDAO.save(transaction);
        } else {
            throw new ResourceNotFoundException("Investment not found with ID: " + investmentId);
        }
    }

    @Override
    public Transaction1 getTransactionById(Long Transaction_Id) {
        return transactionDAO.findById(Transaction_Id);
    }

    @Override
    public void updateTransaction(Long Transaction_Id, BigDecimal amount) {
        Transaction1 transaction = transactionDAO.findById(Transaction_Id);
        if (transaction != null) {
            transaction.setAmount(amount);
            transactionDAO.update(transaction);
        } else {
            throw new ResourceNotFoundException("Transaction not found with ID: " + Transaction_Id);
        }
    }

    @Override
    public void deleteTransaction(Long Transaction_Id) {
        transactionDAO.delete(Transaction_Id);
    }

    @Override
    public List<Transaction1> getAllTransactions() {
        return transactionDAO.findAll();
    }
}
