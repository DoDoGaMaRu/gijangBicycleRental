package persistence.dao;

import persistence.entity.Bicycle;

public class BicycleDAO extends DAO<Bicycle, Long> {
    private static BicycleDAO bicycleDAO;

    public static BicycleDAO getInstance(){
        if (bicycleDAO == null) {
            bicycleDAO = new BicycleDAO();
        }
        return bicycleDAO;
    }

    private BicycleDAO() {
        super(Bicycle.class);
    }
}
