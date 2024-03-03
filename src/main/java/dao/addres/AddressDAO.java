package dao.addres;

import Config.HibernateConfig;
import dat.ZipInfo;
import dto.Address;
import dto.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AddressDAO implements AddressIMP {
    private  static AddressDAO addredao ;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public AddressDAO() {
    }

    public static AddressDAO getInstance() {
        if (addredao == null) {
            addredao = new AddressDAO();
        }
        return addredao;
    }


@Override
    public Address addAddress(Address address) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
            return address;
        }
    }

    @Override
    public void addAddressToPerson(Address address, int PersonId) {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Person addressToUpdate = em.find(Person.class, PersonId);
            address.addPerson(addressToUpdate);
            em.getTransaction().commit();
            em.close();
        }


    @Override
    public Address getAddressById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Address.class, id);
        }
    }

    @Override
    public Address updateAddress(Address address) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Address address1 = em.merge(address);
            em.getTransaction().commit();
            return address1;
        }
    }

    @Override
    public void deleteAddress(Address address) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(address);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<ZipInfo> getAllPostcodesAndCities() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<ZipInfo> query = em.createQuery("SELECT z FROM Address z where z.city.zip = : zip ", ZipInfo.class);
            return query.getResultList();
        }
    }

}
