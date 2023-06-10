package persistence.dao;

import persistence.entity.Qna;

import javax.persistence.Query;
import java.util.List;

public class QnaDAO extends DAO<Qna, Long>{
    private static QnaDAO qnaDAO;

    public static QnaDAO getInstance(){
        if (qnaDAO == null) {
            qnaDAO = new QnaDAO();
        }
        return qnaDAO;
    }

    private QnaDAO() {
        super(Qna.class);
    }

    public List<Qna> findAllByQuestionIdIsNull() {
        return (List<Qna>) execQuery(em -> {
            Query query = em.createQuery("SELECT t FROM Qna t WHERE t.qna IS NULL");
            return query.getResultList();
        });
    }

}
