package point;

import javax.persistence.*;
import java.math.BigDecimal;
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
        hersteller.setId(1L);
        hersteller.setHerstellerName("Siemens");
        Produkt produkt = new Produkt();
        produkt.setId(2L);
        produkt.setProduktName("Staubsauger");
        produkt.setHersteller(hersteller);


        Konto konto100 = new Konto();
        Konto konto200 = new Konto();
        Konto konto300 = new Konto();
        Kunde kunde1 = new Kunde();
        Kunde kunde2 = new Kunde();
        Kunde kunde3 = new Kunde();


        kunde1.setId(1L);
        kunde1.setVorname("dieter");
        kunde1.setNachname("müller");


        kunde2.setId(2L);
        kunde2.setVorname("Richard");
        kunde2.setNachname("Wagner");


        kunde3.setId(3L);
        kunde3.setVorname("Franz");
        kunde3.setNachname("Ulrich");

        konto100.setKontonummer(1121L);
        konto200.setKontonummer(2121L);
        konto300.setKontonummer(3121L);

        konto100.setKontostand(new BigDecimal(1587.23));
        konto200.setKontostand(new BigDecimal(2587.23));
        konto300.setKontostand(new BigDecimal(0.23));


        kunde1.getKonten().add(konto100);
        kunde2.getKonten().add(konto200);
        kunde3.getKonten().add(konto300);

        em.getTransaction().begin();

        em.persist(hersteller);
        em.persist(produkt);
        em.persist(kunde1);
        em.persist(kunde2);
        em.persist(kunde3);
        em.persist(konto100);
        em.persist(konto200);
        em.persist(konto300);


        em.getTransaction().commit();

        em.getTransaction().begin();
        List resultList = em.createQuery("SELECT h.herstellerName FROM Hersteller h").getResultList();

        if (!resultList.isEmpty()) {
            System.out.println("ID" + "\t" + "HerstellerName");

            for(int i = 0;i<resultList.size();i++)
            {
                System.out.println(resultList.toString());
            }
        } else {
            System.out.println("Kein Hersteller gefunden!");
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}