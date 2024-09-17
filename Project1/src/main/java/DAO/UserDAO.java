package DAO;

import beans.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    User findById(Long User_id);
    User findByUsername(String username);
    void update(User user);
    void delete(Long User_id);
    List<User> findAll();
}
