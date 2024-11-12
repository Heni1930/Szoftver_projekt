package org.example;

import org.example.model.Customer;
import org.example.model.Faculties;

public class CustomerUtils {
    private CustomerDAO cDAO;
    public CustomerUtils(CustomerDAO cDAO) {
        this.cDAO = cDAO;
    }

    public void runUtils()
    {
        Customer teszt = new Customer("Béci","12","TesztBéla","Béla@teszt.hu", Faculties.LAW);
        cDAO.save(teszt);
    }
}
