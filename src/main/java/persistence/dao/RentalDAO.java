package persistence.dao;

import persistence.entity.Rental;

public class RentalDAO extends DAO<Rental, Long>{
    public RentalDAO() {
        super(Rental.class);
    }
}
