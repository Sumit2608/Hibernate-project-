package Service;

import beans.Investment;

import java.math.BigDecimal;
import java.util.List;

public interface InvestmentService {
    void createInvestment(String name, BigDecimal amount, Long userId);
    Investment getInvestmentById(Long Investment_Id);
    void updateInvestment(Long Investment_Id, String name, BigDecimal amount);
    void deleteInvestment(Long Investment_Id);
    List<Investment> getAllInvestments();
}
