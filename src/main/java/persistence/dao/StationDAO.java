package persistence.dao;

import persistence.entity.Station;

public class StationDAO extends DAO<Station, Long>{
    private static StationDAO stationDAO;

    public static StationDAO getInstance(){
        if (stationDAO == null) {
            stationDAO = new StationDAO();
        }
        return stationDAO;
    }

    private StationDAO() {
        super(Station.class);
    }
}
