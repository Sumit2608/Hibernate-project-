package Service;

import beans.User;

import java.util.List;

public interface UserService {
    void createUser(String username, String password);
    User getUserById(Long User_id);
    User getUserByUsername(String username);
    void updateUser(Long User_id, String username, String password);
    void deleteUser(Long User_id);
    List<User> getAllUsers();
}
