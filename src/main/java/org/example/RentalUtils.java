package org.example;

import java.util.List;

public class RentalUtils {
    private static RentalDAO rDAO;

    private RentalUtils() {}

    static {
        rDAO = new JPARentalDAO(); {
        }
    }

    public static void initialize(RentalDAO rentalDAO) {
        if (rDAO == null) {
            rDAO = rentalDAO;
        }
        else {
            throw new IllegalStateException("RentalUtils is already initialized.");
        }
    }
    public static void SaveRental(Rental rental) {
        if (rDAO == null) {
            throw new IllegalStateException("RentalDAO is not initialized. Call RentalUtils.initialize() first.");
        }
        rDAO.save(rental);
    }
}
