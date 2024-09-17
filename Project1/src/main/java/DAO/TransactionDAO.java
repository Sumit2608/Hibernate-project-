package DAO;

import beans.Transaction1;

import java.util.List;

public interface TransactionDAO {
    void save(Transaction1 transaction1);
    Transaction1 findById(Long Transaction_id);
    void update(Transaction1 transaction1);
    void delete(Long Transaction_id);
    List<Transaction1> findAll();
}
