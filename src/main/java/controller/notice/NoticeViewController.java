package controller.notice;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.QnaDAO;
import persistence.entity.Station;
import persistence.entity.Qna;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoticeViewController implements Controller {
    private final QnaDAO qnaDAO = QnaDAO.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(req.getMethod().equals("GET")) {
            HttpUtil.forward(req, res, "/WEB-INF/view/notice/noticeInfo.jsp");
        } else if(req.getMethod().equals("POST")) {
            registOK(req, res);
        }
    }

    private void registOK(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
