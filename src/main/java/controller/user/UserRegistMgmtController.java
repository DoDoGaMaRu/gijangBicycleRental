package controller.user;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class UserRegistMgmtController implements Controller{

    private final UserDAO userDAO = UserDAO.getInstance();

    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpUtil.forward(req, res, "/WEB-INF/view/user/userRegistMgmt.jsp");
    }

}
