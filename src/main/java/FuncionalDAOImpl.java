import javax.persistence.EntityManager;

public class FuncionalDAOImpl implements FuncionalDAO{
    @Override
    public void createFuncional(Functional functional) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.persist(functional);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
