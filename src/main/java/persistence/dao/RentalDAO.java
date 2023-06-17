package persistence.dao;

import persistence.entity.Rental;
import persistence.entity.User;

import javax.persistence.Query;

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

    public Rental findCurrentRental(User user) {
        return (Rental) execQuery (em -> {
            try {
                Query query = em.createQuery("SELECT t FROM Rental t WHERE t.endTime IS NULL AND t.user=:user");
                query.setParameter("user", user);
                return query.getSingleResult();
            }
            catch (Exception e) {
                return null;
            }
        });
    }
}
