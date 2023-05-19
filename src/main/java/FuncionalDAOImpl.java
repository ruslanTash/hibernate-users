import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class FuncionalDAOImpl implements FuncionalDAO{
    @Override
    public void createFuncional(Functional functional) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(functional);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Functional> getAllFunctional() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        String sql = "SELECT e FROM Functional e";
        TypedQuery<Functional> query = entityManager.createQuery(sql, Functional.class);
        List<Functional> roleList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return roleList;
    }

}
