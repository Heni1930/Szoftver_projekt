package org.example;


import javax.persistence.*;
import java.sql.Connection;


public class CustomerUtils {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    private static CustomerDAO cDAO;
    {
        cDAO = new JPACustomerDAO();
    }

    public CustomerUtils(CustomerDAO cDAO) {
        this.cDAO = cDAO;
    }

    public static void saveCustomer(Customer customer) {
        if (customer != null) {
            cDAO.save(customer);
        }
    }
}
