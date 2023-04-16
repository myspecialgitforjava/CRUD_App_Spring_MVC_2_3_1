package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    void addUser(User user);
    User getUserById(long id);
    void updateUser(long id, User userToBeUpdated);
    void deleteUser(long id);

}
