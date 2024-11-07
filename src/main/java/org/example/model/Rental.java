/*
 * 1
 */

package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Rental {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private int equipmentId;
    private Date rentalDate;
    private Date returnDate;


    public Rental(int id, int userId, int equipmentId, Date rentalDate, Date returnDate) {
        this.id = id;
        this.userId = userId;
        this.equipmentId = equipmentId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Rental() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
