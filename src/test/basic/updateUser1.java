package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class updateUser1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class, 7L);
        user.setName("Leonardo");
        user.setEmail("leonardo@lanche.com.br");

        em.merge(user);

        em.getTransaction().commit();

        emf.close();
        em.close();
    }
}
