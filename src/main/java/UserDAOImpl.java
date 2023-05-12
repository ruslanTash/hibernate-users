import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        String sql = "SELECT e FROM User e";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        List<User> users = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
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
    public List<User> getUserByFunc(Functional functional) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        String sql = "SELECT e FROM User e";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        List<User> users = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    @Override
    public void deleteUserById(int userId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.remove(entityManager.find(User.class, userId));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void createUser(User user) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateUser(User user, int userId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        user.setUserId(userId);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
