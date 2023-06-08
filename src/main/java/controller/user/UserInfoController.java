package controller.user;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserInfoController implements Controller {

    private final UserDAO userDAO = UserDAO.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String idParam = req.getParameter("serial");
        Long serial = null;

        if (idParam != null && !idParam.isEmpty()) {
            serial = Long.valueOf(idParam);
        }

        req.setAttribute("user", userDAO.findByKey(serial));
        HttpUtil.forward(req, res, "/WEB-INF/view/user/userInfo.jsp");
        // Todo 시리얼 입력 받고 해당하는 회원 정보 출력 하도록 바꿨음 확인 부탁
    }
}
