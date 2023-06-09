package controller.notice;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.QnaDAO;
import persistence.dao.UserDAO;
import persistence.entity.Qna;
import persistence.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class NoticeViewController implements Controller {
    private final QnaDAO qnaDAO = QnaDAO.getInstance();
    private final UserDAO userDAO = UserDAO.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("qna", qnaDAO.findByKey(id));
        Qna question = qnaDAO.findByKey(id);
        req.setAttribute("answer", qnaDAO.findBy("qna", question));

        if (req.getMethod().equals("GET")) {
            HttpUtil.forward(req, res, "/WEB-INF/view/notice/noticeInfo.jsp");
        } else if(req.getMethod().equals("POST")) {
            registOK(req, res);
        }
    }

    private void registOK(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Qna qna = qnaDAO.findByKey(id);
        User user = userDAO.findByKey(1L);

        Qna answer = Qna.builder()
                .regdate(LocalDateTime.now())
                .title("Re" + qna.getTitle())
                .info(req.getParameter("info"))
                .qna(qna)
                .user(user)
                .build();

        String alertMessage = (qnaDAO.create(answer) != null) ? "답변이 등록되었습니다." : "답변 등록에 실패하였습니다.";
        String redirectPath = "/gijangBicycleRental/notice/view.do?id=" + qna.getId();

        res.setContentType("text/html; charset=utf-8");
        res.getWriter().printf("<script>alert('%s'); location.href='%s';</script>", alertMessage, redirectPath);
        res.getWriter().flush();
    }
}
