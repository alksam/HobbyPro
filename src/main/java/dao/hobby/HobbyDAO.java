package dao.hobby;

import Config.HibernateConfig;
import dao.hobby.IHobbyIMP;
import dto.Hobby;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class HobbyDAO implements IHobbyIMP {

    private static HobbyDAO hobbyDAO;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    private HobbyDAO() {
    }

    public static HobbyDAO getInstance() {
        if (hobbyDAO == null) {
            hobbyDAO = new HobbyDAO();
        }
        return hobbyDAO;
    }


    @Override
    public Hobby addHobby(Hobby hobby) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(hobby);
            em.getTransaction().commit();
            return hobby;
        }
    }


    @Override

    public Hobby getHobbyById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Hobby.class, id);
        }
    }

    @Override

    public Hobby updateHobby(Hobby hobby) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Hobby hobby1 = em.merge(hobby);
            em.getTransaction().commit();
            return hobby1;
        }
    }
    @Override
    public void deleteHobby(Hobby hobby) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(hobby);
            em.getTransaction().commit();
        }
    }
}
