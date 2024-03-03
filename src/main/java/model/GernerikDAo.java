package model;

import dat.PersonInfo;
import dat.ZipInfo;
import dto.Hobby;
import dto.Person;
import dto.Phone;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GernerikDAo implements GenerikIMD{

    private static EntityManagerFactory emf;
private static GernerikDAo gernerikDAo;

public GernerikDAo(EntityManagerFactory emf){this.emf=emf;}
public static GernerikDAo getInstance(EntityManagerFactory emf){
    if(gernerikDAo==null){
        gernerikDAo=new GernerikDAo(emf);
    }
    return gernerikDAo;
}


    @Override
    public List<Person> fetchAll (int id, PersonInfo personInfo) {

            TypedQuery<Person> query = emf.createEntityManager().createQuery
                    ("SELECT p FROM Person p WHERE" +
                            " p.firstname = :firstName " +
                            "AND p.lastname = :lastName " +
                            "and p.age = : age " +
                           "and p.hobbies = :hobbis " +
                            "and p.address.street = :stret " +
                            "and p.phones = :phones", Person.class);
            query.setParameter("firstName", personInfo.getFirstName());
            query.setParameter("lastName", personInfo.getLastName());
            query.setParameter("age", personInfo.getAge());
           query.setParameter("hobbis", personInfo.getHobbyName());
            query.setParameter("stret", personInfo.getStreet());
            query.setParameter("phones", personInfo.getPhoneNumber());

            return query.getResultList();
}

    @Override
    public List<Person> fetchAllPersonsWithHobby(int id ) {
        TypedQuery<Person> query = emf.createEntityManager().createQuery("SELECT p FROM Person p WHERE p.hobbies = :hobby", Person.class);
        query.setParameter("hobby", id);
        return query.getResultList();
    }




    @Override
    public List<Phone> getAllPhoneNumbersFromPerson(Person person) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Phone> query = em.createQuery("SELECT p FROM Phone p WHERE p.person = :person", Phone.class);
            query.setParameter("person", person);
            return query.getResultList();
        }
    }

    @Override
    public List<Person> getpersonwithgivenhobby(String hobby) {
        try (EntityManager em = emf.createEntityManager()) {
            String jpql = "SELECT u FROM Person u JOIN FETCH u.hobbies h WHERE h.hobbyName  = :hobby";

            TypedQuery<Person> query = em.createQuery(jpql, Person.class);
            query.setParameter("hobby", hobby);

            return query.getResultList();
        }
}

    @Override
    public long getcountofpersonwithhobby(String hobby) {
        Query query = emf.createEntityManager().createQuery("SELECT COUNT(p) FROM Person p WHERE p.hobbies = :hobby", Long.class);
        query.setParameter("hobby", hobby);
        return (long) query.getSingleResult();
    }

    @Override
    public List<Hobby> getallhobbies(String hobby, int count) {
        TypedQuery<Hobby> query = emf.createEntityManager().createQuery("SELECT h FROM Hobby h WHERE h.type = :hobby", Hobby.class);
        query.setParameter("hobby", hobby);
        return query.setMaxResults(count).getResultList();
    }


    @Override
    public Long getallpersonsinacity(String city) {
        Query query = emf.createEntityManager().createQuery("SELECT COUNT(p) FROM Person p WHERE p.address.city = :city", Long.class);
        query.setParameter("city", city);
        return (Long) query.getSingleResult();
    }

    @Override
    public int totalNumberOfPersonWithHobby(String hobby) {
        return 0;
    }


    public List<Person> getUsersFromCity(String city) {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Person> q = em.createQuery("SELECT u FROM Person u JOIN u.address a WHERE a.city.zip = :city", Person.class);
            q.setParameter("city", city);
            List<Person> users = q.getResultList();
            return users;
        }
    }

    public List<Person> getUsersFromZipCode(String zipCode) {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Person> q = em.createQuery("SELECT u FROM Person u JOIN u.address a WHERE a.city.zip = :zipCode", Person.class);
            q.setParameter("zipCode", zipCode);
            List<Person> users = q.getResultList();
            return users;
        }
    }


}



