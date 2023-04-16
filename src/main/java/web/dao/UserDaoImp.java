package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsers() {
        return entityManager
                .createQuery("select user from User user", User.class)
                .getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager
                .createQuery("select user from User user where id=:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void updateUser(long id, User userToBeUpdated) {
        User userForUpdate = getUserById(id);
        userForUpdate.setName(userToBeUpdated.getName());
        userForUpdate.setLastName(userToBeUpdated.getLastName());
        userForUpdate.setAge(userToBeUpdated.getAge());
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
