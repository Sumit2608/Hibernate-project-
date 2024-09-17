import DAO.*;
import Service.*;
import Util.HibernateUtil;
import beans.Investment;
import beans.Transaction1;
import beans.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static UserService userService;
    private static InvestmentService investmentService;
    private static TransactionService transactionService;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize DAOs and Services
        UserDAO userDAO = new UserDAOImpl(HibernateUtil.getSessionFactory());
        InvestmentDAO investmentDAO = new InvestmentDAOImpl(HibernateUtil.getSessionFactory());
        TransactionDAO transactionDAO = new TransactionDAOImpl(HibernateUtil.getSessionFactory());

        userService = new UserServiceImpl(userDAO);
        investmentService = new InvestmentServiceImpl(investmentDAO, userDAO);
        transactionService = new TransactionServiceImpl(transactionDAO, investmentDAO);

        boolean running = true;
        while (running) {
            System.out.println("\nPersonal Investment Manager");
            System.out.println("1. Create User");
            System.out.println("2. Retrieve User");
            System.out.println("3. Create Investment");
            System.out.println("4. Retrieve Investment");
            System.out.println("5. Create Transaction");
            System.out.println("6. Retrieve Transactions");
            System.out.println("7. Update Investment");
            System.out.println("8. Delete Transaction");
            System.out.println("9. Exit");

            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    retrieveUser();
                    break;
                case 3:
                    createInvestment();
                    break;
                case 4:
                    retrieveInvestment();
                    break;
                case 5:
                    createTransaction();
                    break;
                case 6:
                    retrieveTransactions();
                    break;
                case 7:
                    updateInvestment();
                    break;
                case 8:
                    deleteTransaction();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Shutdown Hibernate
        HibernateUtil.shutdown();
        System.out.println("Application terminated.");
    }

    private static void createUser() {
        String username = getStringInput("Enter username: ");
        String password = getStringInput("Enter password: ");
        userService.createUser(username, password);
        System.out.println("User created successfully.");
    }

    private static void retrieveUser() {
        String username = getStringInput("Enter username: ");
        User user = userService.getUserByUsername(username);
        if (user != null) {
            System.out.println("User ID: " + user.getUser_id());
            System.out.println("Username: " + user.getUsername());
        } else {
            System.out.println("User not found.");
        }
    }

    private static void createInvestment() {
        Long userId = getLongInput("Enter user ID: ");
        String name = getStringInput("Enter investment name: ");
        BigDecimal amount = getBigDecimalInput("Enter investment amount: ");
        investmentService.createInvestment(name, amount, userId);
        System.out.println("Investment created successfully.");
    }

    private static void retrieveInvestment() {
        Long investmentId = getLongInput("Enter investment ID: ");
        Investment investment = investmentService.getInvestmentById(investmentId);
        if (investment != null) {
            System.out.println("Investment ID: " + investment.getInvestment_Id());
            System.out.println("Investment Name: " + investment.getName());
            System.out.println("Investment Amount: " + investment.getAmount());
        } else {
            System.out.println("Investment not found.");
        }
    }

    private static void createTransaction() {
        Long investmentId = getLongInput("Enter investment ID: ");
        BigDecimal amount = getBigDecimalInput("Enter transaction amount: ");
        transactionService.createTransaction(amount, investmentId);
        System.out.println("Transaction created successfully.");
    }

    private static void retrieveTransactions() {
        List<Transaction1> transactions = transactionService.getAllTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            transactions.forEach(transaction -> {
                System.out.println("Transaction ID: " + transaction.getTransaction_id());
                System.out.println("Amount: " + transaction.getAmount());
                System.out.println("Timestamp: " + transaction.getTimestamp());
                System.out.println("Investment ID: " + transaction.getInvestment().getInvestment_Id());
                System.out.println("-------------------------------");
            });
        }
    }

    private static void updateInvestment() {
        Long investmentId = getLongInput("Enter investment ID: ");
        String name = getStringInput("Enter new investment name: ");
        BigDecimal amount = getBigDecimalInput("Enter new investment amount: ");
        investmentService.updateInvestment(investmentId, name, amount);
        System.out.println("Investment updated successfully.");
    }

    private static void deleteTransaction() {
        Long transactionId = getLongInput("Enter transaction ID: ");
        transactionService.deleteTransaction(transactionId);
        System.out.println("Transaction deleted successfully.");
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    private static long getLongInput(String prompt) {
        System.out.print(prompt);
        return Long.parseLong(scanner.nextLine());
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static BigDecimal getBigDecimalInput(String prompt) {
        System.out.print(prompt);
        return new BigDecimal(scanner.nextLine());
    }
}