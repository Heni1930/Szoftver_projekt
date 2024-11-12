/*
 * 1
 */

package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotNull(message = "User ID cannot be null!")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer userId;
    @NotNull(message = "product ID cannot be null!")
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;
    @NotNull(message = "Rental date cannot be null!")
    @FutureOrPresent
    @Column(name = "rental_date")
    private Date rentalDate;
    @Future
    @Column(name = "return_date")
    private Date returnDate;





}
