package org.example;

import org.example.model.Product;

import java.util.List;

public interface ProductDAO {
    public void save(Product product);
    public List<Product> findAllProducts();
    public Product findProductById(int id);
    public void update(Product product);
    public void delete(Product product);

}
