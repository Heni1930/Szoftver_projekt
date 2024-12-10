package org.example;

import javax.persistence.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class JPARentalDAO implements RentalDAO {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    static final EntityManager em = emf.createEntityManager();

    @Override
    public void save(Rental rental) {
        em.getTransaction().begin();
        em.persist(rental);
        em.getTransaction().commit();
    }

    @Override
    public Rental getRentalById(int id) {
        TypedQuery<Rental> query = em.createQuery("SELECT r FROM Rental r WHERE r.id=:id", Rental.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }
        catch(NoResultException e){
            return null;
        }
    }

    public static List<String> findProductNamesByUsername(String username) {
        try {
            TypedQuery<Integer> customerQuery = em.createQuery("SELECT c.id FROM Customer c WHERE c.username = :username", Integer.class);
            customerQuery.setParameter("username", username);
            Integer customerId = customerQuery.getSingleResult();
            if (customerId == null) {
                return Collections.emptyList();
            }
            TypedQuery<Integer> rentalQuery = em.createQuery("SELECT r.productId FROM Rental r WHERE r.customerId = :customerId", Integer.class);
            rentalQuery.setParameter("customerId", customerId);
            List<Integer> productIds = rentalQuery.getResultList();
            if (productIds.isEmpty()) {
                return Collections.emptyList();
            }
            TypedQuery<String> productQuery = em.createQuery("SELECT p.name FROM Product p WHERE p.id IN :productIds", String.class);
            productQuery.setParameter("productIds", productIds);
            return productQuery.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }


    }

   /* public static Date findProductDatesByUsername(String username) {
        try {
            TypedQuery<Integer> customerQuery = em.createQuery("SELECT c.id FROM Customer c WHERE c.username = :username", Integer.class);
            customerQuery.setParameter("username", username);
            Integer customerId = customerQuery.getSingleResult();
            if (customerId == null) {
                return .getSingleResult();
            }
            TypedQuery<Date> rentalQuery = em.createQuery("SELECT r.rentalDate FROM Rental r WHERE r.customerId = :customerId", Date.class);
            rentalQuery.setParameter("customerId", customerId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }*/


    @Override
    public List<Rental> getAllRentals() {
        TypedQuery<Rental> query = em.createQuery("SELECT r FROM Rental r", Rental.class);
        List<Rental> rentals = query.getResultList();
        return rentals;
    }

    public static int isRentalExist(String username) {
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

    @Override
    public void updateRental(Rental rental) {
        em.getTransaction().begin();
        em.persist(rental);
        em.getTransaction().commit();
    }

    @Override
    public void deleteRental(Rental rental) {
        em.getTransaction().begin();
        em.remove(rental);
        em.getTransaction().commit();
    }
}
