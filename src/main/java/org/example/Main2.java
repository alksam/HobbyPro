package org.example;

import Config.HibernateConfig;
import dao.person.PersonDAO;
import dto.Hobby;
import dto.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NamedQueries;

import java.time.LocalDate;

public class Main2 {


    public static void main(String[] args) {
        PersonDAO personDAO = PersonDAO.getInstance();

        Person person = new Person("sørensen", "sørenvej 1", 19, LocalDate.of(1995, 4, 23));
        personDAO.addPerson(person);

        EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactoryConfig();
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.createNamedQuery("Person.findAll", Person.class)
                .getResultList()
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------");

        entityManager.createNamedQuery("Hobby.getAll", Hobby.class)
                .getResultList()
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------");
        entityManager.createNamedQuery("Person.findByhobby", Person.class)
                .getResultList()
                .forEach(System.out::println);

    }
}
