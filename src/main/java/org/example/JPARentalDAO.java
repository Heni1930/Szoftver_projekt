package org.example;

import javax.persistence.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class JPARentalDAO implements RentalDAO {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    static final EntityManager em = emf.createEntityManager();
    public static Customer customer;

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
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public static String isRentalExist(String username) {
        try {
            customer = em.createQuery("SELECT c FROM Customer c WHERE c.username = :username", Customer.class).setParameter("username", username).getSingleResult();
            if (customer == null) {
                System.out.println("No customer found with username: " + username);
                return "not Exist";
            }
            Long rentalCount = em.createQuery("SELECT COUNT(r) FROM Rental r WHERE r.customerId = :customerId", Long.class).setParameter("customerId", customer).getSingleResult();
            return rentalCount > 0 ? "Exist" : "not Exist";
        } catch (NoResultException e) {
            System.out.println("No result found: " + e.getMessage());
            return "not Exist";
        } catch (Exception e) {
            e.printStackTrace();
            return "Problem";
        }
    }

    public static Date findDate() {
        try {
            Rental rent = em.createQuery("SELECT r FROM Rental r WHERE r.customerId = :customer", Rental.class).setParameter("customer", customer).setMaxResults(1).getSingleResult();
            System.out.println(rent);
            return rent.getReturnDate();
        } catch (NoResultException e) {
            System.out.println("No result found: " + e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String findProduct(String username) {
        try {
            Customer customer = em.createQuery("SELECT c FROM Customer c WHERE c.username = :username", Customer.class).setParameter("username", username).getSingleResult();
            Rental rental = em.createQuery("SELECT r FROM Rental r WHERE r.customerId = :customer", Rental.class).setParameter("customer", customer).setMaxResults(1).getSingleResult();
            Product product = rental.getProductId();
            return product.getName();
        } catch (NoResultException e) {
            System.out.println("No result found: " + e.getMessage());
            return "Product not found";
        } catch (Exception e) {
            e.printStackTrace();
            return "Problem fetching product";
        }
    }
    @Override
        public List<Rental> getAllRentals () {
            TypedQuery<Rental> query = em.createQuery("SELECT r FROM Rental r", Rental.class);
            List<Rental> rentals = query.getResultList();
            return rentals;
        }

        public static Customer login (String username, String password){
            try {
                TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.username = :username AND c.password = :password", Customer.class);
                query.setParameter("username", username);
                query.setParameter("password", password);
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            }
        }

        @Override
        public void updateRental (Rental rental){
            em.getTransaction().begin();
            em.persist(rental);
            em.getTransaction().commit();
        }

        @Override
        public void deleteRental (Rental rental){
            em.getTransaction().begin();
            em.remove(rental);
            em.getTransaction().commit();
        }
    }
