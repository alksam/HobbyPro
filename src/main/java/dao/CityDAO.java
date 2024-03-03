package dao;

import Config.HibernateConfig;
import dto.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CityDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public City AddCity(City city) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(city);
            em.getTransaction().commit();
            return city;
        }
    }



    public City getCityById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(City.class, id);
        }
    }

    public City updateCity(City city) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            City city1 = em.merge(city);
            em.getTransaction().commit();
            return city1;
        }
    }

    public void deleteCity(City city) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(city);
            em.getTransaction().commit();
        }
    }



}
