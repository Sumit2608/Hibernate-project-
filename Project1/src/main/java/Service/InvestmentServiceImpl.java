package Service;

import DAO.InvestmentDAO;
import DAO.UserDAO;
import ExceptionHandling.ResourceNotFoundException;
import beans.Investment;
import beans.User;

import java.math.BigDecimal;
import java.util.List;

public class InvestmentServiceImpl implements InvestmentService {
    private final InvestmentDAO investmentDAO;
    private final UserDAO userDAO;

    public InvestmentServiceImpl(InvestmentDAO investmentDAO, UserDAO userDAO) {
        this.investmentDAO = investmentDAO;
        this.userDAO = userDAO;
    }

    @Override
    public void createInvestment(String name, BigDecimal amount, Long userId) {
        User user = userDAO.findById(userId);
        if (user != null) {
            Investment investment = new Investment();
            investment.setName(name);
            investment.setAmount(amount);
            investment.setUser(user);
            investmentDAO.save(investment);
        } else {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }
    }

    @Override
    public Investment getInvestmentById(Long Investment_Id) {
        return investmentDAO.findById(Investment_Id);
    }

    @Override
    public void updateInvestment(Long Investment_Id, String name, BigDecimal amount) {
        Investment investment = investmentDAO.findById(Investment_Id);
        if (investment != null) {
            investment.setName(name);
            investment.setAmount(amount);
            investmentDAO.update(investment);
        } else {
            throw new ResourceNotFoundException("Investment not found with ID: " + Investment_Id);
        }
    }

    @Override
    public void deleteInvestment(Long Investment_Id) {
        investmentDAO.delete(Investment_Id);
    }

    @Override
    public List<Investment> getAllInvestments() {
        return investmentDAO.findAll();
    }
}
