package persistence.dao;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import persistence.entity.Bicycle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BicycleDAOTest {
    @Test
    @Order(1)
    void create() {
        BicycleDAO bicycleDAO = new BicycleDAO();

        Bicycle b1 = Bicycle.builder()
                .state("normal")
                .station(null)
                .build();
        Bicycle b2 = Bicycle.builder()
                .state("breakdown")
                .station(null)
                .build();
        Bicycle b3 = Bicycle.builder()
                .state("normal")
                .station(null)
                .build();

        bicycleDAO.create(b1);
        bicycleDAO.create(b2);
        bicycleDAO.create(b3);
    }

    @Test
    @Order(2)
    void findByKey() {
        BicycleDAO bicycleDAO = new BicycleDAO();

        Bicycle b = bicycleDAO.findByKey(2L);

        System.out.println(b.getState());
    }

    @Test
    @Order(3)
    void findAllByKey() {
        BicycleDAO bicycleDAO = new BicycleDAO();

        List<Long> keys = new ArrayList<>();
        keys.add(2L); keys.add(3L);

        List<Bicycle> bicycles = bicycleDAO.findAllByKey(keys);
        for (Bicycle b : bicycles) {
            System.out.println(b.getState());
        }
    }

    @Test
    @Order(4)
    void findAllBy() {
        BicycleDAO bicycleDAO = new BicycleDAO();

        List<Bicycle> bicycles = bicycleDAO.findAllBy("state", "normal");
        for (Bicycle b : bicycles) {
            System.out.println(b.getState());
        }
    }

    @Test
    @Order(5)
    void findAll() {
        BicycleDAO bicycleDAO = new BicycleDAO();

        List<Bicycle> bicycles = bicycleDAO.findAll();
        for (Bicycle b : bicycles) {
            System.out.println(b.getState());
        }
    }

    @Test
    @Order(6)
    void delete() {
        BicycleDAO bicycleDAO = new BicycleDAO();

        Bicycle target = bicycleDAO.findByKey(1L);
        bicycleDAO.delete(target);

        // 삭제 확인
        List<Bicycle> bicycles = bicycleDAO.findAll();
        for (Bicycle b : bicycles) {
            System.out.println(b.getState());
        }
    }

    @Test
    @Order(7)
    void update() {
        BicycleDAO bicycleDAO = new BicycleDAO();

        Bicycle target = bicycleDAO.findByKey(3L);
        target.updateState("breakdown");

        bicycleDAO.update(target);

        System.out.println(target.getState());
    }
}