package org.example;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;

public class JPACustomerDAO implements CustomerDAO {
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager em = emf.createEntityManager();

    @Override
    public void save(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public List<Customer> findAllCustomer() {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public Customer findCustomerById(int id) {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.id=:id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        em.getTransaction().begin();
        em.remove(customer);
        em.getTransaction().commit();
    }


}
