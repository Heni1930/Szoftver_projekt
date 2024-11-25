package org.example;

public class RentalUtils {
    private RentalDAO rDAO;
    private RentalUtils(RentalDAO rDAO) {this.rDAO = rDAO;}

    public void runUtils()
    {
        Rental teszt = new Rental();
        rDAO.save(teszt);
    }
}
