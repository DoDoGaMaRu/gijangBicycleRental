package controller.rental;

import controller.Controller;
import controller.HttpUtil;
import persistence.dao.RentalDAO;
import persistence.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RentalStateController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpUtil.forward(req, res, "/WEB-INF/view/rental/rentalState.jsp");
    }

}
