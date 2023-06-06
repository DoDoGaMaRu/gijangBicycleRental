package controller.notice;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.QnaDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoticeController implements Controller {
    private final QnaDAO qnaDAO = QnaDAO.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpUtil.forward(req, res, "/WEB-INF/view/notice/notice.jsp");
    }
}
