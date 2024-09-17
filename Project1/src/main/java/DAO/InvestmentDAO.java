package DAO;

import beans.Investment;

import java.util.List;

public interface InvestmentDAO {
    void save(Investment investment);
    Investment findById(Long Investment_Id);
    void update(Investment investment);
    void delete(Long Investment_Id);
    List<Investment> findAll();
}
