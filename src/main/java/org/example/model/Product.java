/*
 * 1
 */

package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Product name cannot be empty!")
    @Column(nullable = false)
    private String name;
    @NotBlank(message = "Product description cannot be empty!")
    @Column(nullable = false)
    private String description;
    @NotBlank(message = "Product price cannot be empty!")
    @Column(nullable = false)
    @Min(value = 0, message = "The value must be positive!")
    private int price;
    @NotBlank(message = "Product quantity cannot be empty!")
    @Min(value = 0, message = "The value must be positive!")
    @Column(nullable = false)
    private int quantity;
    @NotBlank(message = "Faculty must be specified!")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Faculties faculty;


    public Product(int id, String name, String description, int price, int quantity, Faculties faculty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.faculty = faculty;
    }

    public Product() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }
}
