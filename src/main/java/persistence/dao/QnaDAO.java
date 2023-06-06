package persistence.dao;

import persistence.entity.Qna;

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
}
