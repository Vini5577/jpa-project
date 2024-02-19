package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classType;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        } catch (Exception e) {
            // ...
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classType) {
        this.classType = classType;
        em = emf.createEntityManager();
    }

    public DAO<E> openT() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeT() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> add(E entity) {
        em.persist(entity);
        return this;
    }

    public DAO<E> addAtomic(E entity) {
        return this.openT().add(entity).closeT();
    }

    public E getId(Object id) {
        return em.find(classType, id);
    }

    public List<E> getAll() {
        return this.getAll(10, 0);
    }

    public List<E> getAll(int quantity, int offset) {
        if (classType == null) {
            throw new UnsupportedOperationException("Class is null.");
        }

        String jpql = "select e from " + classType.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classType);
        query.setMaxResults(quantity);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    public void close() {
        em.close();
    }
}
