package org.example;

import javax.persistence.*;

import java.util.List;

public class JPARentalDAO implements RentalDAO {
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager em = emf.createEntityManager();

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

    @Override
    public List<Rental> getAllRentals() {
        TypedQuery<Rental> query = em.createQuery("SELECT r FROM Rental r", Rental.class);
        List<Rental> rentals = query.getResultList();
        return rentals;
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
