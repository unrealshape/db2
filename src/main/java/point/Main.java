package point;

import javax.persistence.*;
import javax.persistence.criteria.From;

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
        
        
        /*
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
*/        em.getTransaction().begin();

        Vehicle vehicle = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        Person person = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        person3.setId(3L);
        person3.setName("Selin");
        person.setId(1L);
        person2.setId(2L);
        person.setName("Müller");
        person2.setName("Mustermann");

        vehicle.setId(1L);
        vehicle.setLicensePlateNumber("F-FH 8");
        vehicle2.setId(2L);

        vehicle2.setLicensePlateNumber("F-FH 4");
        vehicle2.setVehicleOwner(person2);


        vehicle.setVehicleOwner(person);
        
        em.persist(vehicle);
        em.persist(vehicle2);
        em.persist(person);
        em.persist(person2);
        em.persist(person3);




        em.getTransaction().commit();

        em.getTransaction().begin();
        String query = "SELECT h.herstellerName FROM Hersteller h";
        //SELECT p.ownedVehicle FROM Person p, Vehicle v WHERE p.name = 'Müller'
        String owner ="Mustermann";
        List resultList = em.createQuery(
                //SELECT p.name, Count(v.vehicleOwner_id) as anzahl
                //From Person p, Vehicle v
                //WHERE p.id = v.vehicleOwner_id
                //group by p.name

                "SELECT p.name, COUNT(v.vehicleOwner) FROM Person p, Vehicle v WHERE p.id = v.vehicleOwner.id GROUP BY p.name").getResultList();
         System.out.println("jetzt sql statement ausgbae");
        if (!resultList.isEmpty()) {

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