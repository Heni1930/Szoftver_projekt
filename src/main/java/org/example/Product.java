/*
 * 1
 */

package org.example;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = {"rentals"})
//@EqualsAndHashCode
@Entity
//@Table
public class Product {
    @Id
    @GeneratedValue
    private long id;
    // @NotBlank(message = "Product name cannot be empty!")
    //@Column(nullable = false)
    private String name;
    //@NotBlank(message = "Product description cannot be empty!")
    //@Column(nullable = false)
    private String description;
//    @NotBlank(message = "Product price cannot be empty!")
//    @Column(nullable = false)
//    @Min(value = 0, message = "The value must be positive!")
    private int price;
//    @NotBlank(message = "Product quantity cannot be empty!")
//    @Min(value = 0, message = "The value must be positive!")
//    @Column(nullable = false)
    private int quantity;
//    @NotBlank(message = "Faculty must be specified!")
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
    private Faculties faculty;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Rental> rentals;


}
