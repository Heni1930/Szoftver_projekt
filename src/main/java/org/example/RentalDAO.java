package org.example;

import java.util.List;

public interface RentalDAO {
    public void save(Rental rental);
    public Rental getRentalById(int id);
    public List<Rental> getAllRentals();
    public void updateRental(Rental rental);
    public void deleteRental(Rental rental);
}
