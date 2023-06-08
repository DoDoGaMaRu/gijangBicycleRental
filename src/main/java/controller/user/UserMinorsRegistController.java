package controller.user;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.UserDAO;
import persistence.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

        res.setContentType("text/html; charset=utf-8");

        String birthDateStr = req.getParameter("birthDate");
        LocalDate birthDate = null;

        List<User> users = userDAO.findAllBy("id", req.getParameter("id"));

        birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ISO_DATE);

        User user = User.builder()
                .id(req.getParameter("id"))
                .pw(req.getParameter("pw"))
                .name(req.getParameter("name"))
                .email(req.getParameter("email"))
                .birthDate(birthDate)
                .address(req.getParameter("address"))
                .phone(req.getParameter("phone"))
                .parentPhone(req.getParameter("parentPhone"))
                .build();

        String duplicatecAlertMessage;

        if(users.size() == 0) {
            duplicatecAlertMessage = "사용 가능한 아이디입니다.";
            res.getWriter().printf("<script>alert('%s'); </script>", duplicatecAlertMessage);
        }
        else {
            duplicatecAlertMessage = "사용 중인 아이디입니다.";
            res.getWriter().printf("<script>alert('%s'); </script>", duplicatecAlertMessage);
            user = null;
        }

        String userAlertMessage = (userDAO.create(user) != null) ? "회원가입이 완료되었습니다.":"회원가입에 실패했습니다.";
        String userRedirectPath = "/gijangBicycleRental/user.do";

        res.setContentType("text/html; charset=utf-8");
        res.getWriter().printf("<script>alert('%s'); </script>", userAlertMessage);
        res.getWriter().printf("<script>location.href='%s';</script>", userRedirectPath);
        res.getWriter().flush();

        HttpUtil.forward(req, res, "/WEB-INF/view/user/user.jsp");
    }
}
