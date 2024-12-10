/*
 * 1
 */

package org.example;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank(message = "Product name cannot be empty!")
    private String name;
    @NotBlank(message = "Product description cannot be empty!")
    private String description;
    @NotBlank(message = "Product price cannot be empty!")
    @Min(value = 0, message = "The value must be positive!")
    private int price;
    @NotBlank(message = "Product quantity cannot be empty!")
    @Min(value = 0, message = "The value must be positive!")
    private int quantity;
    @NotNull(message = "Faculty must be specified!")
    private Faculties faculty;

    public Product(String name, String description, int price, int quantity, Faculties faculty) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.faculty = faculty;
    }
}
