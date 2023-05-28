package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {
    private final SqlSessionFactory sqlSessionFactory;

    public DAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    protected Object execQuery(Executable<Object> exec) {
        Object res = new ArrayList<>();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            res = exec.run(session);
            session.commit();
        }
        catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return res;
    }
}
