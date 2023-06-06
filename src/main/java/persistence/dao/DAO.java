package persistence.dao;

import persistence.CEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T, K> {
    private Class<T> entityClass;

    public DAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected Object execQuery(Executable<Object> query) {
        Object res = null;

        // set entity transaction
        EntityManager em = CEntityManagerFactory.createEntityManger();
        EntityTransaction et = em.getTransaction();

        // try query
        try {
            et.begin();
            res = query.exec(em);
            et.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        }
        finally {
            em.close();
        }

        return res;
    }


    public T create(T entity) {
        return (T) execQuery(em -> {
            em.persist(entity);
            return entity;
        });
    }

    public T findByKey(K key) {
        return (T) execQuery(em -> {
            return em.find(entityClass, key);
        });
    }

    public List<T> findAllByKey(Iterable<K> keys) {
        return (List<T>) execQuery(em -> {
            List<T> res = new ArrayList<>();
            for (K key : keys) {
                res.add(em.find(entityClass, key));
            }
            return res;
        });
    }

    public List<T> findAllBy(String column, Object value) {
        return (List<T>) execQuery(em -> {
            Query query = em.createQuery("SELECT t FROM "+ entityClass.getSimpleName() +" t WHERE t."+column+"=:"+column);
            query.setParameter(column, value);
            return query.getResultList();
        });
    }

    public List<T> findAll() {
        return (List<T>) execQuery(em -> {
            Query query = em.createQuery("SELECT b FROM "+ entityClass.getSimpleName() +" b");
            return query.getResultList();
        });
    }

    public void delete(T entity) {
        execQuery(em -> {
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            return null;
        });
    }

    public T update(T entity) {
        return (T) execQuery(em -> {
            return em.merge(entity);
        });
    }
}
