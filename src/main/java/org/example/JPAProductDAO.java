package org.example;

import jakarta.persistence.*;
import org.example.model.Product;

import java.util.List;

public class JPAProductDAO implements ProductDAO {
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ProjektDB");
    final EntityManager em = emf.createEntityManager();

    @Override
    public void save(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    @Override
    public List<Product> findAllProducts() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    @Override
    public Product findProductById(int id) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }
        catch(NoResultException e){
            return null;
        }
    }

    @Override
    public void update(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Product product) {
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
    }
}
