/*
 * 1
 */

package org.example;



import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "User ID cannot be null!")
    @ManyToOne
    @JoinColumn(name = "CustomerID")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Customer customerId;
    @NotNull(message = "product ID cannot be null!")
    @ManyToOne
    @JoinColumn(name = "productID")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Product productId;
    @NotNull(message = "Rental date cannot be null!")
    @FutureOrPresent
    @Column
    private Date rentalDate;
    @Future
    @Column
    private Date returnDate;




}
