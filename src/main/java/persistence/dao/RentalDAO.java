package persistence.dao;

import persistence.entity.Rental;

public class RentalDAO extends DAO<Rental, Long>{
    private static RentalDAO rentalDAO;

    public static RentalDAO getInstance(){
        if (rentalDAO == null) {
            rentalDAO = new RentalDAO();
        }
        return rentalDAO;
    }

    private RentalDAO() {
        super(Rental.class);
    }
}
