/*
 * 1
 */

package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue
    private int id;
    @NotNull(message = "User ID cannot be null!")
    private int userId;
    @NotNull(message = "product ID cannot be null!")
    private int productId;
    @NotNull(message = "Rental date cannot be null!")
    @FutureOrPresent
    private Date rentalDate;
    @Future
    private Date returnDate;

    public Rental(int id, int userId, int productId, Date rentalDate, Date returnDate) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Rental() {

    }

    @NotNull(message = "User ID cannot be null!")
    public int getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "User ID cannot be null!") int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "Rental date cannot be null!") @FutureOrPresent Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(@NotNull(message = "Rental date cannot be null!") @FutureOrPresent Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    @NotNull(message = "product ID cannot be null!")
    public int getProductId() {
        return productId;
    }

    public void setProductId(@NotNull(message = "product ID cannot be null!") int productId) {
        this.productId = productId;
    }

    public @Future Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(@Future Date returnDate) {
        this.returnDate = returnDate;
    }





}
