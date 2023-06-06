package controller.user;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.UserDAO;
import persistence.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserMinorsRegistController implements Controller {
    private final UserDAO userDAO = UserDAO.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getMethod().equals("GET")) {
            HttpUtil.forward(req, res, "/WEB-INF/view/user/userMinorsRegist.jsp");
        }
        else if (req.getMethod().equals("POST")) {
            registOK(req, res);
        }
    }

    private void registOK(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = User.builder()
                .id(req.getParameter("id"))
                .pw(req.getParameter("pw"))
                //.birthDate(req.getParameter())
                // Todo Date 어떻게 받아올지 생각
                .name(req.getParameter("name"))
                .phone(req.getParameter("phone"))
                .email(req.getParameter("email"))
                .address(req.getParameter("address"))
                .parentPhone(req.getParameter("parentPhone"))
                .build();
        userDAO.create(user);

        HttpUtil.forward(req, res, "/WEB-INF/view/user/userRegistMgmt.jsp");
    }
}
