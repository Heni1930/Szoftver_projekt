/*
 * 1
 */

package org.example;

import java.util.Date;

public class Borrowing {
    private int id;
    private int userId;
    private int equipmentName;
    private Date borrowDate;
    private Date returnDate;


    public Borrowing(int id, int userId, int equipmentName, Date borrowDate, Date returnDate) {
        this.id = id;
        this.userId = userId;
        this.equipmentName = equipmentName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
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

    public int getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(int equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
