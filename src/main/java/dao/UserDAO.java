package dao;


import model.User;

public interface UserDAO {

    void persistUser(User user);

    User findUserById(int id);

    void updateUser(User user);

    void deleteUser(User user);

}