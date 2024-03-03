package org.example;

import Config.HibernateConfig;
import dao.Phone.IPhoneIMP;
import dao.addres.AddressDAO;
import dao.addres.AddressIMP;
import dao.hobby.HobbyDAO;
import dao.hobby.IHobbyIMP;
import dao.person.PersonDAO;
import dao.Phone.PhoneDAO;
import dao.person.PersonIMP;
import dat.PersonInfo;
import dto.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.GenerikIMD;
import model.GernerikDAo;
import dto.Type;

import java.time.LocalDate;
import java.util.List;

public class Main {

    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

       Hobby hobby = new Hobby("3D-udskrivning","https://en.wikipedia.org/wiki/3D_printing","Generel",Type.Indendørs);
        Person person = new Person("sørensen", "sørenvej 1", 19, LocalDate.of(1995, 4, 23));
        Person person2 = new Person("ahmad", "køvjda 1", 23, LocalDate.of(1892, 3, 2));
        Phone phone = new Phone("+4512345678");
        Address address = new Address();

        GenerikIMD generikIMD = GernerikDAo.getInstance(emf);
        PersonIMP personDAO =  PersonDAO.getInstance();
        IPhoneIMP phoneDAO = PhoneDAO.getInstance();
        AddressIMP addressDAO = AddressDAO.getInstance();
        IHobbyIMP hobbyDAO = HobbyDAO.getInstance();



        phoneDAO.addPhone(phone);
        addressDAO.addAddress(address);

        person2.getHobbies().add(hobby);
        person2.getPhones().add(phone);
        person.getPhones().add(phone);
        person.setAddress(address);

        personDAO.addPerson(person);
        personDAO.addPerson(person2);


       em.getTransaction().commit();

        em.createNamedQuery("Hobby.getAll", Hobby.class)
                .getResultList()
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------");
        em.createNamedQuery("Person.findAll", Person.class)
                .getResultList()
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------");

        em.createNamedQuery("Phone.getAll", Phone.class)
                .getResultList()
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------");

        Person person3 = new Person();
        person3.setId(1);

        List<Phone> phoneNumbers = generikIMD.getAllPhoneNumbersFromPerson(person3);

        for (Phone phoneNumber : phoneNumbers) {
            System.out.println("Phone number: " + phoneNumber.getNumber());
        }


      /*
        List<Person> personList = generikIMD.fetchAllPersonsWithHobby(1);
        for (Person p : personList) {
            System.out.println(p);
        }

        // generikIMD.fetchAllPhoneNumbers("", 0);

       // generikIMD.getpersonwithgivenhobby("sørensen");
        generikIMD.fetchAllPhoneNumbers("", 0);
        generikIMD.getpersonwithgivenhobby("sørensen");
        List<PersonInfo> PersonList = generikIMD.fetchAll("j", "sørensen", 19, "ksksk", "mmm", "fodbold", "pkckkck");
        for (PersonInfo p : PersonList) {
            System.out.println(p);


            System.out.println("------------------------------------------------------");






        List<Person> personInfos = generikIMD.fetchAll(personInfo1);
        for (Person p : personInfos) {
            System.out.println(p);
        }

        */
        }

    }
