import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        String sql = "SELECT e FROM User e";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        List<User> userList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return userList;
    }

    @Override
    public User getUserById(int userId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        User user = entityManager.find(User.class, userId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    @Override
    public List<User> getUserByFunc(int funcId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Functional funcs = entityManager.find(Functional.class, funcId);
        List<User> usersByFuncional =  funcs.getUserList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return usersByFuncional;
    }

    @Override
    public void deleteUserById(User user) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        User userForDelete = entityManager.find(User.class, user.getUserId());
        entityManager.remove(userForDelete);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void createUser(User user, List<Functional> functionalList) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        user.setFunctionalList(functionalList);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateUser(User user, int userId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        User userForUpdate = entityManager.find(User.class, userId);
        userForUpdate.setName(user.getName());
        userForUpdate.setLogin(user.getLogin());
        userForUpdate.setPassword(user.getPassword());
        userForUpdate.setModified(LocalDateTime.now());
        entityManager.merge(userForUpdate);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
