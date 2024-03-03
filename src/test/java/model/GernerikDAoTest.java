package model;

import Config.HibernateConfig;
import dat.PersonInfo;
import dto.Person;
import dto.Phone;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GernerikDAoTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static GernerikDAo gernerikDAo;

    @BeforeAll
    public void setUp() {
        entityManagerFactory = HibernateConfig.getEntityManagerFactoryConfig();
        entityManager = entityManagerFactory.createEntityManager();
           gernerikDAo = new GernerikDAo( entityManagerFactory);
    }

    @AfterAll
    public void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }


    @Test
    void getInstance() {
    }

    @Test
    void fetchAll() {
        GernerikDAo dao = GernerikDAo.getInstance(entityManagerFactory);
        PersonInfo personInfo = new PersonInfo("John", "Doe", 30, "Fishing", "123 Main St", 2, "1234567890");
        personInfo.setFirstName("John");
        personInfo.setLastName("Doe");
        personInfo.setAge(30);
        personInfo.setHobbyName("Fishing");
        personInfo.setStreet("123 Main St");
        personInfo.setPhoneNumber("1234567890");
        List<Person> persons = dao.fetchAll(1, personInfo);
        assertNotNull(persons);
        assertFalse(persons.isEmpty());

    }

    @Test
    void fetchAllPersonsWithHobby() {
        GernerikDAo dao = GernerikDAo.getInstance(entityManagerFactory);
        List<Person> persons = dao.fetchAllPersonsWithHobby(1);
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
    }

    @Test
    void getPhoneNumbersfromperson() {
        GernerikDAo dao = GernerikDAo.getInstance(entityManagerFactory);
        Person person = new Person();
        person.setId(1);
        List<Phone> phones = dao.getAllPhoneNumbersFromPerson(person);
        assertNotNull(phones);
        assertFalse(phones.isEmpty());




    }

    @Test
    void getpersonwithgivenhobby() {
    }

    @Test
    void getcountofpersonwithhobby() {
    }

    @Test
    void getallhobbies() {
    }

    @Test
    void getallpersonsinacity() {
    }

    @Test
    void totalNumberOfPersonWithHobby() {
    }

    @Test
    void getUsersFromCity() {
    }
}