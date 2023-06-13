package controller.history;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.PaymentDAO;
import persistence.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaymentInfoController implements Controller {
    private final PaymentDAO paymentDAO = PaymentDAO.getInstance();
    private final UserDAO userDAO = UserDAO.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String idParam = req.getParameter("serial");
        Long serial = null;

        if (idParam != null && !idParam.isEmpty()) {
            serial = Long.valueOf(idParam);
            req.setAttribute("user", userDAO.findByKey(serial));
            req.setAttribute("payments", paymentDAO.findAll());
        }

        HttpUtil.forward(req, res, "/WEB-INF/view/history/paymentInfo.jsp");
    }
}
