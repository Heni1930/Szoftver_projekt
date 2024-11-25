package org.example;


public class CustomerUtils {
    private static CustomerDAO cDAO;
    static {
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
