package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CEntityManagerFactory {
    private static EntityManagerFactory entityManagerFactory;

    public static void initialization(){
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }

    public static EntityManager createEntityManger(){
        if (entityManagerFactory == null) {
            initialization();
        }
        return entityManagerFactory.createEntityManager();
    }

    public static void close(){
        entityManagerFactory.close();
    }
}