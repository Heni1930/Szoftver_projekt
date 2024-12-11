package org.example;

import javax.persistence.*;

import java.util.List;

public class JPAProductDAO implements ProductDAO {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    @PersistenceContext
    static final EntityManager em = emf.createEntityManager();

    public static Product mergeProduct(Product product) {
        if (product.getId() != 0) {
            em.persist(product);
            return product;
        }
        else
            return em.merge(product);
    }

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


    public static List<Product> findProductsByFaculty(Faculties faculty) {
        try {
            String query = "SELECT p FROM Product p WHERE p.faculty = :faculty";
            TypedQuery<Product> typedQuery = em.createQuery(query, Product.class);
            typedQuery.setParameter("faculty", faculty);
            return typedQuery.getResultList();
        }
        catch (NoResultException e) {
            return null;
        }
    }
    public static Product fProductById(long id) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }
        catch(NoResultException e){
            return null;
        }
    }
}
