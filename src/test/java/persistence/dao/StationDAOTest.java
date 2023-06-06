package persistence.dao;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import persistence.entity.Bicycle;
import persistence.entity.Station;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StationDAOTest {
    @Test
    @Order(1)
    void create() {
        StationDAO dao = StationDAO.getInstance();

        Station entity = Station.builder()
                .name("1234")
                .coordinate("1234")
                .address("1234")
                .build();

        dao.create(entity);
    }

    @Test
    @Order(2)
    void findByKey() {
    }

    @Test
    @Order(3)
    void findAllByKey() {
    }

    @Test
    @Order(4)
    void findAllBy() {
    }

    @Test
    @Order(5)
    void findAll() {
    }

    @Test
    @Order(6)
    void delete() {
    }

    @Test
    @Order(7)
    void update() {
    }
}