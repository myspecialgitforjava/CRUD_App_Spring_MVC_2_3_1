package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    void addUser(User user);
    User getUserById(long id);
    void updateUser(long id, User userToBeUpdated);
    void deleteUser(long id);

}
