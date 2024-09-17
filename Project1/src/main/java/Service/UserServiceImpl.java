package Service;

import DAO.UserDAO;
import ExceptionHandling.ResourceNotFoundException;
import beans.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // In real applications, ensure passwords are hashed
        userDAO.save(user);
    }

    @Override
    public User getUserById(Long User_id) {
        return userDAO.findById(User_id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public void updateUser(Long User_id, String username, String password) {
        User user = userDAO.findById(User_id);
        if (user != null) {
            user.setUsername(username);
            user.setPassword(password); // Ensure hashing if dealing with passwords
            userDAO.update(user);
        } else {
            throw new ResourceNotFoundException("User not found with ID: " + User_id);
        }
    }

    @Override
    public void deleteUser(Long User_id) {
        userDAO.delete(User_id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
}
