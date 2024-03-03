package dao.Phone;

import Config.HibernateConfig;
import dao.Phone.IPhoneIMP;
import dto.Phone;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PhoneDAO implements IPhoneIMP {

    private static  PhoneDAO phoneDAO;

   private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    private PhoneDAO() {

    }

    public static PhoneDAO getInstance() {
        if (phoneDAO == null) {
            phoneDAO = new PhoneDAO();
        }
        return phoneDAO;
    }

@Override
    public Phone addPhone(Phone phone) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(phone);
            em.getTransaction().commit();
        }
        return phone;
    }
    @Override
    public Phone getPhoneById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Phone.class, id);
        }

    }
    @Override
    public Phone updatePhone(Phone phone) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Phone phone1 = em.merge(phone);
            em.getTransaction().commit();
            return phone1;
        }
    }
    @Override
    public void deletePhone(Phone phone) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(phone);
            em.getTransaction().commit();
        }
    }

}