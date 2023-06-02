package persistence.dao;

import persistence.entity.Station;

public class StationDAO extends DAO<Station, Long>{
    public StationDAO() {
        super(Station.class);
    }
}
