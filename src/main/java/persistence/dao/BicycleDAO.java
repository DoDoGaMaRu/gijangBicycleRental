package persistence.dao;

import persistence.entity.Bicycle;

public class BicycleDAO extends DAO<Bicycle, Long> {
    public BicycleDAO() {
        super(Bicycle.class);
    }
}
