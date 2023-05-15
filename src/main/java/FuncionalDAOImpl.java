import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
