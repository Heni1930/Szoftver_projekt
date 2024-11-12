package org.example;

import org.example.model.Customer;

import java.util.List;

public interface CustomerDAO {
    public void save(Customer customer);
    public List<Customer> findAllCustomer();
    public Customer findCustomerById(int id);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
}
