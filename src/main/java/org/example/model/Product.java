/*
 * 1
 */

package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"rentals"})
@EqualsAndHashCode
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue
    private long id;
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
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals;


}
