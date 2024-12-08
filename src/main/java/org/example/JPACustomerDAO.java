package org.example;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;

public class JPACustomerDAO implements CustomerDAO {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    static final EntityManager em = emf.createEntityManager();

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

    public static int isEmailExist(String email) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM Customer c WHERE c.email = :email", Long.class);
        query.setParameter("email", email);
        query.setMaxResults(1);
        try {
            long count = query.getSingleResult();
            return (int) count;
        } catch (NoResultException e) {
            return 0;
        }
    }


    public static int isUsernameExist(String username) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM Customer c WHERE c.username = :username", Long.class);
        query.setParameter("username", username);
        query.setMaxResults(1);
        try {
            long count = query.getSingleResult();
            return (int) count;
        } catch (NoResultException e) {
            return 0;
        }
    }

    public static Customer login(String username, String password) {
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.username = :username AND c.password = :password", Customer.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public static Customer findCustomerByEmail(String email) {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.email=:email", Customer.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public static Customer findCustomerByUsername(String username) {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.username=:username", Customer.class);
        query.setParameter("username", username);
        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public static String getCustomerNameByUsername(String username) {
        Customer customer = findCustomerByUsername(username);
        if (customer != null) {
            return customer.getName();
        }
        return null;
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
