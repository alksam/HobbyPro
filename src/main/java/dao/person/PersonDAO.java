package dao.person;

import Config.HibernateConfig;
import dao.person.PersonIMP;
import dat.PersonInfo;
import dto.Hobby;
import dto.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class PersonDAO implements PersonIMP {
    private static PersonDAO personDAO;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    private PersonDAO() {
    }

    public static PersonDAO getInstance() {
        if (personDAO == null) {
            personDAO = new PersonDAO();
        }
        return personDAO;
    }

    @Override

    public Person addPerson(Person person) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            return person;
        }
    }

    @Override
    public Person getPersonById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Person.class, id);
        }
    }
    @Override
    public Person updatePerson(Person person) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Person person1 = em.merge(person);
            em.getTransaction().commit();
            return person1;
        }
    }

    @Override
    public void deletePerson(Person person) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<PersonInfo> fetchAll(int id) {
        return null;
    }

    @Override
    public void addPersonToHobby(Person person, Hobby hobby) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Person person1 = em.find(Person.class, person.getId());
            person1.addHobby(hobby);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
