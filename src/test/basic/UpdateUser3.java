package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class UpdateUser3 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class, 7L);
        em.detach(user);
        user.setName("Leonardo");

        em.merge(user);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
