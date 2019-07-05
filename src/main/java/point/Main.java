package point;

import javax.persistence.*;
import java.util.*;


public class Main {
    private EntityManagerFactory emf;
    private EntityManager em;

    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jpa-example");
        EntityManager em = emf.createEntityManager();
        Hersteller hersteller = new Hersteller();
        hersteller.setId(1);
        hersteller.setName("x");
        em.getTransaction().begin();
        em.persist(hersteller);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}