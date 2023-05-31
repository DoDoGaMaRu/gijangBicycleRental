package persistence.dao;

import persistence.entity.Qna;

public class QnaDAO extends DAO<Qna, Long>{
    public QnaDAO() {
        super(Qna.class);
    }
}
